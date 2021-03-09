package br.com.touros.punterbot.api.scrapper.flow;


import br.com.touros.punterbot.api.scrapper.flow.exception.HandlerException;

public interface IEstatisticaHandler<C extends Context<T>, T extends JogoState>  {
    void setContexto(C context);

    void analisar() throws HandlerException;
}
