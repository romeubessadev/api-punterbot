package br.com.touros.punterbot.api.exceptions;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends BaseException {

    public UnauthorizedException(String titulo, String mensagem) {
        super(HttpStatus.UNAUTHORIZED, titulo, mensagem);
    }

    public UnauthorizedException(String titulo, String mensagem, Throwable cause) {
        super(HttpStatus.UNAUTHORIZED, titulo, mensagem, cause);
    }


    public static void Throw(String titulo, String mensagem) {
        throw new UnauthorizedException(titulo, mensagem);
    }
}
