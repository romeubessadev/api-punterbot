package br.com.touros.punterbot.api.controller.response;

public class ContagemJogosResponse {

    private Integer jogosDeHoje;
    private Integer jogosAoVivo;

    public Integer getJogosDeHoje() {
        return jogosDeHoje;
    }

    public void setJogosDeHoje(Integer jogosDeHoje) {
        this.jogosDeHoje = jogosDeHoje;
    }

    public Integer getJogosAoVivo() {
        return jogosAoVivo;
    }

    public void setJogosAoVivo(Integer jogosAoVivo) {
        this.jogosAoVivo = jogosAoVivo;
    }
}
