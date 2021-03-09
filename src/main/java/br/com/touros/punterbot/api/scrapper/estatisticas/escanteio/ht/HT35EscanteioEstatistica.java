package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.ht;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;

public class HT35EscanteioEstatistica implements IHtFtEscanteio {

    @Override
    public Integer minutoMinimo() {
        return 35;
    }

    @Override
    public Integer minutoMaximo() {
        return 45;
    }

    @Override
    public String nome() {
        return "HT35";
    }

    @Override
    public String chave() {
        return "HT_35";
    }
}
