package br.com.touros.punterbot.api.model.cadastro;

public class TimeEstatistica {

    private CategoriaEstatistica escanteios = new CategoriaEstatistica();
    private CategoriaEstatistica gols = new CategoriaEstatistica();

    public CategoriaEstatistica getEscanteios() {
        return escanteios;
    }

    public CategoriaEstatistica getGols() {
        return gols;
    }
}
