package br.com.touros.punterbot.api.core.security.providers;

import br.com.touros.punterbot.api.core.security.PasswordSecret;
import br.com.touros.punterbot.api.model.cadastro.Usuario;
import br.com.touros.punterbot.api.service.interfaces.IUsuarioService;
import br.com.touros.punterbot.api.core.security.authenticated.UsuarioAutenticado;
import br.com.touros.punterbot.api.core.security.authentication.MongoAutenticacao;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MongoAuthenticationProvider implements AuthenticationProvider {

    private final IUsuarioService usuarioService;

    public MongoAuthenticationProvider(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MongoAutenticacao mongoAutenticacao = (MongoAutenticacao) authentication;

        Usuario usuario = usuarioService.buscarPorEmail(mongoAutenticacao.getPrincipal());

        if (usuario != null) {

            boolean autenticado;

            // caso senha do usuario no banco estiver nula, e possuir senha reset
            if (usuario.getSolicitaNovaSenha()) {
                autenticado = usuario.getSenhaReset().equals(mongoAutenticacao.getCredentials());
            } else {
                autenticado = PasswordSecret.Matches(mongoAutenticacao.getCredentials(), usuario.getSenha());
            }

            mongoAutenticacao.setAuthenticated(autenticado);

            if (autenticado) {
                UsuarioAutenticado usuarioAutenticado = new UsuarioAutenticado(usuario);
                mongoAutenticacao.setUsuarioAutenticado(usuarioAutenticado);
            }
        }
        return mongoAutenticacao;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(MongoAutenticacao.class);
    }
}
