package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FlatOddsWrapper {

    @JsonProperty(value = "data")
    private List<FlatOdds> data;

    public List<FlatOdds> getData() {
        return data;
    }

    public void setData(List<FlatOdds> data) {
        this.data = data;
    }

    public static class FlatOdds {

        @JsonProperty(value = "bookmaker_id")
        private Long bookmakerId;

        @JsonProperty(value = "bookmaker_event_id")
        private Long bookmakerEventId;

        @JsonProperty(value = "market_id")
        private Long marketId;

        @JsonProperty(value = "suspended")
        private Boolean suspended;

        @JsonProperty(value = "odds")
        private List<Odds> odds;

        public Long getBookmakerId() {
            return bookmakerId;
        }

        public void setBookmakerId(Long bookmakerId) {
            this.bookmakerId = bookmakerId;
        }

        public Long getBookmakerEventId() {
            return bookmakerEventId;
        }

        public void setBookmakerEventId(Long bookmakerEventId) {
            this.bookmakerEventId = bookmakerEventId;
        }

        public Long getMarketId() {
            return marketId;
        }

        public void setMarketId(Long marketId) {
            this.marketId = marketId;
        }

        public Boolean getSuspended() {
            return suspended;
        }

        public void setSuspended(Boolean suspended) {
            this.suspended = suspended;
        }

        public List<Odds> getOdds() {
            return odds;
        }

        public void setOdds(List<Odds> odds) {
            this.odds = odds;
        }
    }


    public static class Odds {

        @JsonProperty(value = "value")
        private String value;

        @JsonProperty(value = "handicap")
        private Object handicap;

        @JsonProperty(value = "total")
        private Object total;

        @JsonProperty(value = "label")
        private String label;

        @JsonProperty(value = "probability")
        private String probability;

        @JsonProperty(value = "dp3")
        private String dp3;

        @JsonProperty(value = "american")
        private Integer american;

        @JsonProperty(value = "factional")
        private Object factional;

        @JsonProperty(value = "winning")
        private Object winning;

        @JsonProperty(value = "stop")
        private Boolean stop;

        @JsonProperty(value = "last_update")
        private DetailDate lastUpdate;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Object getHandicap() {
            return handicap;
        }

        public void setHandicap(Object handicap) {
            this.handicap = handicap;
        }

        public Object getTotal() {
            return total;
        }

        public void setTotal(Object total) {
            this.total = total;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getProbability() {
            return probability;
        }

        public void setProbability(String probability) {
            this.probability = probability;
        }

        public String getDp3() {
            return dp3;
        }

        public void setDp3(String dp3) {
            this.dp3 = dp3;
        }

        public Integer getAmerican() {
            return american;
        }

        public void setAmerican(Integer american) {
            this.american = american;
        }

        public Object getFactional() {
            return factional;
        }

        public void setFactional(Object factional) {
            this.factional = factional;
        }

        public Object getWinning() {
            return winning;
        }

        public void setWinning(Object winning) {
            this.winning = winning;
        }

        public Boolean getStop() {
            return stop;
        }

        public void setStop(Boolean stop) {
            this.stop = stop;
        }

        public DetailDate getLastUpdate() {
            return lastUpdate;
        }

        public void setLastUpdate(DetailDate lastUpdate) {
            this.lastUpdate = lastUpdate;
        }
    }

}
