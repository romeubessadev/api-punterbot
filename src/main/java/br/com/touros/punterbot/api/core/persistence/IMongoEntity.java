package br.com.touros.punterbot.api.core.persistence;

public interface IMongoEntity<K> {
    K getId();

    void setId(K id);
}
