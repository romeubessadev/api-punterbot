package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.ht;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;

public class HT38EscanteioEstatistica implements IHtFtEscanteio {

    @Override
    public Integer minutoMinimo() {
        return 38;
    }

    @Override
    public Integer minutoMaximo() {
        return 45;
    }

    @Override
    public String nome() {
        return "HT38";
    }

    @Override
    public String chave() {
        return "HT_38";
    }
}
