package br.com.touros.punterbot.api.integracao.sportmonks;

import br.com.touros.punterbot.api.core.configuracao.PunterbotApiConfiguracao;
import br.com.touros.punterbot.api.core.configuracao.SportmonksConfiguracao;
import br.com.touros.punterbot.api.utils.Utils;
import br.com.touros.punterbot.api.integracao.sportmonks.response.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SportmonksComponent implements ISportMonksRestApi {

    private final SportmonksConfiguracao sportmonksConfiguracao;

    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final WebClient client;

    public SportmonksComponent(PunterbotApiConfiguracao punterbotApiConfiguracao) {
        this.sportmonksConfiguracao = punterbotApiConfiguracao.getSportmonks();
        this.client = WebClient.create(sportmonksConfiguracao.getUrl());
    }


    @Override
    public List<Team> buscarTimesDaSeason(Long seasonId) {
        return client.get()
                .uri(uriBuilder -> {
                    uriBuilder.path(SportMonksConstants.Uri.TEAMS_SEASON)
                            .pathSegment(String.valueOf(seasonId));
                    return buildParam(uriBuilder);
                })
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToFlux(TeamListResponse.class)
                .blockFirst()
                .getTeams();
    }

    @Override
    public List<League> buscarLigas(Integer pagina) {
        return client.get()
                .uri(uriBuilder -> {
                    uriBuilder.path(SportMonksConstants.Uri.LEAGUES)
                            .queryParam(SportMonksConstants.Parameter.PAGE, pagina)
                            .queryParam(SportMonksConstants.Parameter.INCLUDE, "seasons");
                    return buildParam(uriBuilder);
                })
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToFlux(LeagueListResponse.class)
                .blockFirst()
                .getData();
    }

    @Override
    public List<LiveScore> buscarJogosHoje() {
        return client.get()
                .uri(uriBuilder -> {
                    uriBuilder.path(SportMonksConstants.Uri.LIVE_SCORES)
                            .queryParam(SportMonksConstants.Parameter.BOOKMARKET, 2)
                            .queryParam(SportMonksConstants.Parameter.STATUS, "NS");
                    return buildParam(uriBuilder);
                })
                .retrieve()
                .bodyToFlux(LiveScoreResponse.class)
                .blockFirst()
                .getLiveScores();
    }

    @Override
    public List<LiveScore> buscarJogosAoVivo() {
        return client.get()
                .uri(uriBuilder -> {
                    uriBuilder.path(SportMonksConstants.Uri.LIVE_SCORES)
                            .queryParam(SportMonksConstants.Parameter.BOOKMARKET, 2)
                            .queryParam(SportMonksConstants.Parameter.INCLUDE, "localTeam,visitorTeam")
                            .queryParam(SportMonksConstants.Parameter.STATUS, "LIVE");
                    return buildParam(uriBuilder);
                })
                .retrieve()
                .bodyToFlux(LiveScoreResponse.class)
                .blockFirst()
                .getLiveScores();
    }

    private String format(Date da) {
        return SIMPLE_DATE_FORMAT.format(da);
    }

    @Override
    public List<Fixture> buscarJogosPorData(Date dataInicio, Date dataFim) {
        return client.get()
                .uri(uriBuilder -> {
                    uriBuilder.path(SportMonksConstants.Uri.FIXTURES_BETWEEN)
                            .pathSegment(format(dataInicio), format(dataFim))
                            .queryParam(SportMonksConstants.Parameter.BOOKMARKET, 2)
                            .queryParam(SportMonksConstants.Parameter.INCLUDE, "localTeam,visitorTeam")
                            .queryParam(SportMonksConstants.Parameter.STATUS, "NS");

                    return buildParam(uriBuilder);
                })
                .retrieve()
                .bodyToFlux(FixturesResponse.class)
                .blockFirst()
                .getFixtures();
    }

    @Override
    public List<Fixture> buscarFixturePorId(Long fixtureId) {
        return client.get()
                .uri(uriBuilder -> {
                    uriBuilder.path(SportMonksConstants.Uri.FIXTURES)
                            .path(String.valueOf(fixtureId))
                            .queryParam(SportMonksConstants.Parameter.BOOKMARKET, 2)
                            .queryParam(SportMonksConstants.Parameter.INCLUDE, "localTeam,visitorTeam");
                    return buildParam(uriBuilder);
                })
                .retrieve()
                .bodyToFlux(FixturesResponse.class)
                .blockFirst()
                .getFixtures();
    }


    @Override
    public List<Fixture> buscarFixturesPorId(List<Long> liveScoreIds) {
        return client.get()
                .uri(uriBuilder -> {
                    uriBuilder.path(SportMonksConstants.Uri.FIXTURES)
                            .path(liveScoreIds
                                    .stream()
                                    .map(String::valueOf)
                                    .collect(Collectors.joining(","))
                            )
                            .queryParam(SportMonksConstants.Parameter.BOOKMARKET, 2)
                            .queryParam(SportMonksConstants.Parameter.INCLUDE, "localTeam,visitorTeam,corners,stats,goals");
                    return buildParam(uriBuilder);
                })
                .retrieve()
                .bodyToFlux(FixturesResponse.class)
                .blockFirst()
                .getFixtures();
    }

    @Override
    public League buscarLigaPorId(Long leagueId) {
        return client.get()
                .uri(uriBuilder -> {
                    uriBuilder.path(SportMonksConstants.Uri.LEAGUES)
                            .path("/" + leagueId);

                    return buildParam(uriBuilder);
                })
                .retrieve()
                .bodyToFlux(LeagueResponse.class)
                .blockFirst()
                .getLeague();
    }


    @Override
    public Team buscarTimePorId(Long teamId) {
        return client.get()
                .uri(uriBuilder -> {
                    uriBuilder.path(SportMonksConstants.Uri.TEAMS)
                            .path(String.valueOf(teamId));

                    return buildParam(uriBuilder);
                })
                .retrieve()
                .bodyToFlux(TeamResponse.class)
                .blockFirst()
                .getTeam();
    }

    @Override
    public List<Long> buscarIdsUltimosJogos(Long teamId, Long leagueId, TeamFixtureResult result) {
        return client.get()
                .uri(uriBuilder -> {
                    uriBuilder.path(SportMonksConstants.Uri.TEAMS)
                            .path(String.valueOf(teamId));

                    StringBuilder includeSearch = new StringBuilder(result.getInclude());

                    if (!Utils.isNull(leagueId)) {
                        includeSearch.append(":filter(league_id|").append(leagueId).append(")");
                    }

                    includeSearch.append(":limit(10|1)");

                    uriBuilder.queryParam(SportMonksConstants.Parameter.INCLUDE, includeSearch.toString());

                    return buildParam(uriBuilder);
                })
                .retrieve()
                .bodyToFlux(TeamResponse.class)
                .blockFirst()
                .getTeam()
                .getResult()
                .stream()
                .map(Fixture::getId)
                .collect(Collectors.toList());

    }

    private URI buildParam(UriBuilder uriBuilder) {
        return uriBuilder.queryParam(SportMonksConstants.Parameter.TZ, "America/Campo_Grande")
                .queryParam(SportMonksConstants.Parameter.TOKEN, sportmonksConfiguracao.getToken())
                .build();
    }
}
