package br.com.touros.punterbot.api.scrapper.analise;

import br.com.touros.punterbot.api.model.cadastro.Time;
import br.com.touros.punterbot.api.model.cadastro.estatisticas.BaseEstatistica;

public class SetResult {

    public static <T extends BaseEstatistica> void AddEscanteio(Time time, T resultado, Boolean isGeral) {
        if (isGeral) {
            time.getEstatistica().getEscanteios().adicionarGeral(resultado);
        } else
            time.getEstatistica().getEscanteios().adicionaLiga(resultado);
    }

    public static <T extends BaseEstatistica> void AddGol(Time time, T resultado, Boolean isGeral) {
        if (isGeral) {
            time.getEstatistica().getGols().adicionarGeral(resultado);
        } else
            time.getEstatistica().getGols().adicionaLiga(resultado);
    }
}
