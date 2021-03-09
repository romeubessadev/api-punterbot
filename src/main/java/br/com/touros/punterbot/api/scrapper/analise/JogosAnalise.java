package br.com.touros.punterbot.api.scrapper.analise;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.analise.jogo.CriaContexto;
import br.com.touros.punterbot.api.utils.Utils;
import br.com.touros.punterbot.api.scrapper.flow.Context;
import io.jsonwebtoken.lang.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class JogosAnalise {
    private final static Logger LOGGER = LoggerFactory.getLogger(JogosAnalise.class);

    private final List<Jogo> jogosParaAnalise;
    private final CriaContexto<?, Jogo> criaContexto;

    protected JogosAnalise(List<Jogo> jogosParaAnalise, CriaContexto<?, Jogo> criaContexto) {
        Assert.notNull(jogosParaAnalise);
        this.jogosParaAnalise = jogosParaAnalise;
        this.criaContexto = criaContexto;
    }

    public List<Jogo> efetuarAnalise() {
        LOGGER.info("Efetuando Análise de {} Jogos...", jogosParaAnalise.size());

        for (Jogo jogo : this.jogosParaAnalise) {
            Context<?> context = criaContexto.init(jogo);

            if (Utils.isNull(context)) {
                throw new RuntimeException("jogo.analise.context.null");
            }
            context.handle();
        }

        LOGGER.info("Análise Finalizada: {} processados", jogosParaAnalise.size());
        return this.jogosParaAnalise;
    }

    public static AnaliseBuilder NovaAnalise() {
        return new AnaliseBuilder();
    }

}
