package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.ht;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;

public class HTLimiteEscanteioEstatistica implements IHtFtEscanteio {

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
        return "HT Limite";
    }

    @Override
    public String chave() {
        return "HT_LIMITE";
    }
}
