package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coach {

    @JsonProperty(value = "localteam_coach_id")
    private Long localTeamCoachId;

    @JsonProperty(value = "visitorteam_coach_id")
    private Long visitorTeamCoachId;

    public Long getLocalTeamCoachId() {
        return localTeamCoachId;
    }

    public void setLocalTeamCoachId(Long localTeamCoachId) {
        this.localTeamCoachId = localTeamCoachId;
    }

    public Long getVisitorTeamCoachId() {
        return visitorTeamCoachId;
    }

    public void setVisitorTeamCoachId(Long visitorTeamCoachId) {
        this.visitorTeamCoachId = visitorTeamCoachId;
    }
}
