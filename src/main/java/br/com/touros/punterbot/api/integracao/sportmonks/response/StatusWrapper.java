package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StatusWrapper {
    @JsonProperty(value = "data")
    private List<Stats> data;

    public List<Stats> getData() {
        return data;
    }

    public void setData(List<Stats> data) {
        this.data = data;
    }
}
