package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetailDate {

    @JsonProperty(value = "date")
    private String date;

    @JsonProperty(value = "timezone_type")
    private Integer timezoneType;

    @JsonProperty(value = "timezone")
    private String timezone;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTimezoneType() {
        return timezoneType;
    }

    public void setTimezoneType(Integer timezoneType) {
        this.timezoneType = timezoneType;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
