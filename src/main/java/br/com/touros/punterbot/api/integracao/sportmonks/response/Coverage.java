package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coverage {

    @JsonProperty(value = "topscorer_goals")
    private Boolean topScorerGoals;
    @JsonProperty(value = "topscorer_assists")
    private Boolean topScorerAssists;
    @JsonProperty(value = "topscorer_cards")
    private Boolean topScorerCards;

    public Coverage() {
    }

    public Boolean getTopScorerGoals() {
        return topScorerGoals;
    }

    public void setTopScorerGoals(Boolean topScorerGoals) {
        this.topScorerGoals = topScorerGoals;
    }

    public Boolean getTopScorerAssists() {
        return topScorerAssists;
    }

    public void setTopScorerAssists(Boolean topScorerAssists) {
        this.topScorerAssists = topScorerAssists;
    }

    public Boolean getTopScorerCards() {
        return topScorerCards;
    }

    public void setTopScorerCards(Boolean topScorerCards) {
        this.topScorerCards = topScorerCards;
    }
}
