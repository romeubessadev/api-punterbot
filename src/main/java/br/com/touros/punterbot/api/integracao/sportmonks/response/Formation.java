package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Formation {

    @JsonProperty(value = "localteam_formation")
    private Object localTeamFormation;

    @JsonProperty(value = "visitorteam_formation")
    private Object visitorTeamFormation;

    public Formation() {
    }

    public Formation(Object localTeamFormation, Object visitorTeamFormation) {
        this.localTeamFormation = localTeamFormation;
        this.visitorTeamFormation = visitorTeamFormation;
    }

    public Object getLocalTeamFormation() {
        return localTeamFormation;
    }

    public void setLocalTeamFormation(Object localTeamFormation) {
        this.localTeamFormation = localTeamFormation;
    }

    public Object getVisitorTeamFormation() {
        return visitorTeamFormation;
    }

    public void setVisitorTeamFormation(Object visitorTeamFormation) {
        this.visitorTeamFormation = visitorTeamFormation;
    }
}
