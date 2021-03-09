package br.com.touros.punterbot.api.model.cadastro;

import br.com.touros.punterbot.api.integracao.sportmonks.response.Time;

import java.util.Date;

public class Tempo {

    private String situacao;
    private Date dataInicio;
    private Integer minuto;
    private Integer segundo;

    public Tempo() {
    }

    public Tempo(Time time) {
        this.situacao = time.getStatus();
        this.dataInicio = time.getStartingAt().getTimestampToDate();
        this.minuto = time.getMinute();
        this.segundo = time.getSecond();
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getMinuto() {
        return minuto;
    }

    public void setMinuto(Integer minuto) {
        this.minuto = minuto;
    }

    public Integer getSegundo() {
        return segundo;
    }

    public void setSegundo(Integer segundo) {
        this.segundo = segundo;
    }
}
