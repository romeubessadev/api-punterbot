package br.com.touros.punterbot.api.service.interfaces;

import br.com.touros.punterbot.api.controller.request.AtualizarNomeRequest;
import br.com.touros.punterbot.api.core.persistence.IGenericService;
import br.com.touros.punterbot.api.model.cadastro.Liga;
import br.com.touros.punterbot.api.model.cadastro.Temporada;

import java.util.stream.Stream;

public interface ILigaService extends IGenericService<Liga, Long> {
    Stream<Temporada> buscarTemporadas(Boolean apenasAtuais);

    void atualizar(AtualizarNomeRequest atualizarNomeRequest);
}
