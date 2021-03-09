package br.com.touros.punterbot.api.exceptions;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {
    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    private String titulo;
    private String mensagem;

    public BaseException(HttpStatus httpStatus, String titulo, String mensagem) {
        super(mensagem);
        this.httpStatus = httpStatus;
        this.titulo = titulo;
        this.mensagem = mensagem;
    }

    public BaseException(HttpStatus httpStatus, String titulo, String mensagem, Throwable cause) {
        super(mensagem, cause);
        this.httpStatus = httpStatus;
        this.titulo = titulo;
        this.mensagem = mensagem;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
