package br.com.touros.punterbot.api.integracao.hotmart.exception;

import br.com.touros.punterbot.api.integracao.hotmart.response.ErrorResponse;
import org.springframework.http.HttpStatus;

public class HotmartResponseException extends RuntimeException {

    private ErrorResponse errorBody;
    private HttpStatus httpStatus;

    public HotmartResponseException(ErrorResponse errorBody, HttpStatus httpStatus) {
        this.errorBody = errorBody;
        this.httpStatus = httpStatus;
    }

    public ErrorResponse getErrorBody() {
        return errorBody;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
