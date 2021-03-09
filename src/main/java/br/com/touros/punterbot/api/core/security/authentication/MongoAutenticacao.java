package br.com.touros.punterbot.api.core.security.authentication;

import br.com.touros.punterbot.api.core.security.authenticated.UsuarioAutenticado;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class MongoAutenticacao implements Authentication {

    private final String login;
    private final String senha;

    private UsuarioAutenticado usuarioAutenticado = null;
    private Boolean autenticado = Boolean.FALSE;

    public MongoAutenticacao(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return usuarioAutenticado.getAuthorities();
    }

    @Override
    public String getCredentials() {
        return this.senha;
    }

    @Override
    public String getPrincipal() {
        return this.login;
    }

    @Override
    public boolean isAuthenticated() {
        return this.usuarioAutenticado != null && autenticado;
    }

    @Override
    public UsuarioAutenticado getDetails() {
        return usuarioAutenticado;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.autenticado = isAuthenticated;
    }
    public void setUsuarioAutenticado(UsuarioAutenticado usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }
    @Override
    public String getName() {
        return this.login;
    }
}
