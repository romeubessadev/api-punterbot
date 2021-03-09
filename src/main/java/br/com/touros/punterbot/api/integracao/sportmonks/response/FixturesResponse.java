package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FixturesResponse extends BaseResponse {

    @JsonProperty("data")
    private List<Fixture> fixtures;

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

    @Override
    public String toString() {
        return "FixturesResponse{" +
                "fixtures=" + fixtures +
                '}';
    }
}
