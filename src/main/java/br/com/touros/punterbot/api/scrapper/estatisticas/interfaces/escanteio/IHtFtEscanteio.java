package br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.IEstatistica;

public interface IHtFtEscanteio extends IEstatistica {

    Integer minutoMinimo();

    Integer minutoMaximo();

}