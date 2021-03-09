package br.com.touros.punterbot.api.service.interfaces;

import br.com.touros.punterbot.api.controller.request.AtualizarTimeRequest;
import br.com.touros.punterbot.api.core.persistence.IGenericService;
import br.com.touros.punterbot.api.model.cadastro.Time;

public interface ITimeService extends IGenericService<Time, Long> {
    void atualizar(AtualizarTimeRequest atualizarTimeRequest);
}
