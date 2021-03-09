package br.com.touros.punterbot.api.scrapper;

import br.com.touros.punterbot.api.integracao.sportmonks.ISportMonksRestApi;
import org.springframework.stereotype.Component;

@Component
public class ScrapperInstancesFactory {

    private static ScrapperInstancesFactory instance;

    private final ISportMonksRestApi sportMonksRestApi;

    public ScrapperInstancesFactory(ISportMonksRestApi sportMonksRestApi) {
        this.sportMonksRestApi = sportMonksRestApi;
        instance = this;
    }

    public static ScrapperInstancesFactory getInstance() {
        return instance;
    }

    public ISportMonksRestApi getSportMonksRestApi() {
        return sportMonksRestApi;
    }
}
