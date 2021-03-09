package br.com.touros.punterbot.api.scrapper.analise.dePara;

import br.com.touros.punterbot.api.integracao.sportmonks.ISportMonksRestApi;
import br.com.touros.punterbot.api.integracao.sportmonks.TeamFixtureResult;
import br.com.touros.punterbot.api.integracao.sportmonks.response.Fixture;
import br.com.touros.punterbot.api.integracao.sportmonks.response.League;
import br.com.touros.punterbot.api.integracao.sportmonks.response.Team;
import br.com.touros.punterbot.api.model.cadastro.*;
import br.com.touros.punterbot.api.scrapper.ScrapperInstancesFactory;
import br.com.touros.punterbot.api.scrapper.analise.IJogoParaAnalise;
import br.com.touros.punterbot.api.utils.Utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Efetua o De Para Recebendo uma entidade que implementa IJogoParaAnalise
 *
 * @param <T>
 */
public abstract class DeParaProcessor<T extends IJogoParaAnalise> {

    private final ISportMonksRestApi sportMonksRestApi;

    private final T entity;
    private Jogo jogo;

    protected DeParaProcessor(T entity) {
        this.entity = entity;
        sportMonksRestApi = ScrapperInstancesFactory.getInstance().getSportMonksRestApi();
    }

    public void jogo() {
        jogo = new Jogo();
        jogo.setId(entity.getId());
        jogo.setData(new Tempo(entity.getTime()));
    }

    // todo buscar liga local antes da api
    public void liga() {
        jogo.setLiga(createLeague(entity.getLeagueId()));
    }

    public void timeDeCasa() {
        jogo.setTimeCasa(createTeam(entity.getLocalTeamId()));
        setarUltimosJogos(jogo.getTimeCasa(), TeamFixtureResult.LOCAL);
    }

    public void timeDeFora() {
        jogo.setTimeVisita(createTeam(entity.getVisitorTeamId()));
        setarUltimosJogos(jogo.getTimeVisita(), TeamFixtureResult.VISITOR);
    }

    private void setarUltimosJogos(Time time, TeamFixtureResult result) {
        TimeJogoHistorico ultimosJogos = new TimeJogoHistorico();
        ultimosJogos.setLiga(buscarUltimosJogos(time.getId(), entity.getLeagueId(), result));
        ultimosJogos.setGeral(buscarUltimosJogos(time.getId(), null, result));
        time.setUltimosJogos(ultimosJogos);
    }

    // todo buscar time local antes da api
    private Time createTeam(Long teamId) {
        Team team = sportMonksRestApi.buscarTimePorId(teamId);
        return new Time(team);
    }

    public List<JogoHistorico> buscarUltimosJogos(Long teamId, Long leagueId, TeamFixtureResult teamFixtureResult) {
        List<Long> fixturesId = sportMonksRestApi.buscarIdsUltimosJogos(teamId, leagueId, teamFixtureResult);
        if (Utils.isNullOrEmpty(fixturesId)) return Collections.emptyList();

        List<Fixture> fixtures = sportMonksRestApi.buscarFixturesPorId(fixturesId);
        if (Utils.isNullOrEmpty(fixtures)) return Collections.emptyList();

        return fixtures.stream().map(JogoHistorico::new).collect(Collectors.toList());
    }

    private Liga createLeague(Long leagueId) {
        Liga la = new Liga();
        League league = sportMonksRestApi.buscarLigaPorId(leagueId);
        la.setId(league.getId());
        la.setLogo(league.getLogoPath());
        la.setNome(league.getName());
        return la;
    }

    protected T getEntity() {
        return entity;
    }

    public Jogo resultado() {
        return jogo;
    }
}
