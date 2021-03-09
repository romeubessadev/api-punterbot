package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GoalsWrapper {

    @JsonProperty(value = "data")
    private List<Goal> data;

    public List<Goal> getData() {
        return data;
    }

    public void setData(List<Goal> data) {
        this.data = data;
    }

}
