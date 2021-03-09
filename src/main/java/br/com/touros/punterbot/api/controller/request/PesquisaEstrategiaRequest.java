package br.com.touros.punterbot.api.controller.request;

import java.util.List;

public class PesquisaEstrategiaRequest {
    private List<PesquisaEstrategia> escanteios;
    private List<PesquisaEstrategia> gols;

    public List<PesquisaEstrategia> getEscanteios() {
        return escanteios;
    }

    public void setEscanteios(List<PesquisaEstrategia> escanteios) {
        this.escanteios = escanteios;
    }

    public List<PesquisaEstrategia> getGols() {
        return gols;
    }

    public void setGols(List<PesquisaEstrategia> gols) {
        this.gols = gols;
    }
}
