package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Corner {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "team_id")
    private Long teamId;

    @JsonProperty(value = "fixture_id")
    private Long fixtureId;

    @JsonProperty(value = "minute")
    private Integer minute;

    @JsonProperty(value = "extra_minute")
    private Integer extraMinute = 0;

    @JsonProperty(value = "comment")
    private String comment;

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

    public Long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(Long fixtureId) {
        this.fixtureId = fixtureId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
