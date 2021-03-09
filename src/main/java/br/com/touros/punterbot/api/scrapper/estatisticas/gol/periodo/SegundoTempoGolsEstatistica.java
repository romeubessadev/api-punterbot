package br.com.touros.punterbot.api.scrapper.estatisticas.gol.periodo;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.gol.IGolEstatistica;

public class SegundoTempoGolsEstatistica implements IGolEstatistica {
    @Override
    public Integer minutoMaximo() {
        return 90;
    }

    @Override
    public Integer minutoMinimo() {
        return 46;
    }

    @Override
    public String nome() {
        return "Gols Média 2 Tempo";
    }

    @Override
    public String chave() {
        return "GOL_2_TEMPO";
    }
}
