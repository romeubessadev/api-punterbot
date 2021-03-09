package br.com.touros.punterbot.api.repository;

import br.com.touros.punterbot.api.model.cadastro.Jogo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JogoRepository extends MongoRepository<Jogo, Long> {
}
