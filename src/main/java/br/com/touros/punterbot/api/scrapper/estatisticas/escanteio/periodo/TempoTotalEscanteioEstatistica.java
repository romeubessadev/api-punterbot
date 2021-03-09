package br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.periodo;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;

public class TempoTotalEscanteioEstatistica implements IHtFtEscanteio {

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
        return "Escanteio Média Tempo Total";
    }

    @Override
    public String chave() {
        return "ESCANTEIO_TEMPO_TOTAL";
    }
}
