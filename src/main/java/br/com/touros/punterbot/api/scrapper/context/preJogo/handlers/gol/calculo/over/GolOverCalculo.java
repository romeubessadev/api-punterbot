package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol.calculo.over;


import br.com.touros.punterbot.api.model.cadastro.Gols;
import br.com.touros.punterbot.api.model.cadastro.JogoHistorico;
import br.com.touros.punterbot.api.model.cadastro.Time;
import br.com.touros.punterbot.api.model.cadastro.estatisticas.TempoEstatistica;
import br.com.touros.punterbot.api.scrapper.context.preJogo.EstatisticaCalculo;
import br.com.touros.punterbot.api.utils.Utils;

import java.util.List;

public class GolOverCalculo extends EstatisticaCalculo {

    private final Integer qtdGolsMinimos;
    private final Integer minutoMinimo;
    private final Integer minutoMaximo;


    private TempoEstatistica resultadoTimeCasa;
    private TempoEstatistica resultadoTimeVisita;

    public GolOverCalculo(Integer qtdGolsMinimos, Integer minutoMinimo, Integer minutoMaximo) {
        this.qtdGolsMinimos = qtdGolsMinimos;
        this.minutoMinimo = minutoMinimo;
        this.minutoMaximo = minutoMaximo;
    }

    public void calcular() {
        resultadoTimeCasa = analisarJogo(getTimeCasa(), getUltimosJogosTimeCasa());
        resultadoTimeVisita = analisarJogo(getTimeVisita(), getUltimosJogosTimeVisita());
        calcularMediaTotal();
    }

    private TempoEstatistica analisarJogo(Time time, List<JogoHistorico> jogos) {
        var qtdJogos = jogos.size();
        if (qtdJogos == 0) {
            return null;
        }

        var qtdJogosSaiuGolsFavor = 0f;
        var qtdJogosSaiuGolsContra = 0f;

        for (JogoHistorico jogo : jogos) {
            if (Utils.isNullOrEmpty(jogo.getGols())) {
                continue;
            }

            var qtdGolsFavor = 0f;
            var qtdGolsContra = 0f;

            for (Gols goal : jogo.getGols()) {
                if (goal.getMinuto() >= minutoMinimo && goal.getMinuto() <= minutoMaximo) {

                    if (goal.getTimeId().equals(time.getId())) {
                        qtdGolsFavor++;
                    } else {
                        qtdGolsContra++;
                    }
                }
            }

            if (qtdGolsFavor >= qtdGolsMinimos)
                qtdJogosSaiuGolsFavor++;

            if (qtdGolsContra >= qtdGolsMinimos)
                qtdJogosSaiuGolsContra++;
        }

        var resultado = new TempoEstatistica();
        resultado.setMediaFavor(qtdJogosSaiuGolsFavor / qtdJogos);
        resultado.setMediaContra(qtdJogosSaiuGolsContra / qtdJogos);
        resultado.setQtdJogosQueSaiu((int) (qtdJogosSaiuGolsFavor + qtdJogosSaiuGolsContra));
        resultado.setPorcentagemQtdJogosQueSaiu((float) ((resultado.getQtdJogosQueSaiu() * 100) / qtdJogos));
        resultado.total();
        return resultado;
    }

    private void calcularMediaTotal() {
        if (Utils.isNull(resultadoTimeCasa) || Utils.isNull(resultadoTimeVisita))
            return;

        Integer mediaTotal = Math.round(resultadoTimeCasa.getTotal() + resultadoTimeVisita.getTotal()) / 2;
        resultadoTimeCasa.setMediaTotal(mediaTotal);
        resultadoTimeVisita.setMediaTotal(mediaTotal);

        Integer mediaQtdJogos = Math.round(resultadoTimeCasa.getQtdJogosQueSaiu() + resultadoTimeVisita.getQtdJogosQueSaiu()) / 2;
        resultadoTimeCasa.setMediaTotalJogo(mediaQtdJogos);
        resultadoTimeVisita.setMediaTotalJogo(mediaQtdJogos);
    }

    public TempoEstatistica getResultadoTimeCasa() {
        return resultadoTimeCasa;
    }

    public TempoEstatistica getResultadoTimeVisita() {
        return resultadoTimeVisita;
    }



}
