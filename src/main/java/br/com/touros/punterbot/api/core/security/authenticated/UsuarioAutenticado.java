package br.com.touros.punterbot.api.core.security.authenticated;

import br.com.touros.punterbot.api.model.cadastro.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


public class UsuarioAutenticado implements UserDetails {

    private final Usuario usuarioLogado;

    public UsuarioAutenticado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.usuarioLogado.getSenha();
    }

    @Override
    public String getUsername() {
        return this.usuarioLogado.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.usuarioLogado.getBloqueado();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.usuarioLogado.getBloqueado();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.usuarioLogado.getBloqueado();
    }

    @Override
    public boolean isEnabled() {
        return this.usuarioLogado.getBloqueado();
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}
