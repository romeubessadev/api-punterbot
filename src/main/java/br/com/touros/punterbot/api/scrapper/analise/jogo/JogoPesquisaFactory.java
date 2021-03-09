package br.com.touros.punterbot.api.scrapper.analise.jogo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class JogoPesquisaFactory {

    public static DeHojeJogoAnaliseBuilder DeHoje() {
        return new DeHojeJogoAnaliseBuilder();
    }

    public static AoVivoJogoAnaliseBuilder AoVivo() {
        return new AoVivoJogoAnaliseBuilder();
    }

    public static PorIdJogoAnaliseBuilder PorId(Long id) {
        return new PorIdJogoAnaliseBuilder(id);
    }

    public static PorDataJogoAnaliseBuilder PorData(Date dataInicio, Date dataFim) {
        return new PorDataJogoAnaliseBuilder(dataInicio, dataFim);
    }

    public static PorDataJogoAnaliseBuilder Amanha() {
        Date amanha = Date.from(LocalDate.now().plusDays(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        return PorData(amanha, amanha);
    }

    public static PorDataJogoAnaliseBuilder Mes() {
        LocalDate inicial = LocalDate.now();
        Date primeiroDiaDoMes = Date.from(inicial.withDayOfMonth(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date ultimoDiaDoMes = Date.from(inicial.withDayOfMonth(inicial.lengthOfMonth()).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        return PorData(primeiroDiaDoMes, ultimoDiaDoMes);
    }
}
