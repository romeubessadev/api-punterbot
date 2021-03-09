package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol.calculo.tempo;

import br.com.touros.punterbot.api.model.cadastro.Gols;
import br.com.touros.punterbot.api.model.cadastro.JogoHistorico;
import br.com.touros.punterbot.api.model.cadastro.Time;
import br.com.touros.punterbot.api.model.cadastro.estatisticas.TempoEstatistica;
import br.com.touros.punterbot.api.scrapper.context.preJogo.EstatisticaCalculo;
import br.com.touros.punterbot.api.utils.Utils;

import java.util.List;

public class GolTempoCalculo extends EstatisticaCalculo {

    private final Integer minutoMinimo;
    private final Integer minutoMaximo;

    private TempoEstatistica resultadoTimeCasa;
    private TempoEstatistica resultadoTimeVisita;

    protected GolTempoCalculo(Integer minutoMinimo, Integer minutoMaximo) {
        this.minutoMinimo = minutoMinimo;
        this.minutoMaximo = minutoMaximo;
    }

    public void calcular() {
        this.resultadoTimeCasa = analisarJogo(getTimeCasa(), getUltimosJogosTimeCasa());
        this.resultadoTimeVisita = analisarJogo(getTimeVisita(), getUltimosJogosTimeVisita());
        calcularMediaTotal();
    }

    public TempoEstatistica getResultadoTimeCasa() {
        return resultadoTimeCasa;
    }

    public TempoEstatistica getResultadoTimeVisita() {
        return resultadoTimeVisita;
    }

    private void calcularMediaTotal() {
        if (Utils.isNull(resultadoTimeCasa) || Utils.isNull(resultadoTimeVisita))
            return;

        Integer mediaTotal = Math.round(resultadoTimeCasa.getTotal() + resultadoTimeVisita.getTotal()) / 2;
        resultadoTimeCasa.setMediaTotal(mediaTotal);
        resultadoTimeVisita.setMediaTotal(mediaTotal);
    }

    private TempoEstatistica analisarJogo(Time time, List<JogoHistorico> jogos) {
        Integer qtdJogos = jogos.size();
        if (qtdJogos == 0) {
            return null;
        }
        Float qtdGolsFavor = 0f;
        Float qtdGolsContra = 0f;

        for (JogoHistorico jogo : jogos) {
            if (Utils.isNullOrEmpty(jogo.getGols())) {
                continue;
            }
            for (Gols goal : jogo.getGols()) {
                if (goal.getMinuto() >= minutoMinimo && goal.getMinuto() <= minutoMaximo) {

                    if (goal.getTimeId().equals(time.getId())) {
                        qtdGolsFavor++;
                    } else {
                        qtdGolsContra++;
                    }
                }
            }
        }

        var resultado = new TempoEstatistica();
        resultado.setMediaFavor(qtdGolsFavor / qtdJogos);
        resultado.setMediaContra(qtdGolsContra / qtdJogos);
        resultado.total();
        return resultado;
    }

}
