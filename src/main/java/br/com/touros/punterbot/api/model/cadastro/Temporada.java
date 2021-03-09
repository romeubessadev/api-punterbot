package br.com.touros.punterbot.api.model.cadastro;

import br.com.touros.punterbot.api.integracao.sportmonks.response.Season;

public class Temporada {

    private Long id;
    private String nome;
    private Long ligaId;
    private Boolean atualTemporada;

    public Temporada(Season season) {
        this.id = season.getId();
        this.nome = season.getName();
        this.ligaId = season.getLeagueId();
        this.atualTemporada = season.getCurrentSeason();
    }

    public Temporada() {
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

    public Long getLigaId() {
        return ligaId;
    }

    public void setLigaId(Long ligaId) {
        this.ligaId = ligaId;
    }

    public Boolean getAtualTemporada() {
        return atualTemporada;
    }

    public void setAtualTemporada(Boolean atualTemporada) {
        this.atualTemporada = atualTemporada;
    }
}
