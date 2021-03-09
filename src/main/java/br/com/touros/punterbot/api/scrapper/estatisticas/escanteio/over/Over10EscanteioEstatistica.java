package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.over;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IOverEscanteio;

public class Over10EscanteioEstatistica  implements IOverEscanteio {

    @Override
    public String nome() {
        return "Over 10";
    }

    @Override
    public Integer qtdEscanteioMinimo() {
        return 10;
    }

    @Override
    public String chave() {
        return "OVER_10";
    }
}
