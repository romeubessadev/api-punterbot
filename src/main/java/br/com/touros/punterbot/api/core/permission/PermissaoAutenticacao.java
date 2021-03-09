package br.com.touros.punterbot.api.core.permission;

import br.com.touros.punterbot.api.core.security.authenticated.Role;
import br.com.touros.punterbot.api.model.cadastro.Usuario;
import br.com.touros.punterbot.api.model.cadastro.enums.UsuarioPlanoEnum;
import br.com.touros.punterbot.api.utils.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PermissaoAutenticacao {

    public static List<Role> Roles(Usuario usuario) {
        HashSet<String> permissoes = new HashSet<>();

        if (usuario.getAdministrador()) {
            permissoes.add(PermissionConstants.ADMINISTRADOR);

            for (UsuarioPlanoEnum value : UsuarioPlanoEnum.values()) {
                permissoes.addAll(value.getPermissoes());
            }

        } else if (!Utils.isNull(usuario.getPlano())) {
            permissoes.addAll(usuario.getPlano().getPermissoes());
        }
        return permissoes.stream().map(Role::new).collect(Collectors.toList());
    }
}
