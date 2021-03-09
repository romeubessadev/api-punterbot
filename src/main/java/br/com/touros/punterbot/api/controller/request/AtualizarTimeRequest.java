package br.com.touros.punterbot.api.controller.request;

import br.com.touros.punterbot.api.exceptions.ValidException;
import br.com.touros.punterbot.api.utils.Utils;

public class AtualizarTimeRequest extends  AtualizarNomeRequest{
    private String twitter;
    private Integer anoFundado;

    @Override
    public void isValid() throws ValidException {
        super.isValid();
        if (Utils.isNull(this.anoFundado)) {
            ValidException.Throw("Atualizar Time", "Campo anoFundado é obrigatório!");
        }
        if (Utils.isNullOrEmpty(this.twitter)) {
            ValidException.Throw("Atualizar twitter", "Campo twitter é obrigatório!");
        }
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Integer getAnoFundado() {
        return anoFundado;
    }

    public void setAnoFundado(Integer anoFundado) {
        this.anoFundado = anoFundado;
    }
}
