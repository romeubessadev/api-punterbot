package br.com.touros.punterbot.api.core.permission.planos;

import br.com.touros.punterbot.api.core.permission.PermissionConstants;
import br.com.touros.punterbot.api.core.permission.interfaces.PlanoPermissao;

import java.util.ArrayList;
import java.util.List;

public class PlanoGratis implements PlanoPermissao {

    private static PlanoGratis instance;

    private final List<String> permissoes = new ArrayList<>();

    private PlanoGratis() {
        permissoes.add(PermissionConstants.JOGOS_HOJE);
        permissoes.add(PermissionConstants.JOGOS_AMANHA);
        permissoes.add(PermissionConstants.JOGOS_AO_VIVO);
        permissoes.add(PermissionConstants.ROBO);
    }

    public static PlanoGratis getInstance() {
        if (instance == null) {
            instance = new PlanoGratis();
        }
        return instance;
    }

    @Override
    public List<String> permissoes() {
        return this.permissoes;
    }
}
