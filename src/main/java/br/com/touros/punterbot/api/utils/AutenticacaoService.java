package br.com.touros.punterbot.api.utils;

import br.com.touros.punterbot.api.exceptions.UnauthorizedException;
import br.com.touros.punterbot.api.model.cadastro.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AutenticacaoService {
    public static Usuario GetUsuarioLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!Utils.isNull(authentication.getPrincipal())) {
            return (Usuario) authentication.getPrincipal();
        }

        throw new UnauthorizedException("Acesso não autorizado", "Sessão usuário inválida");
    }
}
