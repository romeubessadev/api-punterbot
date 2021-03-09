package br.com.touros.punterbot.api.scrapper.analise.jogo;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.flow.Context;
import br.com.touros.punterbot.api.scrapper.flow.JogoState;

public interface CriaContexto<C extends Context<T>, T extends JogoState> {
    C init(Jogo jogo);
}
