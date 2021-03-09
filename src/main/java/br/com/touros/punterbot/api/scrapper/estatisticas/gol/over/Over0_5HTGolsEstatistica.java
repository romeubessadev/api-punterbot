package br.com.touros.punterbot.api.scrapper.estatisticas.gol.over;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.gol.IOverGolEstatistica;

public class Over0_5HTGolsEstatistica implements IOverGolEstatistica {
    @Override
    public Integer minutoMaximo() {
        return 45;
    }

    @Override
    public Integer qtdGolsMinimo() {
        return 1;
    }

    @Override
    public Integer minutoMinimo() {
        return 0;
    }

    @Override
    public String nome() {
        return "Over 0.5 HT";
    }

    @Override
    public String chave() {
        return "OVER_05_HT";
    }
}
