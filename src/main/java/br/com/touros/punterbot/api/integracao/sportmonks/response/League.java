package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class League {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "logo_path")
    private String logoPath;

    @JsonProperty(value = "country_id")
    private Long countryId;

    @JsonProperty(value = "is_cup")
    private Boolean isCup;

    @JsonProperty(value = "current_season_id")
    private Long currentSeasonId;

    @JsonProperty(value = "current_round_id")
    private Long currentRoundId;

    @JsonProperty(value = "current_stage_id")
    private Long currentStageId;

    @JsonProperty(value = "live_standings")
    private Boolean liveStandings;

    @JsonProperty(value = "coverage")
    private Coverage coverage;

    @JsonProperty(value = "seasons")
    private SeasonsWrapper seasons;

    private Boolean active;

    public League() {
    }


    public Coverage getCoverage() {
        return coverage;
    }

    public void setCoverage(Coverage coverage) {
        this.coverage = coverage;
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

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Boolean getCup() {
        return isCup;
    }

    public void setCup(Boolean cup) {
        isCup = cup;
    }

    public Long getCurrentSeasonId() {
        return currentSeasonId;
    }

    public void setCurrentSeasonId(Long currentSeasonId) {
        this.currentSeasonId = currentSeasonId;
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

    public Boolean getLiveStandings() {
        return liveStandings;
    }

    public void setLiveStandings(Boolean liveStandings) {
        this.liveStandings = liveStandings;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public SeasonsWrapper getSeasons() {
        return seasons;
    }

    public void setSeasons(SeasonsWrapper seasons) {
        this.seasons = seasons;
    }
}
