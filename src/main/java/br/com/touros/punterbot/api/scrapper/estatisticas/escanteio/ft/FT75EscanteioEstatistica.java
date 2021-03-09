package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.ft;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;

public class FT75EscanteioEstatistica implements IHtFtEscanteio {

    @Override
    public Integer minutoMinimo() {
        return 75;
    }

    @Override
    public Integer minutoMaximo() {
        return 90;
    }

    @Override
    public String nome() {
        return "FT75";
    }

    @Override
    public String chave() {
        return "FT_75";
    }
}
