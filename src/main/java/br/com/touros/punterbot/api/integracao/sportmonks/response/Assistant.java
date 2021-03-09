package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Assistant {

    @JsonProperty(value = "first_assistant_id")
    private Long firstAssistantId;

    @JsonProperty(value = "second_assistant_id")
    private Long secondAssistantId;

    @JsonProperty(value = "fourth_official_id")
    private Long fourthofficialId;

    public Assistant() {
    }

    public Assistant(Long firstAssistantId, Long secondAssistantId, Long fourthofficialId) {
        this.firstAssistantId = firstAssistantId;
        this.secondAssistantId = secondAssistantId;
        this.fourthofficialId = fourthofficialId;
    }

    public Long getFirstAssistantId() {
        return firstAssistantId;
    }

    public void setFirstAssistantId(Long firstAssistantId) {
        this.firstAssistantId = firstAssistantId;
    }

    public Long getSecondAssistantId() {
        return secondAssistantId;
    }

    public void setSecondAssistantId(Long secondAssistantId) {
        this.secondAssistantId = secondAssistantId;
    }

    public Long getFourthofficialId() {
        return fourthofficialId;
    }

    public void setFourthofficialId(Long fourthofficialId) {
        this.fourthofficialId = fourthofficialId;
    }
}
