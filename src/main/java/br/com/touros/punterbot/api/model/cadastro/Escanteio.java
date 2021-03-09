package br.com.touros.punterbot.api.model.cadastro;

import br.com.touros.punterbot.api.integracao.sportmonks.response.Corner;

public class Escanteio {

    private Long id;
    private Long timeId;
    private Long jogoId;
    private Integer minuto;
    private Integer minutoExtra;
    private String comentario;

    public Escanteio() {
    }

    public Escanteio(Corner corner) {
        this.id = corner.getId();
        this.timeId = corner.getTeamId();
        this.jogoId = corner.getFixtureId();
        this.minuto = corner.getMinute();
        this.minutoExtra = corner.getExtraMinute();
        this.comentario = corner.getComment();
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

    public Long getJogoId() {
        return jogoId;
    }

    public void setJogoId(Long jogoId) {
        this.jogoId = jogoId;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
