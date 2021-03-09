package br.com.touros.punterbot.api.scrapper.estatisticas.gol.over;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.gol.IOverGolEstatistica;

public class Over1_5FTGolsEstatistica implements IOverGolEstatistica {

    @Override
    public Integer minutoMaximo() {
        return 90;
    }

    @Override
    public Integer qtdGolsMinimo() {
        return 2;
    }

    @Override
    public Integer minutoMinimo() {
        return 0;
    }

    @Override
    public String nome() {
        return "Over 1.5 FT";
    }

    @Override
    public String chave() {
        return "OVER_1_5_FT";
    }
}
