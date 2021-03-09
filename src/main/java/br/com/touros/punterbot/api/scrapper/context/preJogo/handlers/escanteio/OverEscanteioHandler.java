package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.escanteio;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.model.cadastro.estatisticas.OverEscanteioEstatistica;
import br.com.touros.punterbot.api.scrapper.context.preJogo.PreJogoContext;
import br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.escanteio.calculo.over.EscanteioOverCalculoBuilder;
import br.com.touros.punterbot.api.scrapper.estatisticas.Estatisticas;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IOverEscanteio;
import br.com.touros.punterbot.api.scrapper.flow.Handler;
import br.com.touros.punterbot.api.scrapper.flow.exception.HandlerException;

import static br.com.touros.punterbot.api.scrapper.analise.SetResult.AddEscanteio;

public class OverEscanteioHandler extends Handler<PreJogoContext, Jogo> {

    public OverEscanteioHandler() {
    }

    @Override
    public void analisar() throws HandlerException {
        Estatisticas.Escanteio.OVERS
                .stream()
                .map(iOverEscanteio -> efetuarCalculo(iOverEscanteio, true))
                .forEach(result -> adicionarResultado(result, true));

        Estatisticas.Escanteio.OVERS
                .stream()
                .map(iOverEscanteio -> efetuarCalculo(iOverEscanteio, false))
                .forEach(result -> adicionarResultado(result, false));

        // proxima estatistica
        getContexto().avancarParaProximaEstatisca(new PeriodoEscanteioHandler());
    }

    public OverEscanteioEstatistica efetuarCalculo(IOverEscanteio iOverEscanteio, Boolean isGeral) {
        return EscanteioOverCalculoBuilder
                .get(iOverEscanteio, getContexto().getState(), isGeral)
                .efetuarCalculo()
                .getResultado();
    }

    public void adicionarResultado(OverEscanteioEstatistica oee, Boolean isGeral) {
        AddEscanteio(getContexto().getState().getTimeCasa(), oee, isGeral);
        AddEscanteio(getContexto().getState().getTimeVisita(), oee, isGeral);
    }
}
