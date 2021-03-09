package br.com.touros.punterbot.api.core.security;

import br.com.touros.punterbot.api.core.configuracao.AdminSegurancaConfiguracao;
import br.com.touros.punterbot.api.core.configuracao.PunterbotApiConfiguracao;
import br.com.touros.punterbot.api.model.cadastro.Usuario;
import br.com.touros.punterbot.api.service.interfaces.IUsuarioService;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupAdminAccountMaker {

    private final IUsuarioService usuarioService;
    private final PunterbotApiConfiguracao punterbotApiConfiguracao;

    public StartupAdminAccountMaker(IUsuarioService iUsuarioService, PunterbotApiConfiguracao punterbotApiConfiguracao) {
        this.usuarioService = iUsuarioService;
        this.punterbotApiConfiguracao = punterbotApiConfiguracao;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        criarAdmin();
    }

    private void criarAdmin() {
        AdminSegurancaConfiguracao admin = punterbotApiConfiguracao.getSeguranca().getAdmin();
        Usuario userAdmin = null;

        try {
            userAdmin = usuarioService.buscarPorEmail(admin.getUsuario());
        } catch (Exception ignored) {
        }

        if (userAdmin == null) {
            usuarioService.salvar(criarAdministrador(admin));
        }
    }

    private Usuario criarAdministrador(AdminSegurancaConfiguracao admin) {
        Usuario usuario = new Usuario();
        usuario.setNome("Administrador");
        usuario.setEmail(admin.getUsuario());
        usuario.setAdministrador(true);
        usuario.setSenha(PasswordSecret.Enconde(admin.getSenha()));
        usuario.setBloqueado(Boolean.FALSE);
        return usuario;
    }
}
