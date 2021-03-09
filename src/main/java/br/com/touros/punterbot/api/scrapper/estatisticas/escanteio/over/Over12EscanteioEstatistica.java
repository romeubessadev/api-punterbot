package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.over;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IOverEscanteio;

public class Over12EscanteioEstatistica  implements IOverEscanteio {

    @Override
    public String nome() {
        return "Over 12";
    }

    @Override
    public Integer qtdEscanteioMinimo() {
        return 12;
    }

    @Override
    public String chave() {
        return "OVER_12";
    }
}
