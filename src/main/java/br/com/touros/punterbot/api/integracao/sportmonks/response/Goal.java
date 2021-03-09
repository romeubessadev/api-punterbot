package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Goal {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "team_id")
    private Long teamId;

    @JsonProperty(value = "type")
    private String type;

    @JsonProperty(value = "fixture_id")
    private Long fixtureId;

    @JsonProperty(value = "player_id")
    private Long playerId;

    @JsonProperty(value = "player_name")
    private String playerName;

    @JsonProperty(value = "player_assist_id")
    private Long playerAssistId;

    @JsonProperty(value = "player_assist_name")
    private String playerAssistName;

    @JsonProperty(value = "minute")
    private Integer minute;

    @JsonProperty(value = "extra_minute")
    private Integer extraMinute;

    @JsonProperty(value = "reason")
    private Object reason;

    @JsonProperty(value = "result")
    private String result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(Long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Long getPlayerAssistId() {
        return playerAssistId;
    }

    public void setPlayerAssistId(Long playerAssistId) {
        this.playerAssistId = playerAssistId;
    }

    public String getPlayerAssistName() {
        return playerAssistName;
    }

    public void setPlayerAssistName(String playerAssistName) {
        this.playerAssistName = playerAssistName;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getExtraMinute() {
        return extraMinute;
    }

    public void setExtraMinute(Integer extraMinute) {
        this.extraMinute = extraMinute;
    }

    public Object getReason() {
        return reason;
    }

    public void setReason(Object reason) {
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
