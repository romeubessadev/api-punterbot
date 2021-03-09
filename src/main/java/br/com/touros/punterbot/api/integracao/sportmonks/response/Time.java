package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    @JsonProperty(value = "status")
    private String status;

    @JsonProperty(value = "starting_at")
    private StartingAt startingAt;

    @JsonProperty(value = "minute")
    private Integer minute;

    @JsonProperty(value = "second")
    private Integer second;

    @JsonProperty(value = "added_time")
    private Integer addedTime;

    @JsonProperty(value = "extra_minute")
    private Integer extraMinute;

    @JsonProperty(value = "injury_time")
    private Integer injuryTime;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StartingAt getStartingAt() {
        return startingAt;
    }

    public void setStartingAt(StartingAt startingAt) {
        this.startingAt = startingAt;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Integer addedTime) {
        this.addedTime = addedTime;
    }

    public Integer getExtraMinute() {
        return extraMinute;
    }

    public void setExtraMinute(Integer extraMinute) {
        this.extraMinute = extraMinute;
    }

    public Integer getInjuryTime() {
        return injuryTime;
    }

    public void setInjuryTime(Integer injuryTime) {
        this.injuryTime = injuryTime;
    }

    public static class StartingAt {
        @JsonProperty(value = "date_time")
        private String dateTime;
        @JsonProperty(value = "date")
        private String date;
        @JsonProperty(value = "time")
        private String time;
        @JsonProperty(value = "timestamp")
        private Long timestamp;
        @JsonProperty(value = "timezone")
        private String timezone;

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public Date getTimestampToDate() {
            try {
                return new Date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }
    }
}
