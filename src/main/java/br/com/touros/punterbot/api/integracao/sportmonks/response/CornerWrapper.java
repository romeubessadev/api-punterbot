package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CornerWrapper {

    @JsonProperty(value = "data")
    private List<Corner> data;

    public List<Corner> getData() {
        return data;
    }

    public void setData(List<Corner> data) {
        this.data = data;
    }


}
