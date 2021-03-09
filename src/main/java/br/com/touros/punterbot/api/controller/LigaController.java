package br.com.touros.punterbot.api.controller;

import br.com.touros.punterbot.api.controller.request.AtualizarNomeRequest;
import br.com.touros.punterbot.api.core.persistence.CrudController;
import br.com.touros.punterbot.api.model.cadastro.Liga;
import br.com.touros.punterbot.api.service.interfaces.ILigaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RolesAllowed("ADMINISTRADOR")
@RequestMapping("liga")
public class LigaController extends CrudController<Liga, Long, ILigaService> {
    public LigaController(ILigaService service) {
        super(service);
    }

    @PostMapping("/atualizar")
    public ResponseEntity<HttpStatus> atualizar(@RequestBody AtualizarNomeRequest atualizarNomeRequest) {
        valida(atualizarNomeRequest);
        getService().atualizar(atualizarNomeRequest);
        return Ok(HttpStatus.OK);
    }
}
