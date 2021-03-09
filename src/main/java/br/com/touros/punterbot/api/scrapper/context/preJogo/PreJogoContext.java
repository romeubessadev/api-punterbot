package br.com.touros.punterbot.api.scrapper.context.preJogo;


import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.context.preJogo.handlers.escanteio.FtEscanteioHandler;
import br.com.touros.punterbot.api.scrapper.flow.Context;

import java.io.Serializable;

public class PreJogoContext extends Context<Jogo> implements Serializable {





    public PreJogoContext(Jogo Jogo) {
        super(Jogo, new FtEscanteioHandler());
    }
}
