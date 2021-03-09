package br.com.touros.punterbot.api.controller.response;

public class BaseResponse {

    private String mensagem;

    public BaseResponse() {
    }

    public BaseResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
