package br.com.touros.punterbot.api.core.configuracao;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "punterbot")
public class PunterbotApiConfiguracao {

    private SegurancaConfiguracao seguranca;

    private HotmartConfiguracao hotmart;

    private SportmonksConfiguracao sportmonks;

    public SportmonksConfiguracao getSportmonks() {
        return sportmonks;
    }

    public void setSportmonks(SportmonksConfiguracao sportmonks) {
        this.sportmonks = sportmonks;
    }

    public SegurancaConfiguracao getSeguranca() {
        return seguranca;
    }

    public void setSeguranca(SegurancaConfiguracao seguranca) {
        this.seguranca = seguranca;
    }

    public HotmartConfiguracao getHotmart() {
        return hotmart;
    }

    public void setHotmart(HotmartConfiguracao hotmart) {
        this.hotmart = hotmart;
    }
}
