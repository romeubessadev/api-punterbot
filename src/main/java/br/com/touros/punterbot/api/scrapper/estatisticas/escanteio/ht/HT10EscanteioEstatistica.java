package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.ht;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;

public class HT10EscanteioEstatistica implements IHtFtEscanteio {

    @Override
    public Integer minutoMinimo() {
        return 0;
    }

    @Override
    public Integer minutoMaximo() {
        return 9;
    }

    @Override
    public String nome() {
        return "HT10";
    }

    @Override
    public String chave() {
        return "HT_10";
    }
}
