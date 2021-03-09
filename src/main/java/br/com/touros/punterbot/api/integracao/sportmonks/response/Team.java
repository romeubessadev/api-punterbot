package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Team {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "legacy_id")
    private Long legacyId;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "short_code")
    private String shortCode;

    @JsonProperty(value = "twitter")
    private String twitter;

    @JsonProperty(value = "country_id")
    private Long countryId;

    @JsonProperty(value = "national_team")
    private Boolean nationalTeam;

    @JsonProperty(value = "founded")
    private Integer founded;

    @JsonProperty(value = "logo_path")
    private String logoPath;

    @JsonProperty(value = "venue_id")
    private Long venueId;

    @JsonProperty(value = "current_season_id")
    private Long currentSeasonId;

    @JsonProperty(value = "visitorResults")
    private FixturesResponse visitorResults;

    @JsonProperty(value = "localResults")
    private FixturesResponse localResults;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLegacyId() {
        return legacyId;
    }

    public void setLegacyId(Long legacyId) {
        this.legacyId = legacyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Boolean getNationalTeam() {
        return nationalTeam;
    }

    public void setNationalTeam(Boolean nationalTeam) {
        this.nationalTeam = nationalTeam;
    }

    public Integer getFounded() {
        return founded;
    }

    public void setFounded(Integer founded) {
        this.founded = founded;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public Long getCurrentSeasonId() {
        return currentSeasonId;
    }

    public void setCurrentSeasonId(Long currentSeasonId) {
        this.currentSeasonId = currentSeasonId;
    }

    public FixturesResponse getVisitorResults() {
        return visitorResults;
    }

    public void setVisitorResults(FixturesResponse visitorResults) {
        this.visitorResults = visitorResults;
    }

    public FixturesResponse getLocalResults() {
        return localResults;
    }

    public void setLocalResults(FixturesResponse localResults) {
        this.localResults = localResults;
    }

    public List<Fixture> getResult() {
        if (localResults != null)
            return localResults.getFixtures();
        if (visitorResults != null) {
            return visitorResults.getFixtures();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", legacyId=" + legacyId +
                ", name='" + name + '\'' +
                ", shortCode='" + shortCode + '\'' +
                ", twitter='" + twitter + '\'' +
                ", countryId=" + countryId +
                ", nationalTeam=" + nationalTeam +
                ", founded=" + founded +
                ", logoPath='" + logoPath + '\'' +
                ", venueId=" + venueId +
                ", currentSeasonId=" + currentSeasonId +
                ", visitorResults=" + visitorResults +
                ", localResults=" + localResults +
                '}';
    }
}
