package br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.gol.calculo.ambos;

import br.com.touros.punterbot.api.model.cadastro.JogoHistorico;
import br.com.touros.punterbot.api.scrapper.context.preJogo.EstatisticaCalculo;
import br.com.touros.punterbot.api.model.cadastro.estatisticas.AmbosMarcaramGolEstatistica;
import br.com.touros.punterbot.api.utils.Utils;

import java.util.List;

public class GolAmbosMarcaramCalculo extends EstatisticaCalculo {

    private AmbosMarcaramGolEstatistica resultadoTimeCasa;
    private AmbosMarcaramGolEstatistica resultadoTimeVisita;

    public void calcular() {
        this.resultadoTimeCasa = analisarJogo(getUltimosJogosTimeCasa());
        this.resultadoTimeVisita = analisarJogo(getUltimosJogosTimeVisita());
    }

    public AmbosMarcaramGolEstatistica getResultadoTimeCasa() {
        return resultadoTimeCasa;
    }

    public AmbosMarcaramGolEstatistica getResultadoTimeVisita() {
        return resultadoTimeVisita;
    }

    private AmbosMarcaramGolEstatistica analisarJogo(List<JogoHistorico> jogos) {
        int qtdJogos = jogos.size();
        if (qtdJogos == 0) {
            return null;
        }
        var qtsJogosTiveramGol = 0f;

        for (JogoHistorico jogo : jogos) {
            if (!Utils.isNullOrEmpty(jogo.getGols())) {
                qtsJogosTiveramGol++;
            }
        }

        var resultado = new AmbosMarcaramGolEstatistica();
        resultado.setMedia(qtsJogosTiveramGol / qtdJogos);
        resultado.setQtdJogos(qtsJogosTiveramGol);
        resultado.setPorcentagemDeJogos((qtsJogosTiveramGol * 100) / qtdJogos);
        return resultado;
    }



}
