package br.com.touros.punterbot.api.scrapper;

import br.com.touros.punterbot.api.controller.request.ExtracaoRequestEnum;
import org.springframework.scheduling.annotation.Async;

public interface IExtracaoComponent {
    @Async
    void extrairLigas();

    @Async
    void extrairTimes();

    @Async
    void efetuarExtracao(ExtracaoRequestEnum extracaoRequestEnum);
}
