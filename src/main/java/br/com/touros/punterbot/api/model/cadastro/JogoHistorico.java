package br.com.touros.punterbot.api.model.cadastro;

import br.com.touros.punterbot.api.integracao.sportmonks.response.Fixture;
import br.com.touros.punterbot.api.utils.Utils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JogoHistorico {

    private Long id;
    private Date data;
    private Long timeCasaId;
    private String timeCasaNome;

    private Long timeVisitaId;
    private String timeVisitaNome;

    private List<Escanteio> escanteios;
    private List<Gols> gols;

    public JogoHistorico() {
    }

    public JogoHistorico(Fixture fixture) {
        this.id = fixture.getId();
        this.data = fixture.getTime().getStartingAt().getTimestampToDate();
        this.timeCasaId = fixture.getLocalTeam().getData().getId();
        this.timeCasaNome = fixture.getLocalTeam().getData().getName();
        this.timeVisitaId = fixture.getVisitorTeam().getData().getId();
        this.timeVisitaNome = fixture.getVisitorTeam().getData().getName();

        if (!Utils.isNull(fixture.getCorners()) && !Utils.isNullOrEmpty(fixture.getCorners().getData()))
            this.escanteios = fixture.getCorners().getData().stream().map(Escanteio::new).collect(Collectors.toList());

        if (!Utils.isNull(fixture.getGoals()) && !Utils.isNullOrEmpty(fixture.getGoals().getData()))
            this.gols = fixture.getGoals().getData().stream().map(Gols::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimeCasaId() {
        return timeCasaId;
    }

    public void setTimeCasaId(Long timeCasaId) {
        this.timeCasaId = timeCasaId;
    }

    public String getTimeCasaNome() {
        return timeCasaNome;
    }

    public void setTimeCasaNome(String timeCasaNome) {
        this.timeCasaNome = timeCasaNome;
    }

    public Long getTimeVisitaId() {
        return timeVisitaId;
    }

    public void setTimeVisitaId(Long timeVisitaId) {
        this.timeVisitaId = timeVisitaId;
    }

    public String getTimeVisitaNome() {
        return timeVisitaNome;
    }

    public void setTimeVisitaNome(String timeVisitaNome) {
        this.timeVisitaNome = timeVisitaNome;
    }

    public List<Escanteio> getEscanteios() {
        return escanteios;
    }

    public void setEscanteios(List<Escanteio> escanteios) {
        this.escanteios = escanteios;
    }

    public List<Gols> getGols() {
        return gols;
    }

    public void setGols(List<Gols> gols) {
        this.gols = gols;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
