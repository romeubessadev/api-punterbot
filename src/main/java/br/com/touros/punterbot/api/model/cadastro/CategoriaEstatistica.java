package br.com.touros.punterbot.api.model.cadastro;

import br.com.touros.punterbot.api.model.cadastro.estatisticas.BaseEstatistica;

import java.util.LinkedHashMap;

public class CategoriaEstatistica {

    private LinkedHashMap<String, BaseEstatistica> geral = new LinkedHashMap<>();
    private LinkedHashMap<String, BaseEstatistica> liga = new LinkedHashMap<>();

    public LinkedHashMap<String, BaseEstatistica> getGeral() {
        return geral;
    }

    public LinkedHashMap<String, BaseEstatistica> getLiga() {
        return liga;
    }

    public void adicionarGeral(Object object) {
        if (object instanceof String)
            adicionarGeral((String) object);
        else {
            adicionarGeral((BaseEstatistica) object);
        }
    }

    public void adicionaLiga(Object object) {
        if (object instanceof String)
            adicionaLiga((String) object);
        else {
            adicionaLiga((BaseEstatistica) object);
        }
    }

    private void adicionarGeral(BaseEstatistica estatistca) {
        this.geral.put(estatistca.getChave(), estatistca);
    }

    private void adicionaLiga(BaseEstatistica estatistca) {
        this.liga.put(estatistca.getChave(), estatistca);
    }

    private void adicionarGeral(String chave) {
        this.geral.put(chave, null);
    }

    private void adicionaLiga(String chave) {
        this.liga.put(chave, null);
    }

}
