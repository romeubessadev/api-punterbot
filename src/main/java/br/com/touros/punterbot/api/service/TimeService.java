package br.com.touros.punterbot.api.service;

import br.com.touros.punterbot.api.controller.request.AtualizarTimeRequest;
import br.com.touros.punterbot.api.core.persistence.GenericService;
import br.com.touros.punterbot.api.exceptions.ValidException;
import br.com.touros.punterbot.api.model.cadastro.Time;
import br.com.touros.punterbot.api.repository.TimeRepository;
import br.com.touros.punterbot.api.service.interfaces.ITimeService;
import br.com.touros.punterbot.api.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class TimeService extends GenericService<Time, Long, TimeRepository> implements ITimeService {
    public TimeService(TimeRepository repository) {
        super(repository, Time.class);
    }

    @Override
    public void atualizar(AtualizarTimeRequest atualizarNomeRequest) {
        var time = buscarPorId(atualizarNomeRequest.getId());
        if (Utils.isNull(time)) {
            throw new ValidException("Time", "Não existe time com esse código");
        }

        time.setNome(atualizarNomeRequest.getNome());
        time.setTwitter(atualizarNomeRequest.getTwitter());
        time.setAnoFundado(atualizarNomeRequest.getAnoFundado());
        salvar(time);
    }

}
