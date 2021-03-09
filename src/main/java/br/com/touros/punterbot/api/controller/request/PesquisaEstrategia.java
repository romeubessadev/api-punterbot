package br.com.touros.punterbot.api.controller.request;

public class PesquisaEstrategia {
    private Boolean liga;
    private String chave;
    private Integer valor;

    public Boolean getLiga() {
        return liga;
    }

    public void setLiga(Boolean liga) {
        this.liga = liga;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String path() {
        return (liga ? "liga." : "geral.") + chave;
    }
}
