package br.com.touros.punterbot.api.scrapper.context.aoVivo;


import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.flow.Context;

import java.io.Serializable;

public class AoVivoContext extends Context<Jogo> implements Serializable {

    AoVivoContext(Jogo Jogo) {
        super(Jogo, null);
    }
}

