package br.com.touros.punterbot.api.service.interfaces;

import br.com.touros.punterbot.api.controller.request.*;
import br.com.touros.punterbot.api.core.persistence.IGenericService;
import br.com.touros.punterbot.api.model.cadastro.Usuario;
import org.bson.types.ObjectId;

import java.util.List;

public interface IUsuarioService extends IGenericService<Usuario, ObjectId> {

    Usuario buscarPorEmail(String login);

    Usuario criarUsuario(CriarUsuarioRequest criarUsuarioRequest);

    void atualizarPlano(UsuarioPlanoRequest request);

    List<Usuario> pesquisar();

    void bloquear(String email);

    void ativacao(AtivacaoUsuarioRequest primeiroAcessoUsuarioRequest);

    void atualizarSenha(AlteracaoSenhaUsuarioRequest request);

    void atualizar(AtualizarUsuarioRequest atualizarUsuarioRequest);
}
