package br.com.touros.punterbot.api.controller.response;

import br.com.touros.punterbot.api.model.cadastro.Usuario;

public class ConsultaUsuarioResponse {

    private String email;

    public ConsultaUsuarioResponse(Usuario usuario) {
        this.email =usuario.getEmail();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
