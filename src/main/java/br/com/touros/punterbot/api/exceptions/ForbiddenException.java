package br.com.touros.punterbot.api.exceptions;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends BaseException {

    public ForbiddenException(String titulo, String mensagem) {
        super(HttpStatus.FORBIDDEN, titulo, mensagem);
    }

    public ForbiddenException(String titulo, String mensagem, Throwable cause) {
        super(HttpStatus.FORBIDDEN, titulo, mensagem, cause);
    }


    public static void Throw(String titulo, String mensagem) {
        throw new ForbiddenException(titulo, mensagem);
    }
}
