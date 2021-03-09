package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.ft;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;

public class FT82EscanteioEstatistica implements IHtFtEscanteio {

    @Override
    public Integer minutoMinimo() {
        return 82;
    }

    @Override
    public Integer minutoMaximo() {
        return 90;
    }

    @Override
    public String nome() {
        return "FT82";
    }

    @Override
    public String chave() {
        return "FT_82";
    }
}
