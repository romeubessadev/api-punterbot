package br.com.touros.punterbot.api.service;

import br.com.touros.punterbot.api.controller.request.AtualizarNomeRequest;
import br.com.touros.punterbot.api.core.persistence.GenericService;
import br.com.touros.punterbot.api.exceptions.ValidException;
import br.com.touros.punterbot.api.model.cadastro.Liga;
import br.com.touros.punterbot.api.model.cadastro.Temporada;
import br.com.touros.punterbot.api.repository.LigaRepository;
import br.com.touros.punterbot.api.service.interfaces.ILigaService;
import br.com.touros.punterbot.api.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Service
public class LigaService extends GenericService<Liga, Long, LigaRepository> implements ILigaService {
    public LigaService(LigaRepository repository) {
        super(repository, Liga.class);
    }

    @Override
    public Stream<Temporada> buscarTemporadas(Boolean apenasAtuais) {
        return getRepository()
                .findAll()
                .stream()
                .map(LigaService::getTemporada)
                .flatMap(List::stream)
                .filter(temporada -> apenasAtuais && temporada.getAtualTemporada());
    }

    private static List<Temporada> getTemporada(Liga liga) {
        return Utils.isNullOrEmpty(liga.getTemporadas()) ? Collections.emptyList() : liga.getTemporadas();
    }

    @Override
    public void atualizar(AtualizarNomeRequest atualizarNomeRequest) {
        var liga = buscarPorId(atualizarNomeRequest.getId());
        if (Utils.isNull(liga)) {
            throw new ValidException("Liga", "Não existe liga com esse código");
        }

        liga.setNome(atualizarNomeRequest.getNome());
        salvar(liga);
    }
}
