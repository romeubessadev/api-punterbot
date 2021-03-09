package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.ht;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;

public class HT20EscanteioEstatistica implements IHtFtEscanteio {

    @Override
    public Integer minutoMinimo() {
        return 10;
    }

    @Override
    public Integer minutoMaximo() {
        return 19;
    }

    @Override
    public String nome() {
        return "HT20";
    }
    @Override
    public String chave() {
        return "HT_20";
    }
}
