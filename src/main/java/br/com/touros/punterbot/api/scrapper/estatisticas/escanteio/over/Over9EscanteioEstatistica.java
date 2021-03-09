package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.over;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IOverEscanteio;

public class Over9EscanteioEstatistica implements IOverEscanteio {

        @Override
    public String nome() {
        return "Over 9";
    }

    @Override
    public Integer qtdEscanteioMinimo() {
        return 9;
    }

    @Override
    public String chave() {
        return "OVER_9";
    }
}
