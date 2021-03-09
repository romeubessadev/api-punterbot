package br.com.touros.punterbot.api.scrapper.flow;


public interface IContext<T extends JogoState> {
    void avancarParaProximaEstatisca(Handler estatisticaHandler);

    void handle();
}
