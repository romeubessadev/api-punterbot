package br.com.touros.punterbot.api.scrapper.analise.dePara;

import br.com.touros.punterbot.api.integracao.sportmonks.response.Fixture;
import br.com.touros.punterbot.api.integracao.sportmonks.response.LiveScore;
import br.com.touros.punterbot.api.scrapper.analise.IJogoParaAnalise;

public class DeParaProcessorFactory {

    @SuppressWarnings("unchecked")
    public static <T extends IJogoParaAnalise> DeParaProcessor<T> Generete(T target) {
        if (target instanceof Fixture) {
            return (DeParaProcessor<T>) new FixtureDeParaProcessor((Fixture) target);
        } else if (target instanceof LiveScore) {
            return (DeParaProcessor<T>) new LiveScoreDeParaProcessor((LiveScore) target);
        }
        throw new RuntimeException("invalid.scrapper-processor.target");
    }

}
