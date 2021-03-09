package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.periodo;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;

public class SegundoTempoEscanteioEstatistica implements IHtFtEscanteio {
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
        return "Escanteio Média 2 Tempo";
    }


    @Override
    public String chave() {
        return "ESCANTEIO_2_TEMPO";
    }

}
