package br.com.touros.punterbot.api.integracao.hotmart.response;

public class UsuarioResponse {

    private Long id;
    private String name;
    private String email;
    private String login;
    private String ucode;
    private String dddPhone;
    private String phone;
    private EnderecoResponse address;
    private String entityType;
    private String locale;
    private String currencyCodeComission;
    private String timeZone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    public String getDddPhone() {
        return dddPhone;
    }

    public void setDddPhone(String dddPhone) {
        this.dddPhone = dddPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EnderecoResponse getAddress() {
        return address;
    }

    public void setAddress(EnderecoResponse address) {
        this.address = address;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCurrencyCodeComission() {
        return currencyCodeComission;
    }

    public void setCurrencyCodeComission(String currencyCodeComission) {
        this.currencyCodeComission = currencyCodeComission;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
