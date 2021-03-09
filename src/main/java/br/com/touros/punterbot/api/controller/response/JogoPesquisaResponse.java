package br.com.touros.punterbot.api.controller.response;

import org.bson.Document;

import java.util.Date;

public class JogoPesquisaResponse {

    private Long id;
    private Date dataInicio;
    private String situacao;
    private JogoTimePesquisaResponse timeCasa;
    private JogoTimePesquisaResponse timeVisita;

    public JogoPesquisaResponse(Document document) {
        this.id = document.getLong("id");
        this.dataInicio = document.getDate("data");
        this.situacao = document.getString("situacao");
        this.timeCasa = new JogoTimePesquisaResponse(document.get("timeCasa", Document.class));
        this.timeVisita = new JogoTimePesquisaResponse(document.get("timeVisita", Document.class));
    }


    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public JogoTimePesquisaResponse getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(JogoTimePesquisaResponse timeCasa) {
        this.timeCasa = timeCasa;
    }

    public JogoTimePesquisaResponse getTimeVisita() {
        return timeVisita;
    }

    public void setTimeVisita(JogoTimePesquisaResponse timeVisita) {
        this.timeVisita = timeVisita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
