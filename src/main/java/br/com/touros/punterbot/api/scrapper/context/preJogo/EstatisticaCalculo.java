package br.com.touros.punterbot.api.scrapper.context.preJogo;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.model.cadastro.JogoHistorico;
import br.com.touros.punterbot.api.model.cadastro.Time;

import java.util.List;

public abstract class EstatisticaCalculo {
    private Jogo jogo;
    private Boolean geral;

    public abstract void calcular();

    public void setJogo(Jogo Jogo, Boolean geral) {
        this.jogo = Jogo;
        this.geral = geral;
    }

    protected List<JogoHistorico> getUltimosJogosTimeCasa() {
        return geral ? getTimeCasa().getUltimosJogos().getGeral() : getTimeCasa().getUltimosJogos().getLiga();
    }

    protected List<JogoHistorico> getUltimosJogosTimeVisita() {
        return geral ? getTimeVisita().getUltimosJogos().getGeral() : getTimeVisita().getUltimosJogos().getLiga();
    }

    protected Time getTimeCasa() {
        return jogo.getTimeCasa();
    }

    protected Time getTimeVisita() {
        return jogo.getTimeVisita();
    }

    public Boolean getGeral() {
        return geral;
    }
}
