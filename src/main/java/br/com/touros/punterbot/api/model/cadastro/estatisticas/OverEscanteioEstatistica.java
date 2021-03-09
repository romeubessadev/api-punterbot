package br.com.touros.punterbot.api.model.cadastro.estatisticas;

public class OverEscanteioEstatistica extends BaseEstatistica {

    private Float mediaTimeCasa;
    private Float mediaTimeVisita;
    private Float porcentagemMedia;

    public OverEscanteioEstatistica() {
    }

    public OverEscanteioEstatistica( Float mediaTimeCasa, Float mediaTimeVisita, Float porcentagemMedia) {
        this.mediaTimeCasa = mediaTimeCasa;
        this.mediaTimeVisita = mediaTimeVisita;
        this.porcentagemMedia = porcentagemMedia;
    }

    public Float getMediaTimeCasa() {
        return mediaTimeCasa;
    }

    public Float getMediaTimeVisita() {
        return mediaTimeVisita;
    }

    public Float getPorcentagemMedia() {
        return porcentagemMedia;
    }
}
