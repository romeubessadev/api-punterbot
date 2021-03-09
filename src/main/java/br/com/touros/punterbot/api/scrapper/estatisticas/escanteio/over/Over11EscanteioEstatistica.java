package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.over;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IOverEscanteio;

public class Over11EscanteioEstatistica  implements IOverEscanteio {

    @Override
    public String nome() {
        return "Over 11";
    }

    @Override
    public Integer qtdEscanteioMinimo() {
        return 11;
    }

    @Override
    public String chave() {
        return "OVER_11";
    }

}
