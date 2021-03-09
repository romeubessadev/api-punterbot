package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class WeatherReport {

    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "type")
    private String type;

    @JsonProperty(value = "icon")
    private String icon;

    @JsonProperty(value = "clouds")
    private String clouds;

    @JsonProperty(value = "humidity")
    private String humidity;

    @JsonProperty(value = "pressure")
    private Integer pressure;

    @JsonProperty(value = "updated_at")
    private Date updatedAt;

    @JsonProperty(value = "temperature")
    private Temperature temperature;

    @JsonProperty(value = "temperature_celcius")
    private Temperature temperatureCelcius;

    @JsonProperty(value = "wind")
    private Wind wind;

    @JsonProperty(value = "coordinates")
    private Cordinate coordinates;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public static class Temperature {

        @JsonProperty(value = "temp")
        private Long temp;

        @JsonProperty(value = "unit")
        private String unit;

        public Long getTemp() {
            return temp;
        }

        public void setTemp(Long temp) {
            this.temp = temp;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }

    public static class Wind {

        @JsonProperty(value = "degree")
        private Long degree;

        @JsonProperty(value = "speed")
        private String speed;

        public Long getDegree() {
            return degree;
        }

        public void setDegree(Long degree) {
            this.degree = degree;
        }

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }
    }

    public static class Cordinate {

        @JsonProperty(value = "lat")
        private Long lat;

        @JsonProperty(value = "lon")
        private Long lon;

        public Long getLat() {
            return lat;
        }

        public void setLat(Long lat) {
            this.lat = lat;
        }

        public Long getLon() {
            return lon;
        }

        public void setLon(Long lon) {
            this.lon = lon;
        }
    }

}
