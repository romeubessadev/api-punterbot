package br.com.touros.punterbot.api.service.interfaces;

import br.com.touros.punterbot.api.controller.request.PesquisaEstrategiaRequest;
import br.com.touros.punterbot.api.controller.request.TipoPesquisa;
import br.com.touros.punterbot.api.controller.response.JogoPorLigaResponse;
import br.com.touros.punterbot.api.model.cadastro.Jogo;

import java.util.List;

public interface IJogoService {
    void salvar(Jogo jogo);

    Jogo buscarJogoPorId(Long jogoId);

    List<Jogo> buscaPaginada(Integer page, Integer size);

    List<JogoPorLigaResponse> buscaAgrupada(TipoPesquisa tipoPesquisa, PesquisaEstrategiaRequest request, Integer page, Integer size);
}
