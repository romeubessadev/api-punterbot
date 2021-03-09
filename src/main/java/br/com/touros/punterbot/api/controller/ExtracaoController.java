package br.com.touros.punterbot.api.controller;

import br.com.touros.punterbot.api.controller.request.ExtracaoRequestEnum;
import br.com.touros.punterbot.api.scrapper.IExtracaoComponent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RolesAllowed("ADMINISTRADOR")
@RequestMapping("extracao")
public class ExtracaoController extends BaseController {

    private final IExtracaoComponent extracaoComponent;

    public ExtracaoController(IExtracaoComponent extracaoComponent) {
        this.extracaoComponent = extracaoComponent;
    }

    @GetMapping("executar/{extracaoRequest}")
    public ResponseEntity<String> executar(@PathVariable("extracaoRequest") ExtracaoRequestEnum requestEnum) {
        extracaoComponent.efetuarExtracao(requestEnum);
        return Ok("Extração está sendo executada");
    }

    @GetMapping("/ligas")
    public ResponseEntity<String> extrairLigas() {
        extracaoComponent.extrairLigas();
        return Ok("Extração está sendo executada");
    }

    @GetMapping("/times")
    public ResponseEntity<String> extrairTimes() {
        extracaoComponent.extrairTimes();
        return Ok("Extração está sendo executada");
    }
}
