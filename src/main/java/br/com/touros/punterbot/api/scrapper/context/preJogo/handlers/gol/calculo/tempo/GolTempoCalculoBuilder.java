package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol.calculo.tempo;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.context.preJogo.CalculoBuilder;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.gol.IGolEstatistica;

public class GolTempoCalculoBuilder extends CalculoBuilder<GolTempoCalculo> {

    private final Integer minutoMinimo;
    private final Integer minutoMaximo;

    public GolTempoCalculoBuilder(IGolEstatistica escanteioEstatistica, Jogo jogo, Boolean geral) {
        super(escanteioEstatistica, jogo, geral);
        this.minutoMinimo = escanteioEstatistica.minutoMinimo();
        this.minutoMaximo = escanteioEstatistica.minutoMaximo();
    }

    public static GolTempoCalculoBuilder get(IGolEstatistica gol, Jogo jogo, Boolean geral) {
        return new GolTempoCalculoBuilder(gol, jogo, geral);
    }

    public GolTempoCalculo build() {
        return new GolTempoCalculo(minutoMinimo, minutoMaximo);
    }

    @Override
    public void finish(GolTempoCalculo calculo) {
        attEstatistica(calculo.getResultadoTimeCasa());
        attEstatistica(calculo.getResultadoTimeVisita());
    }
}
