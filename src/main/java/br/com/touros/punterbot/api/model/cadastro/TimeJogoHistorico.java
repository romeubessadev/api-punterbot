package br.com.touros.punterbot.api.model.cadastro;

import java.util.List;

public class TimeJogoHistorico {

    private List<JogoHistorico> geral;
    private List<JogoHistorico> liga;

    public List<JogoHistorico> getGeral() {
        return geral;
    }

    public void setGeral(List<JogoHistorico> geral) {
        this.geral = geral;
    }

    public List<JogoHistorico> getLiga() {
        return liga;
    }

    public void setLiga(List<JogoHistorico> liga) {
        this.liga = liga;
    }
}
