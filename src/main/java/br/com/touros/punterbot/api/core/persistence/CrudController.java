package br.com.touros.punterbot.api.core.persistence;

import br.com.touros.punterbot.api.controller.BaseController;
import br.com.touros.punterbot.api.controller.response.PesquisarResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public abstract class CrudController<T extends IMongoEntity<K>, K, S extends IGenericService<T, K>> extends BaseController {

    private final S service;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public CrudController(S service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<T> buscarPorId(@PathVariable("id") K id) {
        return Ok(getService().buscarPorId(id));
    }

    @DeleteMapping(value = "/{id}/")
    public ResponseEntity<HttpStatus> deletar(@PathVariable("id") K id) {
        getService().deletePorId(id);
        return Ok(HttpStatus.OK);
    }

    @PostMapping(value = "/pesquisar")
    public ResponseEntity<PesquisarResponse<T>> pesquisar(
            @RequestBody(required = false) T filtro,
            @RequestParam("pagina") Integer pagina,
            @RequestParam("quantidade") Integer qtd) {
        return Ok(new PesquisarResponse<>(getService().pesquisar(filtro, pagina, qtd)));
    }

    @GetMapping(value = "/quantidade")
    public ResponseEntity<Long> quantidade() {
        return Ok(getService().quantidadeDeRegistros());
    }


    public S getService() {
        return service;
    }
}
