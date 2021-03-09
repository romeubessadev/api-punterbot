package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.escanteio.calculo.over;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.context.preJogo.CalculoBuilder;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IOverEscanteio;

public class EscanteioOverCalculoBuilder extends CalculoBuilder<EscanteioOverCalculo> {

    private Integer qtdEscanteiosMinimo;

    private EscanteioOverCalculoBuilder(IOverEscanteio estrategia, Jogo jogo, Boolean geral) {
        super(estrategia, jogo, geral);
        qtdEscanteiosMinimo = estrategia.qtdEscanteioMinimo();
    }

    public static EscanteioOverCalculoBuilder get(IOverEscanteio escanteio, Jogo jogo, Boolean geral) {
        return new EscanteioOverCalculoBuilder(escanteio, jogo, geral);
    }

    @Override
    public EscanteioOverCalculo build() {
        return new EscanteioOverCalculo(qtdEscanteiosMinimo);
    }

    @Override
    public void finish(EscanteioOverCalculo calculo) {
        attEstatistica(calculo.getResultado());
    }
}
