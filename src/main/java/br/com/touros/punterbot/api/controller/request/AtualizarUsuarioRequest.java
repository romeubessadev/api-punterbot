package br.com.touros.punterbot.api.controller.request;

import br.com.touros.punterbot.api.exceptions.ValidException;
import br.com.touros.punterbot.api.utils.Utils;

public class AtualizarUsuarioRequest implements RequestValid {

    private String nome;
    private String primeiroNome;
    private String segundoNome;
    private String contato;
    private byte[] logo;
    private String email;

    @Override
    public void isValid() throws ValidException {
        if (Utils.isNullOrEmpty(nome)) {
            ValidException.Throw("Primeiro Login", "Campo nome é obrigatório!");
        }
        if (Utils.isNullOrEmpty(primeiroNome)) {
            ValidException.Throw("Primeiro Login", "Campo primeiro nome é obrigatório!");
        }
        if (Utils.isNullOrEmpty(email)) {
            ValidException.Throw("Primeiro Login", "Campo email é obrigatório!");
        }
        if (Utils.isNullOrEmpty(segundoNome)) {
            ValidException.Throw("Primeiro Login", "Campo segundo nome é obrigatório!");
        }
        if (Utils.isNullOrEmpty(contato)) {
            ValidException.Throw("Primeiro Login", "Campo telegram é obrigatório!");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSegundoNome() {
        return segundoNome;
    }

    public void setSegundoNome(String segundoNome) {
        this.segundoNome = segundoNome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
}
