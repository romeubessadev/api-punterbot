package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueListResponse {

    @JsonProperty(value = "data")
    public List<League> data;

    public LeagueListResponse() {
    }

    public List<League> getData() {
        return data;
    }

    public void setData(List<League> data) {
        this.data = data;
    }
}
