package br.com.touros.punterbot.api.controller;


import br.com.touros.punterbot.api.core.permission.PermissaoAutenticacao;
import br.com.touros.punterbot.api.core.security.authenticated.Role;
import br.com.touros.punterbot.api.model.cadastro.Usuario;
import br.com.touros.punterbot.api.utils.AutenticacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("autenticacao")
public class AutenticacaoController {

    @GetMapping("logado")
    public ResponseEntity<Usuario> getUsuarioLogado() {
        var usu = AutenticacaoService.GetUsuarioLogado();
        usu.setRoles(PermissaoAutenticacao.Roles(usu).stream().map(Role::getAuthority).collect(Collectors.toList()));
        return new ResponseEntity<>(usu, HttpStatus.OK);
    }
}
