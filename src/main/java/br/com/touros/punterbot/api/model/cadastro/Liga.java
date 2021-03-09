package br.com.touros.punterbot.api.model.cadastro;

import br.com.touros.punterbot.api.core.persistence.IMongoEntity;
import br.com.touros.punterbot.api.integracao.sportmonks.response.League;
import br.com.touros.punterbot.api.utils.Utils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Document("liga")
public class Liga implements IMongoEntity<Long> {

    private Long id;
    private String nome;
    private String logo;

    private List<Temporada> temporadas;

    public Liga() {
    }

    public Liga(League league) {
        this.id = league.getId();
        this.logo = league.getLogoPath();
        this.nome = league.getName();
        if (!Utils.isNull(league.getSeasons()) && !Utils.isNullOrEmpty(league.getSeasons().getSeasons()))
            this.temporadas = league.getSeasons().getSeasons().stream().map(Temporada::new).collect(Collectors.toList());
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

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }
}
