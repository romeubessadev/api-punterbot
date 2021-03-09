package br.com.touros.punterbot.api.scrapper.analise.jogo;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.analise.IJogoParaAnalise;
import br.com.touros.punterbot.api.scrapper.context.preJogo.PreJogoContext;

import java.util.ArrayList;
import java.util.List;

public class PorIdJogoAnaliseBuilder extends JogoAnaliseBuilder<PreJogoContext> {

    private final Long fixtureId;

    protected PorIdJogoAnaliseBuilder(Long fixtureId) {
        this.fixtureId = fixtureId;
    }

    @Override
    public List<IJogoParaAnalise> buscarJogosParaAnalise() {
        return new ArrayList<>(getSportMonksRestApi().buscarFixturePorId(fixtureId));
    }

    @Override
    public PreJogoContext init(Jogo jogo) {
        return new PreJogoContext(jogo);
    }
}
