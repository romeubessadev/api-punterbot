package br.com.touros.punterbot.api.scrapper.analise.jogo;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.analise.IJogoParaAnalise;
import br.com.touros.punterbot.api.scrapper.context.aoVivo.AoVivoContext;

import java.util.ArrayList;
import java.util.List;

public class AoVivoJogoAnaliseBuilder extends JogoAnaliseBuilder<AoVivoContext> {

    protected AoVivoJogoAnaliseBuilder() {
    }

    @Override
    public List<IJogoParaAnalise> buscarJogosParaAnalise() {
        return new ArrayList<>(getSportMonksRestApi().buscarJogosAoVivo());
    }

    @Override
    public AoVivoContext init(Jogo jogo) {
        return null;
    }
}
