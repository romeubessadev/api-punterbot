package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.ht;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;

public class HT50EscanteioEstatistica implements IHtFtEscanteio {

    @Override
    public Integer minutoMinimo() {
        return 50;
    }

    @Override
    public Integer minutoMaximo() {
        return 59;
    }

    @Override
    public String nome() {
        return "HT50";
    }
    @Override
    public String chave() {
        return "HT_50";
    }
}
