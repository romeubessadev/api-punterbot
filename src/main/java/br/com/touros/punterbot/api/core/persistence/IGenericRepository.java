package br.com.touros.punterbot.api.core.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepository<T extends IMongoEntity<K>, K> extends MongoRepository<T, K> {
//    T buscar(K id);
//
//    List<T> buscarTodos();
//
//    void persistir(final T entity);
//
//    void persistir(List<T> entity);
//
//    Long contar();

}
