package br.com.touros.punterbot.api.scrapper.context.preJogo;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.model.cadastro.estatisticas.BaseEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.IEstatistica;

public abstract class CalculoBuilder<C extends EstatisticaCalculo> {
    private final IEstatistica estatistica;
    private final Jogo jogo;
    private final Boolean geral;

    public abstract C build();

    public abstract void finish(C calculo);

    public CalculoBuilder(IEstatistica estatistica, Jogo jogo, Boolean geral) {
        this.estatistica = estatistica;
        this.jogo = jogo;
        this.geral = geral;
    }

    public C efetuarCalculo() {
        var calculo = this.build();
        calculo.setJogo(jogo, geral);
        calculo.calcular();
        finish(calculo);
        return calculo;
    }

    public <R extends BaseEstatistica> void attEstatistica(R r) {
        r.set(estatistica);
    }
}
