package br.com.touros.punterbot.api.integracao.sportmonks;

import br.com.touros.punterbot.api.integracao.sportmonks.response.Fixture;
import br.com.touros.punterbot.api.integracao.sportmonks.response.League;
import br.com.touros.punterbot.api.integracao.sportmonks.response.LiveScore;
import br.com.touros.punterbot.api.integracao.sportmonks.response.Team;

import java.util.Date;
import java.util.List;

public interface ISportMonksRestApi {

    List<Team> buscarTimesDaSeason(Long seasonId);

    List<League> buscarLigas(Integer page);

    List<LiveScore> buscarJogosHoje();

    List<LiveScore> buscarJogosAoVivo();

    List<Fixture> buscarJogosPorData(Date dataInicio, Date dataFim);

    List<Fixture> buscarFixturePorId(Long fixtureId);

    List<Fixture> buscarFixturesPorId(List<Long> liveScoreIds);

    League buscarLigaPorId(Long leagueId);

    Team buscarTimePorId(Long teamId);

    List<Long> buscarIdsUltimosJogos(Long teamId, Long leagueId, TeamFixtureResult result);
}
