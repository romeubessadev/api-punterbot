package br.com.touros.punterbot.api.controller;

import br.com.touros.punterbot.api.controller.request.RequestValid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    public <R> ResponseEntity<R> Ok(R t) {
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    public void valida(RequestValid requestValid){
        requestValid.isValid();
    }
}
