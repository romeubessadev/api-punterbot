package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stading {

    @JsonProperty(value = "localteam_position")
    private Long localTeamPosition;

    @JsonProperty(value = "visitorteam_position")
    private Long visitorTeamPosition;

    public Long getLocalTeamPosition() {
        return localTeamPosition;
    }

    public void setLocalTeamPosition(Long localTeamPosition) {
        this.localTeamPosition = localTeamPosition;
    }

    public Long getVisitorTeamPosition() {
        return visitorTeamPosition;
    }

    public void setVisitorTeamPosition(Long visitorTeamPosition) {
        this.visitorTeamPosition = visitorTeamPosition;
    }
}
