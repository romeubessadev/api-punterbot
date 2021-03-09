package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Color {

    @JsonProperty(value = "localteam")
    private ColorDetail localTeam;

    @JsonProperty(value = "visitorteam")
    private ColorDetail visitorTeam;

    public ColorDetail getLocalTeam() {
        return localTeam;
    }

    public void setLocalTeam(ColorDetail localTeam) {
        this.localTeam = localTeam;
    }

    public ColorDetail getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(ColorDetail visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public static class ColorDetail {

        @JsonProperty(value = "color")
        private String color;

        @JsonProperty(value = "kit_colors")
        private String kitColors;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getKitColors() {
            return kitColors;
        }

        public void setKitColors(String kitColors) {
            this.kitColors = kitColors;
        }
    }
}
