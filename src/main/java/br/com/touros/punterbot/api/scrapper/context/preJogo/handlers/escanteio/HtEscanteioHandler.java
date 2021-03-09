package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.escanteio;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.context.preJogo.PreJogoContext;
import br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.escanteio.calculo.tempo.EscanteioTempoCalculo;
import br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.escanteio.calculo.tempo.EscantetioTempoCalculoBuilder;
import br.com.touros.punterbot.api.scrapper.estatisticas.Estatisticas;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;
import br.com.touros.punterbot.api.scrapper.flow.Handler;
import br.com.touros.punterbot.api.scrapper.flow.exception.HandlerException;

import static br.com.touros.punterbot.api.scrapper.analise.SetResult.AddEscanteio;

public class HtEscanteioHandler extends Handler<PreJogoContext, Jogo> {

    public HtEscanteioHandler() {
    }

    @Override
    public void analisar() throws HandlerException {
        Estatisticas.Escanteio.HTS
                .stream()
                .map(iHtEscanteio -> efetuarCalculo(iHtEscanteio, true))
                .forEach(this::adicionarResultado);

        Estatisticas.Escanteio.HTS
                .stream()
                .map(iHtEscanteio -> efetuarCalculo(iHtEscanteio, false))
                .forEach(this::adicionarResultado);

        // proxima estatistica
        getContexto().avancarParaProximaEstatisca(new OverEscanteioHandler());
    }

    public EscanteioTempoCalculo efetuarCalculo(IHtFtEscanteio iHtEscanteio, Boolean geral) {
        return EscantetioTempoCalculoBuilder
                .get(iHtEscanteio, getContexto().getState(), geral)
                .efetuarCalculo();
    }

    public void adicionarResultado(EscanteioTempoCalculo eec) {
        AddEscanteio(getContexto().getState().getTimeCasa(), eec.getResultadoTimeCasa(), eec.getGeral());
        AddEscanteio(getContexto().getState().getTimeVisita(), eec.getResultadoTimeVisita(), eec.getGeral());
    }
}
