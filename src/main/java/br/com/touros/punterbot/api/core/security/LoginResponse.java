package br.com.touros.punterbot.api.core.security;

public class LoginResponse {

    private String token;
    private Boolean solicitaSenha;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getSolicitaSenha() {
        return solicitaSenha;
    }

    public void setSolicitaSenha(Boolean solicitaSenha) {
        this.solicitaSenha = solicitaSenha;
    }
}