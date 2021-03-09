package br.com.touros.punterbot.api.controller.request;

import br.com.touros.punterbot.api.scrapper.analise.jogo.JogoAnaliseBuilder;
import br.com.touros.punterbot.api.scrapper.analise.jogo.JogoPesquisaFactory;

public enum ExtracaoRequestEnum {
    AO_VIVO(JogoPesquisaFactory::AoVivo),
    HOJE(JogoPesquisaFactory::DeHoje),
    AMANHA(JogoPesquisaFactory::Amanha),
    MES(JogoPesquisaFactory::Mes);

    private CriarJogoAnalise criarJogoAnalise;

    ExtracaoRequestEnum(CriarJogoAnalise criarJogoAnalise) {
        this.criarJogoAnalise = criarJogoAnalise;
    }

    public JogoAnaliseBuilder<?> getJogo() {
        return criarJogoAnalise.criar();
    }

    public interface CriarJogoAnalise {
        JogoAnaliseBuilder<?> criar();
    }

}
