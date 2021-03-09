package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.context.preJogo.PreJogoContext;
import br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol.calculo.tempo.GolTempoCalculo;
import br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol.calculo.tempo.GolTempoCalculoBuilder;
import br.com.touros.punterbot.api.scrapper.estatisticas.Estatisticas;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.gol.IGolEstatistica;
import br.com.touros.punterbot.api.scrapper.flow.Handler;
import br.com.touros.punterbot.api.scrapper.flow.exception.HandlerException;

import static br.com.touros.punterbot.api.scrapper.analise.SetResult.AddGol;

public class PeriodoGolHandleer extends Handler<PreJogoContext, Jogo> {

    public PeriodoGolHandleer() {
    }

    @Override
    public void analisar() throws HandlerException {
        Estatisticas.Gol.PERIODOS
                .stream()
                .map(iGolEstatistica -> efetuarCalculo(iGolEstatistica, true))
                .forEach(this::adicionarResultado);

        Estatisticas.Gol.PERIODOS
                .stream()
                .map(iGolEstatistica -> efetuarCalculo(iGolEstatistica, false))
                .forEach(this::adicionarResultado);


        // proxima estatistica
        getContexto().avancarParaProximaEstatisca(null);
    }

    private GolTempoCalculo efetuarCalculo(IGolEstatistica iGolEstatistica, Boolean isGeral) {
        return GolTempoCalculoBuilder
                .get(iGolEstatistica, getContexto().getState(), isGeral)
                .efetuarCalculo();
    }

    public void adicionarResultado(GolTempoCalculo oee) {
        AddGol(getContexto().getState().getTimeCasa(), oee.getResultadoTimeCasa(), oee.getGeral());
        AddGol(getContexto().getState().getTimeVisita(), oee.getResultadoTimeVisita(), oee.getGeral());
    }
}
