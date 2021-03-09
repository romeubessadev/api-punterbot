package br.com.touros.punterbot.api.model.cadastro;

import br.com.touros.punterbot.api.core.persistence.IMongoEntity;
import br.com.touros.punterbot.api.model.cadastro.enums.UsuarioPlanoEnum;
import br.com.touros.punterbot.api.utils.Utils;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("usuario")
public class Usuario implements IMongoEntity<ObjectId> {

    private ObjectId id;
    private String nome;
    private String primeiroNome;
    private String segundoNome;
    private String email;
    private String senha;
    private String senhaReset;
    private String contato;
    private byte[] logo;
    private String codigoIndicacao;
    private Boolean bloqueado = Boolean.FALSE;
    private Boolean administrador = Boolean.FALSE;
    private Date dataPrimeiroAcesso;
    private UsuarioPlanoEnum plano;

    @Transient
    private List<String> roles;

    public Usuario() {
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    @Override
    public ObjectId getId() {
        return id;
    }

    public String getStringId() {
        return id.toString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getSenhaReset() {
        return senhaReset;
    }

    public void setSenhaReset(String senhaReset) {
        this.senhaReset = senhaReset;
    }

    public Boolean getSolicitaNovaSenha() {
        return !Utils.isNullOrEmpty(senhaReset) && Utils.isNullOrEmpty(senha);
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

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public Date getDataPrimeiroAcesso() {
        return dataPrimeiroAcesso;
    }

    public void setDataPrimeiroAcesso(Date dataPrimeiroAcesso) {
        this.dataPrimeiroAcesso = dataPrimeiroAcesso;
    }

    public UsuarioPlanoEnum getPlano() {
        return plano;
    }

    public void setPlano(UsuarioPlanoEnum plano) {
        this.plano = plano;
    }

    public String getPlanoLabel() {
        return this.plano != null ? this.plano.getLabel() : null;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
