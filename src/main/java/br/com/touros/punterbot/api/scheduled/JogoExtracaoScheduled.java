package br.com.touros.punterbot.api.scheduled;

import br.com.touros.punterbot.api.controller.request.ExtracaoRequestEnum;
import br.com.touros.punterbot.api.scrapper.IExtracaoComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JogoExtracaoScheduled {
    private final static Logger LOGGER = LoggerFactory.getLogger(JogoExtracaoScheduled.class);

    private final IExtracaoComponent extracaoComponent;

    public JogoExtracaoScheduled(IExtracaoComponent extracaoComponent) {
        this.extracaoComponent = extracaoComponent;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void extracaoJogosDeHoje() {
        LOGGER.info("INICIANDO EXTRAÇÃO JOGOS DE HOJE");
        extracaoComponent.efetuarExtracao(ExtracaoRequestEnum.HOJE);
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void extracaoJogosAmanha() {
        LOGGER.info("INICIANDO EXTRAÇÃO JOGOS DE AMANHA");
        extracaoComponent.efetuarExtracao(ExtracaoRequestEnum.AMANHA);
    }
}
