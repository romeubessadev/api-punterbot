package br.com.touros.punterbot.api.model.cadastro;

import br.com.touros.punterbot.api.scrapper.flow.JogoState;
import org.springframework.data.annotation.Id;

public class Jogo extends JogoState {

    @Id
    private Long id;
    private Tempo data;
    private Liga liga;
    private Time timeCasa;
    private Time timeVisita;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tempo getData() {
        return data;
    }

    public void setData(Tempo data) {
        this.data = data;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    public Time getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(Time timeCasa) {
        this.timeCasa = timeCasa;
    }

    public Time getTimeVisita() {
        return timeVisita;
    }

    public void setTimeVisita(Time timeVisita) {
        this.timeVisita = timeVisita;
    }

    public String getNomeTimes() {
        return String.format("%s vs %s", timeCasa.getNome(), timeVisita.getNome());
    }

}
