package br.com.touros.punterbot.api.controller.response;

import org.bson.Document;

import java.util.List;
import java.util.stream.Collectors;

public class JogoPorLigaResponse {

    private Long _id;
    private String nome;
    private String logo;
    private List<JogoPesquisaResponse> jogos;

    public JogoPorLigaResponse(Document document) {
        this._id = document.getLong("_id");
        this.nome = document.getString("nome");
        this.logo = document.getString("logo");
        this.jogos = jogos((List<Document>) document.get("jogos"));
    }

    private List<JogoPesquisaResponse> jogos(List<Document> jogosDocument) {
        return jogosDocument.stream().map(JogoPesquisaResponse::new).collect(Collectors.toList());
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<JogoPesquisaResponse> getJogos() {
        return jogos;
    }

    public void setJogos(List<JogoPesquisaResponse> jogos) {
        this.jogos = jogos;
    }

    @Override
    public String toString() {
        return "JogoPorLigaResponse{" +
                "_id=" + _id +
                ", nome='" + nome + '\'' +
                ", logo='" + logo + '\'' +
                ", jogos=" + jogos +
                '}';
    }
}
