package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LeagueResponse {

    @JsonProperty(value = "data")
    public League league;

    public void setLeague(League league) {
        this.league = league;
    }

    public League getLeague() {
        return league;
    }
}
