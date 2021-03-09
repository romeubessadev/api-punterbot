package br.com.touros.punterbot.api.integracao.sportmonks;

public enum TeamFixtureResult {
    LOCAL("localResults"), VISITOR("visitorResults");

    private final String include;

    TeamFixtureResult(String include) {
        this.include = include;
    }

    public String getInclude() {
        return include;
    }
}
