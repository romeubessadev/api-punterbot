package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.over;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IOverEscanteio;

public class Over7EscanteioEstatistica implements IOverEscanteio {

    @Override
    public String nome() {
        return "Over 7";
    }

    @Override
    public Integer qtdEscanteioMinimo() {
        return 7;
    }

    @Override
    public String chave() {
        return "OVER_7";
    }
}
