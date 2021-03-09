package br.com.touros.punterbot.api.exceptions;

import org.springframework.http.HttpStatus;

public class ValidException extends BaseException {

    public ValidException(String titulo, String mensagem) {
        super(HttpStatus.PRECONDITION_FAILED, titulo, mensagem);
    }

    public ValidException(String titulo, String mensagem, Throwable cause) {
        super(HttpStatus.PRECONDITION_FAILED, titulo, mensagem, cause);
    }

    public static void Throw(String titulo, String mensagem) {
        throw new ValidException(titulo, mensagem);
    }
}
