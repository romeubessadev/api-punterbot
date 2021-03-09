package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.context.preJogo.PreJogoContext;
import br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol.calculo.over.GolOverCalculo;
import br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol.calculo.over.GolOverCalculoBuilder;
import br.com.touros.punterbot.api.scrapper.estatisticas.Estatisticas;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.gol.IOverGolEstatistica;
import br.com.touros.punterbot.api.scrapper.flow.Handler;
import br.com.touros.punterbot.api.scrapper.flow.exception.HandlerException;

import static br.com.touros.punterbot.api.scrapper.analise.SetResult.AddGol;

public class OverGolHandler extends Handler<PreJogoContext, Jogo> {

    public OverGolHandler() {
    }

    @Override
    public void analisar() throws HandlerException {
        Estatisticas.Gol.OVERS
                .stream()
                .map(iOverGolEstatistica -> efetuarCalculo(iOverGolEstatistica, true))
                .forEach(this::adicionarResultado);

        Estatisticas.Gol.OVERS
                .stream()
                .map(iOverGolEstatistica -> efetuarCalculo(iOverGolEstatistica, false))
                .forEach(this::adicionarResultado);

        // proxima estatistica
        getContexto().avancarParaProximaEstatisca(new PeriodoGolHandleer());
    }

    private GolOverCalculo efetuarCalculo(IOverGolEstatistica iOverGolEstatistica, Boolean isGeral) {
        return GolOverCalculoBuilder
                .get(iOverGolEstatistica, getContexto().getState(), isGeral)
                .efetuarCalculo();
    }

    public void adicionarResultado(GolOverCalculo oee) {
        AddGol(getContexto().getState().getTimeCasa(), oee.getResultadoTimeCasa(), oee.getGeral());
        AddGol(getContexto().getState().getTimeVisita(), oee.getResultadoTimeVisita(), oee.getGeral());
    }

}