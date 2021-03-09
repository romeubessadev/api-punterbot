package br.com.touros.punterbot.api.controller.request;

import br.com.touros.punterbot.api.exceptions.ValidException;
import br.com.touros.punterbot.api.model.cadastro.enums.UsuarioPlanoEnum;
import br.com.touros.punterbot.api.utils.Utils;

public class UsuarioPlanoRequest implements RequestValid {

    private String email;
    private Long codigoIndicacao;
    private UsuarioPlanoEnum plano;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCodigoIndicacao() {
        return codigoIndicacao;
    }

    public void setCodigoIndicacao(Long codigoIndicacao) {
        this.codigoIndicacao = codigoIndicacao;
    }

    @Override
    public void isValid() throws ValidException {
        if (Utils.isNullOrEmpty(this.email)) {
            ValidException.Throw("Atualizar Usuário", "Campo email é obrigatório!");
        }
        if (Utils.isNull(this.codigoIndicacao)) {
            ValidException.Throw("Atualizar Usuário", "Campo codigoIndicacao é obrigatório!");
        }
    }

    public UsuarioPlanoEnum getPlano() {
        return plano;
    }

    public void setPlano(UsuarioPlanoEnum plano) {
        this.plano = plano;
    }
}
