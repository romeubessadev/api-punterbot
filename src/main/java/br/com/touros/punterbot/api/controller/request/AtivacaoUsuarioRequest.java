package br.com.touros.punterbot.api.controller.request;

import java.util.Date;

public class AtivacaoUsuarioRequest extends AtualizarUsuarioRequest {

    private final Date primeiroAcesso = new Date();

    public Date getPrimeiroAcesso() {
        return primeiroAcesso;
    }
}
