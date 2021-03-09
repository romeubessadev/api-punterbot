package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SeasonsWrapper {

    @JsonProperty(value = "data")
    private List<Season> seasons;

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
}
