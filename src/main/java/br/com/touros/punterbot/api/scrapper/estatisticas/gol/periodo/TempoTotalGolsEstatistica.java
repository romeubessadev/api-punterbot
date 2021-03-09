package br.com.touros.punterbot.api.scrapper.estatisticas.gol.periodo;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.gol.IGolEstatistica;

public class TempoTotalGolsEstatistica implements IGolEstatistica {

    @Override
    public Integer minutoMinimo() {
        return 0;
    }

    @Override
    public Integer minutoMaximo() {
        return 90;
    }

    @Override
    public String nome() {
        return "Gols Média Tempo Total";
    }

    @Override
    public String chave() {
        return "GOL_TEMPO_TOTAL";
    }
}
