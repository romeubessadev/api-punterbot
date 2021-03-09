package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.escanteio.calculo.over;

import br.com.touros.punterbot.api.model.cadastro.Escanteio;
import br.com.touros.punterbot.api.model.cadastro.JogoHistorico;
import br.com.touros.punterbot.api.model.cadastro.Time;
import br.com.touros.punterbot.api.model.cadastro.estatisticas.OverEscanteioEstatistica;
import br.com.touros.punterbot.api.scrapper.context.preJogo.EstatisticaCalculo;
import br.com.touros.punterbot.api.utils.Utils;

import java.util.List;

public class EscanteioOverCalculo extends EstatisticaCalculo {
    private final Integer qtdEscanteiosMinimo;

    private OverEscanteioEstatistica resultado;

    protected EscanteioOverCalculo(Integer qtdEscanteios) {
        this.qtdEscanteiosMinimo = qtdEscanteios;
    }

    public void calcular() {
        if (Utils.isNullOrEmpty(getUltimosJogosTimeCasa()) || Utils.isNullOrEmpty(getUltimosJogosTimeCasa())) {
            return;
        }

        var mediaTimeCasa = analisarJogo(getTimeCasa(), getUltimosJogosTimeCasa());
        var mediaTimeFora = analisarJogo(getTimeVisita(), getUltimosJogosTimeCasa());
        var porcentagemMedia = (mediaTimeCasa + mediaTimeFora) / 2;
        this.resultado = new OverEscanteioEstatistica(mediaTimeCasa, mediaTimeFora, porcentagemMedia);
    }

    public OverEscanteioEstatistica getResultado() {
        return resultado;
    }

    private Float analisarJogo(Time time, List<JogoHistorico> jogos) {
        var qtdJogosQueSaiu = 0f;

        for (JogoHistorico jogo : jogos) {

            if (Utils.isNullOrEmpty(jogo.getEscanteios())) {
                continue;
            }

            var qtdGols = 0f;

            for (Escanteio escanteio : jogo.getEscanteios()) {
                if (escanteio.getTimeId().equals(time.getId())) {
                    qtdGols++;
                }
            }

            if (qtdGols > qtdEscanteiosMinimo)
                qtdJogosQueSaiu++;

        }
        return qtdJogosQueSaiu;
    }

}
