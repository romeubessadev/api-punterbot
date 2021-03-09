package br.com.touros.punterbot.api.service;

import br.com.touros.punterbot.api.controller.request.*;
import br.com.touros.punterbot.api.core.persistence.GenericService;
import br.com.touros.punterbot.api.exceptions.ValidException;
import br.com.touros.punterbot.api.model.cadastro.Usuario;
import br.com.touros.punterbot.api.repository.UsuarioRepository;
import br.com.touros.punterbot.api.service.interfaces.IUsuarioService;
import br.com.touros.punterbot.api.utils.AutenticacaoService;
import br.com.touros.punterbot.api.utils.Utils;
import org.bson.types.ObjectId;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UsuarioService extends GenericService<Usuario, ObjectId, UsuarioRepository> implements IUsuarioService {

    public UsuarioService(UsuarioRepository usuarioRepository) {
        super(usuarioRepository, Usuario.class);
    }

    @Override
    public void ativacao(AtivacaoUsuarioRequest request) {
        Usuario usuario = getRepository().findByEmail(request.getEmail());

        if (Utils.isNull(usuario))
            ValidException.Throw("Primeiro Acesso Usuário", "Não existe usuário com esse email");

        usuario.setDataPrimeiroAcesso(request.getPrimeiroAcesso());

        atualizar(usuario, request);
    }

    private void atualizar(Usuario usuario, AtualizarUsuarioRequest request) {
        usuario.setNome(request.getNome());
        usuario.setPrimeiroNome(request.getPrimeiroNome());
        usuario.setSegundoNome(request.getSegundoNome());
        usuario.setContato(request.getContato());
        if (!Utils.isNull(request.getLogo()))
            usuario.setLogo(request.getLogo());
        salvar(usuario);
    }

    @Override
    public void bloquear(String email) {
        Usuario usuario = getRepository().findByEmail(email);

        if (Utils.isNull(usuario))
            ValidException.Throw("Bloquear Usuário", "Não existe usuário com esse email");

        usuario.setBloqueado(Boolean.TRUE);
        usuario.setPlano(null);
        salvar(usuario);
    }

    @Override
    public List<Usuario> pesquisar() {
        return getRepository().findAll();
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return getRepository().findByEmail(email);
    }

    @Override
    public void atualizar(AtualizarUsuarioRequest request) {
        Usuario usuario = getRepository().findByEmail(request.getEmail());

        if (Utils.isNull(usuario))
            ValidException.Throw("Atualizar Usuário", "Não existe usuário com esse email");

        atualizar(usuario, request);
    }

    @Override
    public void atualizarSenha(AlteracaoSenhaUsuarioRequest request) {
        if (request.getSenha().length() < 7) {
            ValidException.Throw("Alteração Senha", "Mínimo 7 caracteres com uma letra e número");
        }
        // verifica se contem letras de AaZz
        if (!request.getSenha().matches("([A-Z-a-z])\\w+")) {
            ValidException.Throw("Alteração Senha", "Mínimo 7 caracteres com uma letra e número");
        }

        // verifica se contem numeros
        if (!request.getSenha().matches(".*\\d.*")) {
            ValidException.Throw("Alteração Senha", "Mínimo 7 caracteres com uma letra e número");
        }

        if (!request.getSenha().equals(request.getConfirmaSenha())) {
            ValidException.Throw("Alteração Senha", "Senhas não conferem");
        }

        Usuario usuarioLogado = AutenticacaoService.GetUsuarioLogado();
        usuarioLogado.setSenha(new BCryptPasswordEncoder().encode(request.getSenha()));
        usuarioLogado.setSenhaReset(null);
        salvar(usuarioLogado);
    }

    @Override
    public void atualizarPlano(UsuarioPlanoRequest request) {
        Usuario usuario = getRepository().findByEmail(request.getEmail());

        if (Utils.isNull(usuario))
            ValidException.Throw("Bloquear Usuário", "Não existe usuário com esse email");

        usuario.setPlano(request.getPlano());
        usuario.setBloqueado(Utils.isNull(request.getPlano()));
        salvar(usuario);
    }

    @Override
    public synchronized Usuario criarUsuario(CriarUsuarioRequest criarUsuarioRequest) {
        Boolean jaExisteEmail = getRepository().existsByEmail(criarUsuarioRequest.getEmail());

        if (jaExisteEmail)
            ValidException.Throw("Criar Usuário", "Email já cadastrado!");

        // converte a reuqest no model
        Usuario usuario = criarUsuarioRequest.toModel();

        // gera primeira senha de acesso
        gerarPrimeiraSenha(usuario);

        salvar(usuario);
        return usuario;
    }

    private void gerarPrimeiraSenha(Usuario usuario) {
        RandomString gen = new RandomString(6, ThreadLocalRandom.current());
        usuario.setSenhaReset(gen.nextString());
    }

    public static class RandomString {

        /**
         * Generate a random string.
         */
        public String nextString() {
            for (int idx = 0; idx < buf.length; ++idx)
                buf[idx] = symbols[random.nextInt(symbols.length)];
            return new String(buf);
        }

        public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        public static final String lower = upper.toLowerCase(Locale.ROOT);

        public static final String digits = "0123456789";

        public static final String alphanum = upper + lower + digits;

        private final Random random;

        private final char[] symbols;

        private final char[] buf;

        public RandomString(int length, Random random, String symbols) {
            if (length < 1) throw new IllegalArgumentException();
            if (symbols.length() < 2) throw new IllegalArgumentException();
            this.random = Objects.requireNonNull(random);
            this.symbols = symbols.toCharArray();
            this.buf = new char[length];
        }

        /**
         * Create an alphanumeric string generator.
         */
        public RandomString(int length, Random random) {
            this(length, random, alphanum);
        }

        /**
         * Create an alphanumeric strings from a secure generator.
         */
        public RandomString(int length) {
            this(length, new SecureRandom());
        }

        /**
         * Create session identifiers.
         */
        public RandomString() {
            this(21);
        }

    }
}
