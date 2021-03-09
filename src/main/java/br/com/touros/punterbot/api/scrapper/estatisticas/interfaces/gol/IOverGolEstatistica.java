package br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.gol;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.IEstatistica;

public interface IOverGolEstatistica extends IEstatistica {
    Integer qtdGolsMinimo();

    Integer minutoMinimo();

    Integer minutoMaximo();
}
