package br.com.touros.punterbot.api.scrapper.analise.dePara;

import br.com.touros.punterbot.api.integracao.sportmonks.response.LiveScore;

public class LiveScoreDeParaProcessor extends DeParaProcessor<LiveScore> {

    protected LiveScoreDeParaProcessor(LiveScore entity) {
        super(entity);
    }
}
