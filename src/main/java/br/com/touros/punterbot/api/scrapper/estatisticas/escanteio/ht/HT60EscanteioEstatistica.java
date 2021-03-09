package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.ht;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;

public class HT60EscanteioEstatistica implements IHtFtEscanteio {

    @Override
    public Integer minutoMinimo() {
        return 60;
    }

    @Override
    public Integer minutoMaximo() {
        return 69;
    }

    @Override
    public String nome() {
        return "HT60";
    }

    @Override
    public String chave() {
        return "HT_60";
    }
}
