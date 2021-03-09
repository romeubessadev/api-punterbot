package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol.calculo.ambos;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.context.preJogo.CalculoBuilder;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.IEstatistica;

public class GolAmbosMarcaramCalculoBuilder extends CalculoBuilder<GolAmbosMarcaramCalculo> {

    private GolAmbosMarcaramCalculoBuilder(IEstatistica estrategia, Jogo jogo, Boolean geral) {
        super(estrategia, jogo, geral);
    }

    public static GolAmbosMarcaramCalculoBuilder get(IEstatistica estrategia, Jogo jogo, Boolean geral) {
        return new GolAmbosMarcaramCalculoBuilder(estrategia, jogo, geral);
    }

    @Override
    public GolAmbosMarcaramCalculo build() {
        return new GolAmbosMarcaramCalculo();
    }

    @Override
    public void finish(GolAmbosMarcaramCalculo calculo) {
        attEstatistica(calculo.getResultadoTimeCasa());
        attEstatistica(calculo.getResultadoTimeVisita());
    }
}
