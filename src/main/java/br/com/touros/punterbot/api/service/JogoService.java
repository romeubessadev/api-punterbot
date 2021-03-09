package br.com.touros.punterbot.api.service;

import br.com.touros.punterbot.api.controller.request.PesquisaEstrategiaRequest;
import br.com.touros.punterbot.api.controller.request.TipoPesquisa;
import br.com.touros.punterbot.api.controller.response.JogoPorLigaResponse;
import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.repository.JogoRepository;
import br.com.touros.punterbot.api.service.interfaces.IJogoService;
import br.com.touros.punterbot.api.utils.Utils;
import com.mongodb.Function;
import com.mongodb.client.AggregateIterable;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.*;

@Service
public class JogoService implements IJogoService {

    private final static Bson GROUP = group("$liga._id", sum("total", 1L),
            first("nome", "$liga.nome"),
            first("logo", "$liga.logo"),
            push("jogos", and(eq("data", "$data.dataInicio"),
                    eq("id", "$_id"),
                    eq("situacao", "$data.situacao"),
                    eq("timeCasa", and(eq("id", "$timeCasa._id"), eq("nome", "$timeCasa.nome"), eq("logo", "$timeCasa.logo"))),
                    eq("timeVisita", and(eq("id", "$timeVisita._id"), eq("nome", "$timeVisita.nome"), eq("logo", "$timeVisita.logo")))
            )));
    private final JogoRepository jogoRepository;
    private final MongoTemplate mongoTemplate;

    public JogoService(JogoRepository jogoRepository, MongoTemplate mongoTemplate) {
        this.jogoRepository = jogoRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void salvar(Jogo jogo) {
        jogoRepository.save(jogo);
    }

    @Override
    public Jogo buscarJogoPorId(Long jogoId) {
        return jogoRepository.findById(jogoId).orElse(null);
    }

    @Override
    public List<Jogo> buscaPaginada(Integer page, Integer size) {
        Query query = new Query();

        query.skip(page * size);
        query.limit(size);
        query.with(Sort.by(Sort.Direction.ASC, "data.dataInicio"));
        query.fields().exclude("timeCasa.estatistica");
        query.fields().exclude("timeCasa.ultimosJogos");
        query.fields().exclude("timeVisita.estatistica");
        query.fields().exclude("timeVisita.ultimosJogos");

        return mongoTemplate.find(query, Jogo.class);
    }

    @Override
    public List<JogoPorLigaResponse> buscaAgrupada(TipoPesquisa tipoPesquisa, PesquisaEstrategiaRequest request, Integer page, Integer size) {
        var matchEstatitisca = filtroEstatistica(request);

        var listaAgregate = new ArrayList<Bson>();

        if (!Utils.isNull(matchEstatitisca)) {
            listaAgregate.add(matchEstatitisca);
        }

        listaAgregate.add(tipoPesquisa(tipoPesquisa));
        listaAgregate.add(GROUP);
        listaAgregate.add(skip(page * size));
        listaAgregate.add(limit(size));

        AggregateIterable<Document> result = mongoTemplate.getCollection("jogo").aggregate(listaAgregate);
        return iterate(result, JogoPorLigaResponse::new);
    }

    private Bson filtroEstatistica(PesquisaEstrategiaRequest request) {
        if (Utils.isNullOrEmpty(request.getEscanteios()) && Utils.isNullOrEmpty(request.getGols()))
            return null;

        var list = new ArrayList<Bson>();

        if (!Utils.isNullOrEmpty(request.getEscanteios())) {
            list.add(and(
                    request.getEscanteios().stream()
                            .map(pesquisaEstrategia -> eqEstatistica("escanteios", pesquisaEstrategia.getLiga(), pesquisaEstrategia.getChave(), pesquisaEstrategia.getValor()))
                            .collect(Collectors.toList()))
            );
        }
        if (!Utils.isNullOrEmpty(request.getGols())) {
            list.add(and(
                    request.getGols().stream()
                            .map(pesquisaEstrategia -> eqEstatistica("gols", pesquisaEstrategia.getLiga(), pesquisaEstrategia.getChave(), pesquisaEstrategia.getValor()))
                            .collect(Collectors.toList()))
            );
        }
        return match(and(list));
    }

    private static Bson eqEstatistica(String agrupador, Boolean liga, String chave, Integer valor) {
        return eq("timeCasa.estatistica." + agrupador + "." + (liga ? "liga." : "geral.") + chave + ".mediaTotal", valor);
    }

    private Bson tipoPesquisa(TipoPesquisa tipoPesquisa) {
        Date dateGte = new Date();
        Date dateLt = new Date();
        switch (tipoPesquisa) {
            case HOJE: {
                dateGte = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                dateLt = Date.from(LocalDate.now().atTime(23, 59, 59).atZone(ZoneId.systemDefault()).toInstant());
                break;
            }
            case AMANHA: {
                dateGte = Date.from(LocalDate.now().plusDays(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                dateLt = Date.from(LocalDate.now().plusDays(1).atTime(23, 59, 59).atZone(ZoneId.systemDefault()).toInstant());
                break;
            }
            case AO_VIVO: {
                break;
            }
        }
        return match(
                and(gte("data.dataInicio", dateGte),
                        lt("data.dataInicio", dateLt)
                ));
    }


    private <T> List<T> iterate(AggregateIterable<Document> aggregateIterable, Function<Document, T> function) {
        List<T> list = new ArrayList<>();
        for (Document doc : aggregateIterable) {
            list.add(function.apply(doc));
        }
        return list;
    }
}
