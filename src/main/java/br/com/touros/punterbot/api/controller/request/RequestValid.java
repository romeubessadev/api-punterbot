package br.com.touros.punterbot.api.controller.request;

import br.com.touros.punterbot.api.exceptions.ValidException;

public interface RequestValid {
    void isValid() throws ValidException;


}
