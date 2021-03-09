package br.com.touros.punterbot.api.scrapper.estatisticas.gol.periodo;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.gol.IGolEstatistica;

public class PrimeiroTempoGolsEstatistica implements IGolEstatistica {

    @Override
    public Integer minutoMaximo() {
        return 45;
    }

    @Override
    public Integer minutoMinimo() {
        return 0;
    }

    @Override
    public String nome() {
        return "Gols Média 1 Tempo";
    }
    @Override
    public String chave() {
        return "GOL_1_TEMPO";
    }

}
