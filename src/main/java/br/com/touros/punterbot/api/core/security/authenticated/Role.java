package br.com.touros.punterbot.api.core.security.authenticated;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

    private final String role;

    public Role(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }
}
