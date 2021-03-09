package br.com.touros.punterbot.api.scrapper.flow;

public abstract class Handler<C extends Context<T>, T extends JogoState> implements IEstatisticaHandler<C, T> {
    private C contexto;

    public Handler() {
    }

    @Override
    public void setContexto(C context) {
        this.contexto = context;
    }

    public C getContexto() {
        return contexto;
    }
}

