package br.com.touros.punterbot.api.model.cadastro.estatisticas;

import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.IEstatistica;

public class BaseEstatistica {
    private String chave;
    private String nome;

    public BaseEstatistica() {
    }

    public void set(IEstatistica estrategia) {
        this.chave = estrategia.chave();
        this.nome = estrategia.nome();
    }

    public String getChave() {
        return chave;
    }

    public String getNome() {
        return nome;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
