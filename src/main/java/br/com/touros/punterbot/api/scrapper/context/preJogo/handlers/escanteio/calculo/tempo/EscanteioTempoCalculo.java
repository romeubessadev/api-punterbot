package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.escanteio.calculo.tempo;

import br.com.touros.punterbot.api.model.cadastro.Escanteio;
import br.com.touros.punterbot.api.model.cadastro.JogoHistorico;
import br.com.touros.punterbot.api.model.cadastro.Time;
import br.com.touros.punterbot.api.model.cadastro.estatisticas.TempoEstatistica;
import br.com.touros.punterbot.api.scrapper.context.preJogo.EstatisticaCalculo;
import br.com.touros.punterbot.api.utils.Utils;

import java.util.List;

public class EscanteioTempoCalculo extends EstatisticaCalculo {

    private final Integer minutoMinimo;
    private final Integer minutoMaximo;

    private TempoEstatistica resultadoTimeCasa;
    private TempoEstatistica resultadoTimeVisita;

    protected EscanteioTempoCalculo(Integer minutoMinimo, Integer minutoMaximo) {
        this.minutoMinimo = minutoMinimo;
        this.minutoMaximo = minutoMaximo;
    }

    public void calcular() {
        resultadoTimeCasa = analisarJogo(getTimeCasa(), getUltimosJogosTimeCasa());
        resultadoTimeVisita = analisarJogo(getTimeVisita(), getUltimosJogosTimeVisita());
        calcularMediaTotal();
    }

    private void calcularMediaTotal() {
        if (Utils.isNull(resultadoTimeCasa) || Utils.isNull(resultadoTimeVisita))
            return;

        var mediaTotal = Math.round(resultadoTimeCasa.getTotal() + resultadoTimeVisita.getTotal()) / 2;
        var mediaQtdJogos = Math.round(resultadoTimeCasa.getQtdJogosQueSaiu() + resultadoTimeVisita.getQtdJogosQueSaiu()) / 2;
        resultadoTimeCasa.setMediaTotal(mediaTotal);
        resultadoTimeVisita.setMediaTotal(mediaTotal);

        resultadoTimeCasa.setMediaTotalJogo(mediaQtdJogos);
        resultadoTimeVisita.setMediaTotalJogo(mediaQtdJogos);
    }


    public TempoEstatistica getResultadoTimeCasa() {
        return resultadoTimeCasa;
    }

    public TempoEstatistica getResultadoTimeVisita() {
        return resultadoTimeVisita;
    }

    private TempoEstatistica analisarJogo(Time time, List<JogoHistorico> jogos) {
        Integer qtdJogos = jogos.size();
        if (qtdJogos == 0) {
            return null;
        }

        Float qtdJogosQueSaiu = 0f;
        Float qtdEscanteioFavor = 0f;
        Float qtdEscanteioContra = 0f;

        for (JogoHistorico jogo : jogos) {
            if (Utils.isNullOrEmpty(jogo.getEscanteios())) {
                continue;
            }

            boolean jaMarcouEscanteioDesseJogo = false;

            for (Escanteio escanteio : jogo.getEscanteios()) {

                if (!Utils.isNullOrEmpty(escanteio.getComentario()) && escanteio.getComentario().toUpperCase().contains("RACE"))
                    continue;

                if (escanteio.getMinuto() >= minutoMinimo && escanteio.getMinuto() <= minutoMaximo) {
                    if (!jaMarcouEscanteioDesseJogo) {
                        jaMarcouEscanteioDesseJogo = true;
                        qtdJogosQueSaiu++;
                    }

                    if (escanteio.getTimeId().equals(time.getId())) {
                        qtdEscanteioFavor++;
                    } else {
                        qtdEscanteioContra++;
                    }
                }
            }
        }

        var resultado = new TempoEstatistica();
        resultado.setQtdJogos(qtdJogos);
        resultado.setMediaFavor(qtdEscanteioFavor / qtdJogos);
        resultado.setMediaContra(qtdEscanteioContra / qtdJogos);

        resultado.setQtdJogosQueSaiu(qtdJogosQueSaiu.intValue());
        resultado.setPorcentagemQtdJogosQueSaiu((qtdJogosQueSaiu * 100) / qtdJogos);
        resultado.total();
        return resultado;
    }

}
