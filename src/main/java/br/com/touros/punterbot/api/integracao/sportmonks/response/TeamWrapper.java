package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamWrapper {

    @JsonProperty(value = "data")
    private Team data;

    public Team getData() {
        return data;
    }

    public void setData(Team data) {
        this.data = data;
    }

}
