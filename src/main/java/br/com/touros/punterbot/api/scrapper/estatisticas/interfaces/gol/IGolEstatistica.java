package br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.gol;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.IEstatistica;

public interface IGolEstatistica extends IEstatistica {
    Integer minutoMinimo();

    Integer minutoMaximo();
}
