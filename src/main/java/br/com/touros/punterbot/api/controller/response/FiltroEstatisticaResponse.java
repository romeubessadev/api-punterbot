package br.com.touros.punterbot.api.controller.response;

import br.com.touros.punterbot.api.utils.SelectItem;

import java.util.List;

public class FiltroEstatisticaResponse {

    private List<SelectItem> gol;
    private List<SelectItem> escanteio;

    public FiltroEstatisticaResponse() {
    }

    public List<SelectItem> getGol() {
        return gol;
    }

    public void setGol(List<SelectItem> gol) {
        this.gol = gol;
    }

    public List<SelectItem> getEscanteio() {
        return escanteio;
    }

    public void setEscanteio(List<SelectItem> escanteio) {
        this.escanteio = escanteio;
    }
}
