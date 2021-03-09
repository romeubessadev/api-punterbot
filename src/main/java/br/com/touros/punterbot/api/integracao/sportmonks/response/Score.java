package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Score {

    @JsonProperty(value = "localteam_score")
    private Integer localTeamScore;

    @JsonProperty(value = "visitorteam_score")
    private Integer visitorTeamScore;

    @JsonProperty(value = "localteam_pen_score")
    private Object localTeamPenScore;

    @JsonProperty(value = "visitorteam_pen_score")
    private Object visitorTeamPenScore;

    @JsonProperty(value = "ht_score")
    private String htScore;

    @JsonProperty(value = "ft_score")
    private String ftScore;

    @JsonProperty(value = "et_score")
    private Object etScore;

    @JsonProperty(value = "ps_score")
    private Object psScore;

    public Score() {
    }

    public Integer getLocalTeamScore() {
        return localTeamScore;
    }

    public void setLocalTeamScore(Integer localTeamScore) {
        this.localTeamScore = localTeamScore;
    }

    public Integer getVisitorTeamScore() {
        return visitorTeamScore;
    }

    public void setVisitorTeamScore(Integer visitorTeamScore) {
        this.visitorTeamScore = visitorTeamScore;
    }

    public Object getLocalTeamPenScore() {
        return localTeamPenScore;
    }

    public void setLocalTeamPenScore(Object localTeamPenScore) {
        this.localTeamPenScore = localTeamPenScore;
    }

    public Object getVisitorTeamPenScore() {
        return visitorTeamPenScore;
    }

    public void setVisitorTeamPenScore(Object visitorTeamPenScore) {
        this.visitorTeamPenScore = visitorTeamPenScore;
    }

    public String getHtScore() {
        return htScore;
    }

    public void setHtScore(String htScore) {
        this.htScore = htScore;
    }

    public String getFtScore() {
        return ftScore;
    }

    public void setFtScore(String ftScore) {
        this.ftScore = ftScore;
    }

    public Object getEtScore() {
        return etScore;
    }

    public void setEtScore(Object etScore) {
        this.etScore = etScore;
    }

    public Object getPsScore() {
        return psScore;
    }

    public void setPsScore(Object psScore) {
        this.psScore = psScore;
    }
}
