package br.com.touros.punterbot.api.model.cadastro.estatisticas;

public class AmbosMarcaramGolEstatistica extends BaseEstatistica {

    private Float media;
    private Float qtdJogos;
    private Float porcentagemDeJogos;

    public AmbosMarcaramGolEstatistica() {
    }

    public Float getMedia() {
        return media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }

    public Float getQtdJogos() {
        return qtdJogos;
    }

    public void setQtdJogos(Float qtdJogos) {
        this.qtdJogos = qtdJogos;
    }

    public Float getPorcentagemDeJogos() {
        return porcentagemDeJogos;
    }

    public void setPorcentagemDeJogos(Float porcentagemDeJogos) {
        this.porcentagemDeJogos = porcentagemDeJogos;
    }
}
