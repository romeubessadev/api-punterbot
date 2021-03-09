package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol.calculo.over;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.context.preJogo.CalculoBuilder;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.gol.IOverGolEstatistica;

public class GolOverCalculoBuilder extends CalculoBuilder<GolOverCalculo> {

    private final Integer qtdEscanteiosMinimo;
    private final Integer minutoMinimo;
    private final Integer minutoMaximo;

    public GolOverCalculoBuilder(IOverGolEstatistica escanteioEstatistica, Jogo jogo, Boolean geral) {
        super(escanteioEstatistica, jogo, geral);
        this.qtdEscanteiosMinimo = escanteioEstatistica.qtdGolsMinimo();
        this.minutoMinimo = escanteioEstatistica.minutoMinimo();
        this.minutoMaximo = escanteioEstatistica.minutoMaximo();
    }

    public static GolOverCalculoBuilder get(IOverGolEstatistica escanteio, Jogo jogo, Boolean geral) {
        return new GolOverCalculoBuilder(escanteio, jogo, geral);
    }

    public GolOverCalculo build() {
        return new GolOverCalculo(qtdEscanteiosMinimo, minutoMinimo, minutoMaximo);
    }

    @Override
    public void finish(GolOverCalculo calculo) {
        attEstatistica(calculo.getResultadoTimeCasa());
        attEstatistica(calculo.getResultadoTimeVisita());
    }
}
