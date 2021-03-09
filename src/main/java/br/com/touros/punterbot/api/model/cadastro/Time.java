package br.com.touros.punterbot.api.model.cadastro;

import br.com.touros.punterbot.api.core.persistence.IMongoEntity;
import br.com.touros.punterbot.api.integracao.sportmonks.response.Team;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("time")
public class Time implements IMongoEntity<Long> {

    private Long id;
    private String nome;
    private String logo;
    private String twitter;
    private Integer anoFundado;
    private Boolean nacional;

    private TimeEstatistica estatistica;
    private TimeJogoHistorico ultimosJogos;

    public Time() {
    }

    public Time(Team teamVisitor) {
        this.id = teamVisitor.getId();
        this.nome = teamVisitor.getName();
        this.logo = teamVisitor.getLogoPath();
        this.twitter = teamVisitor.getTwitter();
        this.anoFundado = teamVisitor.getFounded();
        this.nacional = teamVisitor.getNationalTeam();
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

    public TimeEstatistica getEstatistica() {
        if (estatistica == null) estatistica = new TimeEstatistica();
        return estatistica;
    }

    public void setEstatistica(TimeEstatistica estatistica) {
        this.estatistica = estatistica;
    }

    public TimeJogoHistorico getUltimosJogos() {
        if (ultimosJogos == null) ultimosJogos = new TimeJogoHistorico();
        return ultimosJogos;
    }

    public void setUltimosJogos(TimeJogoHistorico ultimosJogos) {
        this.ultimosJogos = ultimosJogos;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Integer getAnoFundado() {
        return anoFundado;
    }

    public void setAnoFundado(Integer anoFundado) {
        this.anoFundado = anoFundado;
    }

    public Boolean getNacional() {
        return nacional;
    }

    public void setNacional(Boolean nacional) {
        this.nacional = nacional;
    }
}
