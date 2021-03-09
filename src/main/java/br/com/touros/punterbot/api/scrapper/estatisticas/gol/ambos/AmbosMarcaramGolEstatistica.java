package br.com.touros.punterbot.api.scrapper.estatisticas.gol.ambos;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.IEstatistica;

public class AmbosMarcaramGolEstatistica implements IEstatistica {

    @Override
    public String nome() {
        return "Ambas Marcaram";
    }

    @Override
    public String chave() {
        return "AMBAS_MARCARAM";
    }

}
