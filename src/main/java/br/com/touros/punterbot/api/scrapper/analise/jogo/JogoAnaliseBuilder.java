package br.com.touros.punterbot.api.scrapper.analise.jogo;

import br.com.touros.punterbot.api.integracao.sportmonks.ISportMonksRestApi;
import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.analise.IJogoParaAnalise;
import br.com.touros.punterbot.api.scrapper.analise.dePara.DeParaProcessor;
import br.com.touros.punterbot.api.scrapper.analise.dePara.DeParaProcessorFactory;
import br.com.touros.punterbot.api.scrapper.ScrapperInstancesFactory;
import br.com.touros.punterbot.api.scrapper.flow.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class JogoAnaliseBuilder<C extends Context<Jogo>> implements CriaContexto<C, Jogo> {
    private static final Logger LOGGER = LoggerFactory.getLogger(JogoAnaliseBuilder.class);

    protected abstract List<IJogoParaAnalise> buscarJogosParaAnalise();

    private final ISportMonksRestApi sportMonksRestApi;

    protected JogoAnaliseBuilder() {
        this.sportMonksRestApi = ScrapperInstancesFactory.getInstance().getSportMonksRestApi();
    }

    public List<Jogo> converterJogos() {
        LOGGER.info("{} Buscando Jogos", super.getClass().getSimpleName());
        List<IJogoParaAnalise> jogosParaAnalise = buscarJogosParaAnalise();

        if (jogosParaAnalise == null || jogosParaAnalise.size() == 0)
            return Collections.emptyList();

        LOGGER.info("{} Foram Encontrado {} Jogos", super.getClass().getSimpleName(), jogosParaAnalise.size());

        return jogosParaAnalise
                .stream()
                .map(JogoAnaliseBuilder::DePara)
                .collect(Collectors.toList());
    }

    private static Jogo DePara(IJogoParaAnalise IJogoParaAnalise) {
        DeParaProcessor<?> dePara = DeParaProcessorFactory.Generete(IJogoParaAnalise);
        dePara.jogo();
        dePara.liga();
        dePara.timeDeCasa();
        dePara.timeDeFora();
        return dePara.resultado();
    }

    public ISportMonksRestApi getSportMonksRestApi() {
        return sportMonksRestApi;
    }
}