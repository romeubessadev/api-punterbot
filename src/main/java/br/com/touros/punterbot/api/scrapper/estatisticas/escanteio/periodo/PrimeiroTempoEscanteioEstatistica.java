package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.periodo;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;

public class PrimeiroTempoEscanteioEstatistica implements IHtFtEscanteio {
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
        return "Escanteio Média 1 Tempo";
    }

    @Override
    public String chave() {
        return "ESCANTEIO_1_TEMPO";
    }

}
