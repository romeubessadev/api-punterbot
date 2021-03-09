package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.ft;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;

public class FTLimiteEscanteioEstatistica implements IHtFtEscanteio {

    @Override
    public Integer minutoMinimo() {
        return 88;
    }

    @Override
    public Integer minutoMaximo() {
        return 90;
    }

    @Override
    public String nome() {
        return "FT Limite";
    }

    @Override
    public String chave() {
        return "FT_LIMITE";
    }
}
