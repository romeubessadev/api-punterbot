package br.com.touros.punterbot.api.model.cadastro.enums;

import br.com.touros.punterbot.api.core.permission.interfaces.PlanoPermissaoFactory;
import br.com.touros.punterbot.api.core.permission.planos.PlanoGratis;
import br.com.touros.punterbot.api.core.permission.planos.PlanoMensal;
import br.com.touros.punterbot.api.utils.ISelectItem;

import java.util.List;

public enum UsuarioPlanoEnum implements ISelectItem {
    PLANO_GRATIS("Plano Grátis", PlanoGratis::getInstance),
    MENSAL("Plano Mensal", PlanoMensal::getInstance);

    private final String label;
    private final PlanoPermissaoFactory planoPermissaoFactory;

    UsuarioPlanoEnum(String label, PlanoPermissaoFactory planoPermissaoFactory) {
        this.label = label;
        this.planoPermissaoFactory = planoPermissaoFactory;
    }

    public String getLabel() {
        return label;
    }

    public List<String> getPermissoes() {
        return planoPermissaoFactory.create().permissoes();
    }

    @Override
    public String getItemLabel() {
        return label;
    }

    @Override
    public Object getItemValue() {
        return name();
    }
}
