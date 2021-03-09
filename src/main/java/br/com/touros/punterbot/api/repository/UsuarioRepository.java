package br.com.touros.punterbot.api.repository;

import br.com.touros.punterbot.api.core.persistence.IGenericRepository;
import br.com.touros.punterbot.api.model.cadastro.Usuario;
import org.bson.types.ObjectId;

import java.util.List;

public interface UsuarioRepository extends IGenericRepository<Usuario, ObjectId> {

    Usuario findByEmail(String email);

    Boolean existsByEmail(String email);

    List<Usuario> findAll();
}

