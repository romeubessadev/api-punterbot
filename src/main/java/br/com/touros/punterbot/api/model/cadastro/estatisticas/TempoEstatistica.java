package br.com.touros.punterbot.api.model.cadastro.estatisticas;

public class TempoEstatistica extends BaseEstatistica {

    private Float mediaFavor;
    private Float mediaContra;
    private Float total;
    private Integer mediaTotal;

    private Integer qtdJogos;
    private Integer qtdJogosQueSaiu;
    private Float porcentagemQtdJogosQueSaiu;
    private Integer mediaTotalJogo;

    public TempoEstatistica() {
    }

    public Float getMediaFavor() {
        return mediaFavor;
    }

    public void setMediaFavor(Float mediaFavor) {
        this.mediaFavor = mediaFavor;
    }

    public Float getMediaContra() {
        return mediaContra;
    }

    public void setMediaContra(Float mediaContra) {
        this.mediaContra = mediaContra;
    }

    public Float getTotal() {
        return total;
    }

    public void total() {
        this.total = mediaFavor + mediaContra;
    }

    public Integer getMediaTotal() {
        return mediaTotal;
    }

    public void setMediaTotal(Integer mediaTotal) {
        this.mediaTotal = mediaTotal;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getQtdJogosQueSaiu() {
        return qtdJogosQueSaiu;
    }

    public void setQtdJogosQueSaiu(Integer qtdJogosQueSaiu) {
        this.qtdJogosQueSaiu = qtdJogosQueSaiu;
    }

    public Float getPorcentagemQtdJogosQueSaiu() {
        return porcentagemQtdJogosQueSaiu;
    }

    public void setPorcentagemQtdJogosQueSaiu(Float porcentagemQtdJogosQueSaiu) {
        this.porcentagemQtdJogosQueSaiu = porcentagemQtdJogosQueSaiu;
    }

    public Integer getQtdJogos() {
        return qtdJogos;
    }

    public void setQtdJogos(Integer qtdJogos) {
        this.qtdJogos = qtdJogos;
    }

    public void setMediaTotalJogo(Integer mediaTotalJogo) {
        this.mediaTotalJogo = mediaTotalJogo;
    }

    public Integer getMediaTotalJogo() {
        return mediaTotalJogo;
    }
}

