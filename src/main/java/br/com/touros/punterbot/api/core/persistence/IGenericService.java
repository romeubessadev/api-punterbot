package br.com.touros.punterbot.api.core.persistence;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IGenericService<T extends IMongoEntity<K>, K> {

    T buscarPorId(K id);

    List<T> buscarTodos();

    void validar(T entity);

    void salvar(final T entity);

    void salvar(List<T> entity);

    Boolean existePorId(K id);

    void deletePorId(K id);

    void delete(final T entity);

    Page<T> pesquisar(T pesquisar,Integer pagina, Integer quantidade);

    Long quantidadeDeRegistros();
}
