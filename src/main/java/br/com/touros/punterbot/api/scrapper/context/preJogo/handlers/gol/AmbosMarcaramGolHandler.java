package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.context.preJogo.PreJogoContext;
import br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol.calculo.ambos.GolAmbosMarcaramCalculo;
import br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol.calculo.ambos.GolAmbosMarcaramCalculoBuilder;
import br.com.touros.punterbot.api.scrapper.estatisticas.Estatisticas;
import br.com.touros.punterbot.api.scrapper.flow.Handler;
import br.com.touros.punterbot.api.scrapper.flow.exception.HandlerException;

import static br.com.touros.punterbot.api.scrapper.analise.SetResult.AddGol;

public class AmbosMarcaramGolHandler extends Handler<PreJogoContext, Jogo> {

    @Override
    public void analisar() throws HandlerException {
        GolAmbosMarcaramCalculo ogecGeral = GolAmbosMarcaramCalculoBuilder
                .get(Estatisticas.Gol.AMBOS_MARCARAM, getContexto().getState(), true)
                .efetuarCalculo();

        AddGol(getContexto().getState().getTimeVisita(), ogecGeral.getResultadoTimeCasa(), true);
        AddGol(getContexto().getState().getTimeCasa(), ogecGeral.getResultadoTimeVisita(), true);

        GolAmbosMarcaramCalculo ogecLiga = GolAmbosMarcaramCalculoBuilder
                .get(Estatisticas.Gol.AMBOS_MARCARAM, getContexto().getState(), false)
                .efetuarCalculo();

        AddGol(getContexto().getState().getTimeCasa(), ogecLiga.getResultadoTimeCasa(), false);
        AddGol(getContexto().getState().getTimeVisita(), ogecLiga.getResultadoTimeVisita(), false);

        // proxima estatistica
        getContexto().avancarParaProximaEstatisca(new OverGolHandler());
    }
}
