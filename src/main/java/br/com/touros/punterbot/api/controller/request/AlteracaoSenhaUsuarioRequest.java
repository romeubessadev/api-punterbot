package br.com.touros.punterbot.api.controller.request;

import br.com.touros.punterbot.api.exceptions.ValidException;
import br.com.touros.punterbot.api.utils.Utils;

public class AlteracaoSenhaUsuarioRequest implements RequestValid {

    private String senha;
    private String confirmaSenha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    @Override
    public void isValid() throws ValidException {
        if (Utils.isNullOrEmpty(this.senha)) {
            ValidException.Throw("Alteração Senha", "Campo senha é obrigatório!");
        }

        if (Utils.isNull(this.confirmaSenha)) {
            ValidException.Throw("Alteração Senha", "Campo confirmaSenha é obrigatório!");
        }
    }
}
