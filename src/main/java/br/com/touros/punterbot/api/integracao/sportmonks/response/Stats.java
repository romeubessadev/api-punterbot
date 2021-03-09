package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {

    @JsonProperty(value = "team_id")
    private Long teamId;
    @JsonProperty(value = "fixture_id")
    private Long fixtureId;
    @JsonProperty(value = "fouls")
    private Long fouls;
    @JsonProperty(value = "corners")
    private Integer corners;
    @JsonProperty(value = "offsides")
    private Long offsides;
    @JsonProperty(value = "possessiontime")
    private Long possessiOnTime;
    @JsonProperty(value = "yellowcards")
    private Long yellowCards;
    @JsonProperty(value = "redcards")
    private Long redCards;
    @JsonProperty(value = "yellowredcards")
    private Long yellowRedCards;
    @JsonProperty(value = "saves")
    private Long saves;
    @JsonProperty(value = "substitutions")
    private Long substitutions;
    @JsonProperty(value = "goal_kick")
    private Long goalKick;
    @JsonProperty(value = "goal_attempts")
    private Long goalAttempts;
    @JsonProperty(value = "free_kick")
    private Long freeKick;
    @JsonProperty(value = "throw_in")
    private Long throwIn;
    @JsonProperty(value = "ball_safe")
    private Long ballSafe;
    @JsonProperty(value = "goals")
    private Integer goals;
    @JsonProperty(value = "penalties")
    private Long penalties;
    @JsonProperty(value = "injuries")
    private Long injuries;

    @JsonProperty(value = "attacks")
    private Attack attacks;

    @JsonProperty(value = "passes")
    private Passes passes;

    @JsonProperty(value = "shots")
    private Shots shots;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(Long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public Attack getAttacks() {
        return attacks;
    }

    public void setAttacks(Attack attacks) {
        this.attacks = attacks;
    }

    public Passes getPasses() {
        return passes;
    }

    public void setPasses(Passes passes) {
        this.passes = passes;
    }

    public Shots getShots() {
        return shots;
    }

    public void setShots(Shots shots) {
        this.shots = shots;
    }

    public Long getFouls() {
        return fouls;
    }

    public void setFouls(Long fouls) {
        this.fouls = fouls;
    }

    public Integer getCorners() {
        return corners;
    }

    public void setCorners(Integer corners) {
        this.corners = corners;
    }

    public Long getOffsides() {
        return offsides;
    }

    public void setOffsides(Long offsides) {
        this.offsides = offsides;
    }

    public Long getPossessiOnTime() {
        return possessiOnTime;
    }

    public void setPossessiOnTime(Long possessiOnTime) {
        this.possessiOnTime = possessiOnTime;
    }

    public Long getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Long yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Long getRedCards() {
        return redCards;
    }

    public void setRedCards(Long redCards) {
        this.redCards = redCards;
    }

    public Long getYellowRedCards() {
        return yellowRedCards;
    }

    public void setYellowRedCards(Long yellowRedCards) {
        this.yellowRedCards = yellowRedCards;
    }

    public Long getSaves() {
        return saves;
    }

    public void setSaves(Long saves) {
        this.saves = saves;
    }

    public Long getSubstitutions() {
        return substitutions;
    }

    public void setSubstitutions(Long substitutions) {
        this.substitutions = substitutions;
    }

    public Long getGoalKick() {
        return goalKick;
    }

    public void setGoalKick(Long goalKick) {
        this.goalKick = goalKick;
    }

    public Long getGoalAttempts() {
        return goalAttempts;
    }

    public void setGoalAttempts(Long goalAttempts) {
        this.goalAttempts = goalAttempts;
    }

    public Long getFreeKick() {
        return freeKick;
    }

    public void setFreeKick(Long freeKick) {
        this.freeKick = freeKick;
    }

    public Long getThrowIn() {
        return throwIn;
    }

    public void setThrowIn(Long throwIn) {
        this.throwIn = throwIn;
    }

    public Long getBallSafe() {
        return ballSafe;
    }

    public void setBallSafe(Long ballSafe) {
        this.ballSafe = ballSafe;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Long getPenalties() {
        return penalties;
    }

    public void setPenalties(Long penalties) {
        this.penalties = penalties;
    }

    public Long getInjuries() {
        return injuries;
    }

    public void setInjuries(Long injuries) {
        this.injuries = injuries;
    }

    public static class Attack {
        @JsonProperty(value = "attacks")
        private Integer attacks;
        @JsonProperty(value = "dangerousAttacks")
        private Integer dangerousAttacks;

        public Integer getAttacks() {
            return attacks;
        }

        public void setAttacks(Integer attacks) {
            this.attacks = attacks;
        }

        public Integer getDangerousAttacks() {
            return dangerousAttacks;
        }

        public void setDangerousAttacks(Integer dangerousAttacks) {
            this.dangerousAttacks = dangerousAttacks;
        }
    }
    public static class Passes {
        @JsonProperty(value = "total")
        private Integer total;
        @JsonProperty(value = "accurate")
        private Integer accurate;
        @JsonProperty(value = "percentage")
        private Float percentage;

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getAccurate() {
            return accurate;
        }

        public void setAccurate(Integer accurate) {
            this.accurate = accurate;
        }

        public Float getPercentage() {
            return percentage;
        }

        public void setPercentage(Float percentage) {
            this.percentage = percentage;
        }
    }

    public static class Shots {
        @JsonProperty(value = "total")
        private Integer total;
        @JsonProperty(value = "ongoal")
        private Integer ongoal;
        @JsonProperty(value = "offgoal")
        private Integer offgoal;
        @JsonProperty(value = "insidebox")
        private Integer insidebox;
        @JsonProperty(value = "outsidebox")
        private Integer outsidebox;

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getOngoal() {
            return ongoal;
        }

        public void setOngoal(Integer ongoal) {
            this.ongoal = ongoal;
        }

        public Integer getOffgoal() {
            return offgoal;
        }

        public void setOffgoal(Integer offgoal) {
            this.offgoal = offgoal;
        }

        public Integer getInsidebox() {
            return insidebox;
        }

        public void setInsidebox(Integer insidebox) {
            this.insidebox = insidebox;
        }

        public Integer getOutsidebox() {
            return outsidebox;
        }

        public void setOutsidebox(Integer outsidebox) {
            this.outsidebox = outsidebox;
        }
    }

}
