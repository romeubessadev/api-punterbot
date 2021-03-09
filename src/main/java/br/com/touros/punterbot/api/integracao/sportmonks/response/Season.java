package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Season {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("league_id")
    private Long leagueId;

    @JsonProperty("is_current_season")
    private Boolean isCurrentSeason;

    @JsonProperty("current_round_id")
    private Long currentRoundId;

    @JsonProperty("current_stage_id")
    private Long currentStageId;

    public Season() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public Boolean getCurrentSeason() {
        return isCurrentSeason;
    }

    public void setCurrentSeason(Boolean currentSeason) {
        isCurrentSeason = currentSeason;
    }

    public Long getCurrentRoundId() {
        return currentRoundId;
    }

    public void setCurrentRoundId(Long currentRoundId) {
        this.currentRoundId = currentRoundId;
    }

    public Long getCurrentStageId() {
        return currentStageId;
    }

    public void setCurrentStageId(Long currentStageId) {
        this.currentStageId = currentStageId;
    }
}
