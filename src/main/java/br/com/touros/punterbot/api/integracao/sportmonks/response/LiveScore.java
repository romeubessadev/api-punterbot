package br.com.touros.punterbot.api.integracao.sportmonks.response;

import br.com.touros.punterbot.api.scrapper.analise.IJogoParaAnalise;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LiveScore implements IJogoParaAnalise {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "league_id")
    private Long leagueId;

    @JsonProperty(value = "season_id")
    private Long seasonId;

    @JsonProperty(value = "stage_id")
    private Long stageId;

    @JsonProperty(value = "round_id")
    private Long roundId;

    @JsonProperty(value = "group_id")
    private Long groupId;

    @JsonProperty(value = "aggregate_id")
    private Long aggregateId;

    @JsonProperty(value = "venue_id")
    private Long venueId;

    @JsonProperty(value = "referee_id")
    private Long refereeId;

    @JsonProperty(value = "localteam_id")
    private Long localTeamId;

    @JsonProperty(value = "visitorteam_id")
    private Long visitorTeamId;

    @JsonProperty(value = "winner_team_id")
    private Long winnerTeamId;

    @JsonProperty(value = "weather_report")
    private Object weatherReport;

    @JsonProperty(value = "commentaries")
    private Boolean commentaries;

    @JsonProperty(value = "attendance")
    private String attendance;

    @JsonProperty(value = "pitch")
    private String pitch;

    @JsonProperty(value = "details")
    private Object details;

    @JsonProperty(value = "neutral_venue")
    private Boolean neutralVenue;

    @JsonProperty(value = "winning_odds_calculated")
    private Boolean winningOddsCalculated;

    @JsonProperty(value = "leg")
    private String leg;

    @JsonProperty(value = "colors")
    private Object colors;

    @JsonProperty(value = "deleted")
    private Boolean deleted;

    @JsonProperty(value = "formations")
    private Formation formation;

    @JsonProperty(value = "scores")
    private Score scores;

    @JsonProperty(value = "coaches")
    private Coach coaches;

    @JsonProperty(value = "standings")
    private Stading standings;

    @JsonProperty(value = "assistants")
    private Assistant assistants;

    @JsonProperty(value = "time")
    private Time time;

    @JsonProperty(value = "corners")
    private CornerWrapper corners;

    @JsonProperty(value = "stats")
    private StatusWrapper stats;

    public LiveScore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public Long getRoundId() {
        return roundId;
    }

    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(Long aggregateId) {
        this.aggregateId = aggregateId;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public Long getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Long refereeId) {
        this.refereeId = refereeId;
    }

    public Long getLocalTeamId() {
        return localTeamId;
    }

    public void setLocalTeamId(Long localTeamId) {
        this.localTeamId = localTeamId;
    }

    public Long getVisitorTeamId() {
        return visitorTeamId;
    }

    public void setVisitorTeamId(Long visitorTeamId) {
        this.visitorTeamId = visitorTeamId;
    }

    public Long getWinnerTeamId() {
        return winnerTeamId;
    }

    public void setWinnerTeamId(Long winnerTeamId) {
        this.winnerTeamId = winnerTeamId;
    }

    public Object getWeatherReport() {
        return weatherReport;
    }

    public void setWeatherReport(Object weatherReport) {
        this.weatherReport = weatherReport;
    }

    public Boolean getCommentaries() {
        return commentaries;
    }

    public void setCommentaries(Boolean commentaries) {
        this.commentaries = commentaries;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public Boolean getNeutralVenue() {
        return neutralVenue;
    }

    public void setNeutralVenue(Boolean neutralVenue) {
        this.neutralVenue = neutralVenue;
    }

    public Boolean getWinningOddsCalculated() {
        return winningOddsCalculated;
    }

    public void setWinningOddsCalculated(Boolean winningOddsCalculated) {
        this.winningOddsCalculated = winningOddsCalculated;
    }

    public String getLeg() {
        return leg;
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }

    public Object getColors() {
        return colors;
    }

    public void setColors(Object colors) {
        this.colors = colors;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Score getScores() {
        return scores;
    }

    public void setScores(Score scores) {
        this.scores = scores;
    }

    public Coach getCoaches() {
        return coaches;
    }

    public void setCoaches(Coach coaches) {
        this.coaches = coaches;
    }

    public Stading getStandings() {
        return standings;
    }

    public void setStandings(Stading standings) {
        this.standings = standings;
    }

    public Assistant getAssistants() {
        return assistants;
    }

    public void setAssistants(Assistant assistants) {
        this.assistants = assistants;
    }

    @Override
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public CornerWrapper getCorners() {
        return corners;
    }

    public List<Corner> getListCorners() {
        return (corners != null && corners.getData() != null) ? corners.getData() : null;
    }

    public List<Stats> getListStats() {
        return (stats != null && stats.getData() != null) ? stats.getData() : null;
    }
    public void setCorners(CornerWrapper corners) {
        this.corners = corners;
    }

    public StatusWrapper getStats() {
        return stats;
    }

    public void setStats(StatusWrapper stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "LiveScore{" +
                "id=" + id +
                ", leagueId=" + leagueId +
                ", seasonId=" + seasonId +
                ", stageId=" + stageId +
                ", roundId=" + roundId +
                ", groupId=" + groupId +
                ", aggregateId=" + aggregateId +
                ", venueId=" + venueId +
                ", refereeId=" + refereeId +
                ", localTeamId=" + localTeamId +
                ", visitorTeamId=" + visitorTeamId +
                ", winnerTeamId=" + winnerTeamId +
                ", weatherReport=" + weatherReport +
                ", commentaries=" + commentaries +
                ", attendance='" + attendance + '\'' +
                ", pitch='" + pitch + '\'' +
                ", details=" + details +
                ", neutralVenue=" + neutralVenue +
                ", winningOddsCalculated=" + winningOddsCalculated +
                ", leg='" + leg + '\'' +
                ", colors=" + colors +
                ", deleted=" + deleted +
                ", formation=" + formation +
                ", scores=" + scores +
                ", coaches=" + coaches +
                ", standings=" + standings +
                ", assistants=" + assistants +
                ", time=" + time +
                '}';
    }
}
