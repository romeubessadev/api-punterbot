package br.com.touros.punterbot.api.controller;

import br.com.touros.punterbot.api.controller.request.AtualizarTimeRequest;
import br.com.touros.punterbot.api.core.persistence.CrudController;
import br.com.touros.punterbot.api.model.cadastro.Time;
import br.com.touros.punterbot.api.service.interfaces.ITimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RolesAllowed("ADMINISTRADOR")
@RequestMapping("time")
public class TimeController extends CrudController<Time, Long, ITimeService> {
    public TimeController(ITimeService service) {
        super(service);
    }

    @PostMapping("/atualizar")
    public ResponseEntity<HttpStatus> atualizar(@RequestBody AtualizarTimeRequest atualizarTimeRequest) {
        valida(atualizarTimeRequest);
        getService().atualizar(atualizarTimeRequest);
        return Ok(HttpStatus.OK);
    }
}
