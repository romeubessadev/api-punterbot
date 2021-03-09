package br.com.touros.punterbot.api.scrapper;

import br.com.touros.punterbot.api.controller.request.ExtracaoRequestEnum;
import br.com.touros.punterbot.api.integracao.sportmonks.ISportMonksRestApi;
import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.model.cadastro.Liga;
import br.com.touros.punterbot.api.model.cadastro.Time;
import br.com.touros.punterbot.api.scrapper.analise.JogosAnalise;
import br.com.touros.punterbot.api.scrapper.analise.jogo.JogoAnaliseBuilder;
import br.com.touros.punterbot.api.service.interfaces.IJogoService;
import br.com.touros.punterbot.api.service.interfaces.ILigaService;
import br.com.touros.punterbot.api.service.interfaces.ITimeService;
import br.com.touros.punterbot.api.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ExtracaoComponent implements IExtracaoComponent {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExtracaoComponent.class);

    private final ISportMonksRestApi sportMonksRestApi;
    private final IJogoService jogoService;
    private final ILigaService ligaService;
    private final ITimeService timeService;

    public ExtracaoComponent(ISportMonksRestApi sportMonksRestApi, IJogoService jogoService, ILigaService ligaService, ITimeService timeService) {
        this.sportMonksRestApi = sportMonksRestApi;
        this.jogoService = jogoService;
        this.ligaService = ligaService;
        this.timeService = timeService;
    }

    @Async
    @Override
    public void extrairLigas() {
        LOGGER.info("Extração de liga iniciada");
        extrairLigas(0);
        LOGGER.info("Extração de liga finalizada");
    }

    @Async
    @Override
    public void extrairTimes() {
        LOGGER.info("Extração de time iniciada");
        ligaService.buscarTemporadas(true)
                .forEach(temporada -> {
                    LOGGER.info("Buscando jogos da temporada {}", temporada.getId());
                    var times = sportMonksRestApi
                            .buscarTimesDaSeason(temporada.getId())
                            .stream()
                            .filter(team -> !timeService.existePorId(team.getId()))
                            .map(Time::new)
                            .collect(Collectors.toList());

                    if (!Utils.isNullOrEmpty(times)) {
                        LOGGER.info("Salvando {} times", times.size());
                        timeService.salvar(times);
                    } else {
                        LOGGER.info("...");
                    }
                });
        LOGGER.info("Extração de times finalizada");
    }

    private void extrairLigas(Integer page) {
        LOGGER.info("Extração de liga pagina {}", page);

        var list = sportMonksRestApi.buscarLigas(page)
                .stream()
                .map(Liga::new)
                .collect(Collectors.toList());

        if (!Utils.isNullOrEmpty(list)) {
            ligaService.salvar(list);
            extrairLigas(page + 1);
        }
    }

    @Async
    @Override
    public void efetuarExtracao(ExtracaoRequestEnum extracaoRequestEnum) {
        extrair(extracaoRequestEnum.getJogo());
    }

    private void extrair(JogoAnaliseBuilder<?> jogoAnaliseBuilderj) {
        LOGGER.info("Efetuando Extração");

        JogosAnalise
                .NovaAnalise()
                .buscarJogo(jogoAnaliseBuilderj)
                .executar()
                .forEach(this::salvarJogo);

        LOGGER.info("Extração Efetuada com Sucesso");
    }

    private void salvarJogo(Jogo jogo) {
        LOGGER.info("Salvando Jogo {}", jogo.getNomeTimes());
        try {
            jogoService.salvar(jogo);
        } catch (Exception ex) {
            LOGGER.error("Não foi possível salvar o Jogo {}", jogo.getNomeTimes());
            LOGGER.error("500 ERROR", ex);
        }
    }
}
