package br.com.touros.punterbot.api.controller.response;

import org.bson.Document;

public class JogoTimePesquisaResponse {

    private Long id;
    private String nome;
    private String logo;

    public JogoTimePesquisaResponse(Document document) {
        this.id = document.getLong("id");
        this.nome = document.getString("nome");
        this.logo = document.getString("logo");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
