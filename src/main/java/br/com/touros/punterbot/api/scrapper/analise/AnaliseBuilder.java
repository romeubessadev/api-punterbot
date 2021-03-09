package br.com.touros.punterbot.api.scrapper.analise;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.analise.jogo.JogoAnaliseBuilder;

import java.util.List;

public class AnaliseBuilder implements IExecutarAnalise {

    private JogoAnaliseBuilder<?> jogoAnaliseBuilder;

    public AnaliseBuilder() {
    }

    @Override
    public List<Jogo> executar() {
        JogosAnalise jogosAnalise = new JogosAnalise(jogoAnaliseBuilder.converterJogos(), jogoAnaliseBuilder);
        return jogosAnalise.efetuarAnalise();
    }

    public IExecutarAnalise buscarJogo(JogoAnaliseBuilder<?> buscarJogos) {
        this.jogoAnaliseBuilder = buscarJogos;
        return this;
    }
}
