package br.com.touros.punterbot.api.scrapper.analise.jogo;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.analise.IJogoParaAnalise;
import br.com.touros.punterbot.api.scrapper.context.preJogo.PreJogoContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PorDataJogoAnaliseBuilder extends JogoAnaliseBuilder<PreJogoContext> {

    private final  Date dataInicio;
    private final  Date dataFim;

    public PorDataJogoAnaliseBuilder(Date dataInicio, Date dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    @Override
    public List<IJogoParaAnalise> buscarJogosParaAnalise() {
        return new ArrayList<>(getSportMonksRestApi().buscarJogosPorData(dataInicio, dataFim));
    }

    @Override
    public PreJogoContext init(Jogo jogo) {
        return new PreJogoContext(jogo);
    }
}
