package br.com.touros.punterbot.api.scrapper.analise;

import br.com.touros.punterbot.api.integracao.sportmonks.response.Time;

public interface IJogoParaAnalise {

    Long getId();

    Long getLeagueId();

    Long getLocalTeamId();

    Long getVisitorTeamId();

    Time getTime();
}
