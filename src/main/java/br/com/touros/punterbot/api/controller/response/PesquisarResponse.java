package br.com.touros.punterbot.api.controller.response;

import org.springframework.data.domain.Page;

import java.util.List;

public class PesquisarResponse<T> {

    private List<T> lista;

    private Integer pagina;
    private Integer tamanhoDaPagina;

    private Integer totalDePaginas;
    private Long totalDeRegistros;

    public PesquisarResponse(Page<T> page) {
        this.lista = page.getContent();
        this.pagina = page.getNumber();
        this.tamanhoDaPagina = page.getSize();
        this.totalDePaginas = page.getTotalPages();
        this.totalDeRegistros = page.getTotalElements();
    }

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public Integer getTamanhoDaPagina() {
        return tamanhoDaPagina;
    }

    public void setTamanhoDaPagina(Integer tamanhoDaPagina) {
        this.tamanhoDaPagina = tamanhoDaPagina;
    }

    public Integer getTotalDePaginas() {
        return totalDePaginas;
    }

    public void setTotalDePaginas(Integer totalDePaginas) {
        this.totalDePaginas = totalDePaginas;
    }

    public Long getTotalDeRegistros() {
        return totalDeRegistros;
    }

    public void setTotalDeRegistros(Long totalDeRegistros) {
        this.totalDeRegistros = totalDeRegistros;
    }
}
