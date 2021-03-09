package br.com.touros.punterbot.api.core.configuracao;

public class SegurancaConfiguracao {

    private AdminSegurancaConfiguracao admin;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AdminSegurancaConfiguracao getAdmin() {
        return admin;
    }

    public void setAdmin(AdminSegurancaConfiguracao admin) {
        this.admin = admin;
    }
}
