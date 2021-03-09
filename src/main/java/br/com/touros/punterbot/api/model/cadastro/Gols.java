package br.com.touros.punterbot.api.model.cadastro;

import br.com.touros.punterbot.api.integracao.sportmonks.response.Goal;

public class Gols {
    private Long id;
    private Long timeId;
    private String tipo;
    private Long jogoId;
    private Long jogadorId;
    private String jogadorName;
    private Long jogadorAssistenciaId;
    private String jogadorAssistenciaNome;
    private Integer minuto;
    private Integer minutoExtra;

    public Gols() {
    }

    public Gols(Goal goal) {
        this.id = goal.getId();
        this.timeId = goal.getTeamId();
        this.tipo = goal.getType();
        this.jogoId = goal.getFixtureId();
        this.jogadorId = goal.getPlayerId();
        this.jogadorName = goal.getPlayerName();
        this.jogadorAssistenciaId = goal.getPlayerAssistId();
        this.jogadorAssistenciaNome = goal.getPlayerAssistName();
        this.minuto = goal.getMinute();
        this.minutoExtra = goal.getExtraMinute();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimeId() {
        return timeId;
    }

    public void setTimeId(Long timeId) {
        this.timeId = timeId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getJogoId() {
        return jogoId;
    }

    public void setJogoId(Long jogoId) {
        this.jogoId = jogoId;
    }

    public Long getJogadorId() {
        return jogadorId;
    }

    public void setJogadorId(Long jogadorId) {
        this.jogadorId = jogadorId;
    }

    public String getJogadorName() {
        return jogadorName;
    }

    public void setJogadorName(String jogadorName) {
        this.jogadorName = jogadorName;
    }

    public Long getJogadorAssistenciaId() {
        return jogadorAssistenciaId;
    }

    public void setJogadorAssistenciaId(Long jogadorAssistenciaId) {
        this.jogadorAssistenciaId = jogadorAssistenciaId;
    }

    public String getJogadorAssistenciaNome() {
        return jogadorAssistenciaNome;
    }

    public void setJogadorAssistenciaNome(String jogadorAssistenciaNome) {
        this.jogadorAssistenciaNome = jogadorAssistenciaNome;
    }

    public Integer getMinuto() {
        return minuto;
    }

    public void setMinuto(Integer minuto) {
        this.minuto = minuto;
    }

    public Integer getMinutoExtra() {
        return minutoExtra;
    }

    public void setMinutoExtra(Integer minutoExtra) {
        this.minutoExtra = minutoExtra;
    }
}
