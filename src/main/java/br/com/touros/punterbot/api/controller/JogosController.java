package br.com.touros.punterbot.api.controller;

import br.com.touros.punterbot.api.controller.request.PesquisaEstrategiaRequest;
import br.com.touros.punterbot.api.controller.request.TipoPesquisa;
import br.com.touros.punterbot.api.controller.response.ContagemJogosResponse;
import br.com.touros.punterbot.api.controller.response.FiltroEstatisticaResponse;
import br.com.touros.punterbot.api.controller.response.JogoPorLigaResponse;
import br.com.touros.punterbot.api.model.cadastro.Jogo;
import br.com.touros.punterbot.api.scrapper.estatisticas.Estatisticas;
import br.com.touros.punterbot.api.service.interfaces.IJogoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("jogo")
public class JogosController extends BaseController {

    private final IJogoService jogoService;

    public JogosController(IJogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping("contagem")
    public ResponseEntity<ContagemJogosResponse> contarJogos() {
        ContagemJogosResponse contagemJogosResponse = new ContagemJogosResponse();
        return Ok(contagemJogosResponse);
    }

    @GetMapping("pesquisar")
    public ResponseEntity<List<Jogo>> pesquisar(@PathParam("pagina") Integer pagina, @PathParam("pagina") Integer quantidade) {
        List<Jogo> jogosJogoResponses = jogoService.buscaPaginada(pagina, quantidade);
        return Ok(jogosJogoResponses);
    }


    @PostMapping("agrupado/pesquisar")
    public ResponseEntity<List<JogoPorLigaResponse>> pesquisarAgrupada(@PathParam("tipo") TipoPesquisa tipo,
                                                                       @PathParam("pagina") Integer pagina,
                                                                       @PathParam("pagina") Integer quantidade,
                                                                       @RequestBody PesquisaEstrategiaRequest request) {
        return Ok(jogoService.buscaAgrupada(tipo, request, pagina, quantidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscarPorId(@PathVariable("id") Long id) {
        return Ok(jogoService.buscarJogoPorId(id));
    }

    @GetMapping("/filtros")
    public ResponseEntity<FiltroEstatisticaResponse> filtros() {
        var response = new FiltroEstatisticaResponse();
        response.setGol(Estatisticas.Gol.Selects());
        response.setEscanteio(Estatisticas.Escanteio.Selects());
        return Ok(response);
    }

}
