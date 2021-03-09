package br.com.touros.punterbot.api.scrapper.flow;

import br.com.touros.punterbot.api.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"unchecked", "rawtypes"})
public abstract class Context<T extends JogoState> implements IContext<T> {

    private final Logger LOGGER = LoggerFactory.getLogger(super.getClass());

    private final T state;

    private IEstatisticaHandler estatisticaHandler;

    protected Context(T state, Handler primeiroEstatisticaHandler) {
        this.state = state;
        this.estatisticaHandler = primeiroEstatisticaHandler;
    }


    private boolean hasHandler() {
        return !Utils.isNull(this.estatisticaHandler);
    }

    @Override
    public void avancarParaProximaEstatisca(Handler estatisticaHandler) {
        this.estatisticaHandler = estatisticaHandler;
    }

    @Override
    public void handle() {
        while (hasHandler()) {

            String handlerName = estatisticaHandler.getClass().getSimpleName();

            LOGGER.info("Entrando no handler [{}]", handlerName);
            try {
                estatisticaHandler.setContexto(this);
                estatisticaHandler.analisar();
            } catch (Exception ex) {
                finish();
                LOGGER.error(ex.getMessage());
                ex.printStackTrace();
            }
            LOGGER.info("Saindo do handler [{}]", handlerName);
        }
    }

    public T getState() {
        return state;
    }

    public void finish() {
        this.estatisticaHandler = null;
    }
}
