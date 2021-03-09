package br.com.touros.punterbot.api.controller.request;

import br.com.touros.punterbot.api.exceptions.ValidException;
import br.com.touros.punterbot.api.utils.Utils;

public class AtualizarNomeRequest implements RequestValid {

    private Long id;
    private String nome;

    @Override
    public void isValid() throws ValidException {
        if (Utils.isNull(this.id)) {
            ValidException.Throw("Atualizar Nome", "Campo id é obrigatório!");
        }
        if (Utils.isNullOrEmpty(this.nome)) {
            ValidException.Throw("Atualizar Nome", "Campo nome é obrigatório!");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
