package br.com.touros.punterbot.api.scrapper.analise.jogo;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.analise.IJogoParaAnalise;
import br.com.touros.punterbot.api.scrapper.context.preJogo.PreJogoContext;

import java.util.ArrayList;
import java.util.List;

public class DeHojeJogoAnaliseBuilder extends JogoAnaliseBuilder<PreJogoContext> {

    protected DeHojeJogoAnaliseBuilder() {
    }

    @Override
    public List<IJogoParaAnalise> buscarJogosParaAnalise() {
        return new ArrayList<>(getSportMonksRestApi().buscarJogosHoje());
    }

    @Override
    public PreJogoContext init(Jogo jogo) {
        return new PreJogoContext(jogo);
    }
}
