package br.com.touros.punterbot.api.controller;

import br.com.touros.punterbot.api.controller.response.ConsultaUsuarioResponse;
import br.com.touros.punterbot.api.controller.response.CriarUsuarioResponse;
import br.com.touros.punterbot.api.core.persistence.CrudController;
import br.com.touros.punterbot.api.exceptions.UnauthorizedException;
import br.com.touros.punterbot.api.model.cadastro.Usuario;
import br.com.touros.punterbot.api.model.cadastro.enums.UsuarioPlanoEnum;
import br.com.touros.punterbot.api.service.interfaces.IUsuarioService;
import br.com.touros.punterbot.api.utils.SelectItem;
import br.com.touros.punterbot.api.utils.Utils;
import br.com.touros.punterbot.api.controller.request.*;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("usuario")
public class UsuarioController extends CrudController<Usuario, ObjectId, IUsuarioService> {

    public UsuarioController(IUsuarioService usuarioService) {
        super(usuarioService);
    }

    @RolesAllowed("ADMINISTRADOR")
    @PostMapping("/criar")
    public ResponseEntity<CriarUsuarioResponse> criarUsuario(@RequestBody CriarUsuarioRequest criarUsuarioRequest) {
        valida(criarUsuarioRequest);
        Usuario usuario = getService().criarUsuario(criarUsuarioRequest);

        CriarUsuarioResponse response = new CriarUsuarioResponse();
        response.setMensagem("Usuário Cadastrado com sucesso");
        response.setId(usuario.getStringId());
        response.setSenha(usuario.getSenhaReset());

        return Ok(response);
    }


    @RolesAllowed("ADMINISTRADOR")
    @GetMapping("/bloquear")
    public ResponseEntity<HttpStatus> bloquearUsuario(@RequestParam("email") String email) {
        getService().bloquear(email);
        return Ok(HttpStatus.OK);
    }

    @RolesAllowed("ADMINISTRADOR")
    @GetMapping("/listar")
    public ResponseEntity<List<ConsultaUsuarioResponse>> listarUsuarios() {
        return Ok(getService().pesquisar().stream()
                .map(ConsultaUsuarioResponse::new)
                .collect(Collectors.toList()));
    }

    @RolesAllowed("ADMINISTRADOR")
    @PutMapping("/atualizarPlano")
    public ResponseEntity<HttpStatus> atualizarUsuario(@RequestBody UsuarioPlanoRequest request) {
        valida(request);
        getService().atualizarPlano(request);
        return Ok(HttpStatus.OK);
    }

    @PostMapping("/ativar")
    public ResponseEntity<HttpStatus> ativarUsuario(@RequestBody AtivacaoUsuarioRequest primeiroAcessoUsuarioRequest) {
        valida(primeiroAcessoUsuarioRequest);
        getService().ativacao(primeiroAcessoUsuarioRequest);
        return Ok(HttpStatus.OK);
    }

    @PostMapping("/atualizarDados")
    public ResponseEntity<HttpStatus> atualizar(@RequestBody AtualizarUsuarioRequest atualizarUsuarioRequest) {
        valida(atualizarUsuarioRequest);
        getService().atualizar(atualizarUsuarioRequest);
        return Ok(HttpStatus.OK);
    }

    @GetMapping("/planos")
    public ResponseEntity<List<SelectItem>> planos() {
        return Ok(Utils.Select(UsuarioPlanoEnum.values()));
    }

    @PutMapping("/alterarSenha")
    public ResponseEntity<HttpStatus> alteracaoSenha(@RequestBody AlteracaoSenhaUsuarioRequest request) {
        valida(request);
        getService().atualizarSenha(request);
        return Ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deletar(ObjectId id) {
        throw new UnauthorizedException("Usuario", "deletar");
    }
}





