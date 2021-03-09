package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.over;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IOverEscanteio;

public class Over8EscanteioEstatistica implements IOverEscanteio {

    @Override
    public String nome() {
        return "Over 8";
    }

    @Override
    public Integer qtdEscanteioMinimo() {
        return 8;
    }

    @Override
    public String chave() {
        return "OVER_8";
    }
}
