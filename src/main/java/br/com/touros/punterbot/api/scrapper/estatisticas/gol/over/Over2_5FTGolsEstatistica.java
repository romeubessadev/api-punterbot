package br.com.touros.punterbot.api.scrapper.estatisticas.gol.over;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.gol.IOverGolEstatistica;

public class Over2_5FTGolsEstatistica implements IOverGolEstatistica {

    @Override
    public Integer minutoMaximo() {
        return 90;
    }

    @Override
    public Integer qtdGolsMinimo() {
        return 3;
    }

    @Override
    public Integer minutoMinimo() {
        return 0;
    }

    @Override
    public String nome() {
        return "Over 2.5 FT";
    }

    @Override
    public String chave() {
        return "OVER_2_5_FT";
    }

}
