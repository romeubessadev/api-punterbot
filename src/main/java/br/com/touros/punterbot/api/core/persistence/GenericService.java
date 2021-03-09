package br.com.touros.punterbot.api.core.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericService<T extends IMongoEntity<K>, K, R extends IGenericRepository<T, K>> implements IGenericService<T,K> {
    private final Logger log = LoggerFactory.getLogger(super.getClass());
    private final Class<T> tClass;
    private final R repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public GenericService(R repository, Class<T> tClass) {
        this.tClass = tClass;
        this.repository = repository;
        log.info("{} Up", super.getClass().getSimpleName());
    }

    @Override
    public T buscarPorId(K id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<T> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Page<T> pesquisar(T pesquisa, Integer pagina, Integer quantidade) {
        return repository.findAll(filtrar(pesquisa), PageRequest.of(pagina, quantidade, Sort.by("id")));
    }

    public Example<T> filtrar(T pesquisa) {
        return Example.of(pesquisa, ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase());
    }

    @Override
    public Long quantidadeDeRegistros() {
        return repository.count();
    }

    @Override
    public void salvar(T entity) {
        validar(entity);
        repository.save(entity);
    }

    @Override
    public void salvar(List<T> entity) {
        entity.forEach(this::validar);
        repository.saveAll(entity);
    }

    @Override
    public Boolean existePorId(K id) {
        return repository.existsById(id);
    }

    @Override
    public void deletePorId(K id) {
        repository.delete(buscarPorId(id));
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void validar(T entity) {
    }

    public R getRepository() {
        return repository;
    }

    public Logger log() {
        return log;
    }
}