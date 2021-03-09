package br.com.touros.punterbot.api.controller.request;

import br.com.touros.punterbot.api.exceptions.ValidException;
import br.com.touros.punterbot.api.model.cadastro.Usuario;
import br.com.touros.punterbot.api.model.cadastro.enums.UsuarioPlanoEnum;
import br.com.touros.punterbot.api.utils.Utils;

public class CriarUsuarioRequest implements RequestValid {
    private String nome;
    private String primeiroNome;
    private String segundoNome;

    private String email;
    private String contato;
    private String codigoIndicacao;
    private UsuarioPlanoEnum plano;

    public Usuario toModel() {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setPrimeiroNome(primeiroNome);
        usuario.setSegundoNome(segundoNome);
        usuario.setEmail(email);
        usuario.setContato(contato);
        usuario.setCodigoIndicacao(codigoIndicacao);
        usuario.setPlano(plano);
        return usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCodigoIndicacao() {
        return codigoIndicacao;
    }

    public void setCodigoIndicacao(String codigoIndicacao) {
        this.codigoIndicacao = codigoIndicacao;
    }

    @Override
    public void isValid() throws ValidException {
        if (Utils.isNullOrEmpty(this.email)) {
            ValidException.Throw("Criar Usuário", "Campo email é obrigatório!");
        }
        if (Utils.isNull(this.codigoIndicacao)) {
            ValidException.Throw("Criar Usuário", "Campo codigoIndicacao é obrigatório!");
        }
        if (Utils.isNull(this.plano)) {
            ValidException.Throw("Criar Usuário", "Campo plano é obrigatório!");
        }
//        if (Utils.isNullOrEmpty(this.nome)) {
//            ValidException.Throw("Criar Usuário", "Campo nome é obrigatório!");
//        }
//        if (Utils.isNullOrEmpty(this.telefone)) {
//            ValidException.Throw("Criar Usuário", "Campo telefone é obrigatório!");
//        }
//        if (Utils.isNull(this.codigoIndicacao)) {
//            ValidException.Throw("Criar Usuário", "Campo codigoIndicacao é obrigatório!");
//        }
//        if (Utils.isNull(this.dataAcessoLimite)) {
//            ValidException.Throw("Criar Usuário", "Campo dataAcessoLimite é obrigatório!");
//        }
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSegundoNome() {
        return segundoNome;
    }

    public void setSegundoNome(String segundoNome) {
        this.segundoNome = segundoNome;
    }

    public UsuarioPlanoEnum getPlano() {
        return plano;
    }

    public void setPlano(UsuarioPlanoEnum plano) {
        this.plano = plano;
    }
}
