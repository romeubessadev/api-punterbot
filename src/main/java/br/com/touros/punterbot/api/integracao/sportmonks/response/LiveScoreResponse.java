package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LiveScoreResponse extends BaseResponse {

    @JsonProperty("data")
    private List<LiveScore> liveScores;

    public List<LiveScore> getLiveScores() {
        return liveScores;
    }

    public void setLiveScores(List<LiveScore> liveScores) {
        this.liveScores = liveScores;
    }
}
