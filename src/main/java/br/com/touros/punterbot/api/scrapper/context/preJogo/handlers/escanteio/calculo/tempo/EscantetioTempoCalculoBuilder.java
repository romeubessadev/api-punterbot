package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.escanteio.calculo.tempo;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.context.preJogo.CalculoBuilder;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;

public class EscantetioTempoCalculoBuilder extends CalculoBuilder<EscanteioTempoCalculo> {

    private final Integer minutoMinimo;
    private final Integer minutoMaximo;

    private EscantetioTempoCalculoBuilder(IHtFtEscanteio iHtFtEscanteio, Jogo jogo, Boolean geral) {
        super(iHtFtEscanteio, jogo, geral);
        this.minutoMinimo = iHtFtEscanteio.minutoMinimo();
        this.minutoMaximo = iHtFtEscanteio.minutoMaximo();
    }


    public static EscantetioTempoCalculoBuilder get(IHtFtEscanteio iHtEscanteio, Jogo jogo, Boolean geral) {
        return new EscantetioTempoCalculoBuilder(iHtEscanteio, jogo, geral);
    }

    public EscanteioTempoCalculo build() {
        return new EscanteioTempoCalculo(minutoMinimo, minutoMaximo);
    }

    @Override
    public void finish(EscanteioTempoCalculo calculo) {
        attEstatistica(calculo.getResultadoTimeCasa());
        attEstatistica(calculo.getResultadoTimeVisita());
    }
}
