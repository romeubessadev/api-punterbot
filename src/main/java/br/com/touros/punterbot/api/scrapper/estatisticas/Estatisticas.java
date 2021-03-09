package br.com.touros.punterbot.api.scrapper.estatisticas;

import br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.ft.FT75EscanteioEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.ft.FT82EscanteioEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.ft.FTLimiteEscanteioEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.ht.*;
import br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.over.*;
import br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.periodo.PrimeiroTempoEscanteioEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.periodo.SegundoTempoEscanteioEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.escanteio.periodo.TempoTotalEscanteioEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.gol.ambos.AmbosMarcaramGolEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.gol.over.Over0_5HTGolsEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.gol.over.Over1_5FTGolsEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.gol.over.Over2_5FTGolsEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.gol.periodo.PrimeiroTempoGolsEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.gol.periodo.SegundoTempoGolsEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.gol.periodo.TempoTotalGolsEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.IEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IHtFtEscanteio;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.escanteio.IOverEscanteio;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.gol.IGolEstatistica;
import br.com.touros.punterbot.api.scrapper.estatisticas.interfaces.gol.IOverGolEstatistica;
import br.com.touros.punterbot.api.utils.SelectItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Estatisticas {

    public static class Escanteio {

        public static List<IEstatistica> Todos() {
            var lista = new ArrayList<IEstatistica>();
            lista.addAll(Escanteio.OVERS);
            lista.addAll(Escanteio.HTS);
            lista.addAll(Escanteio.FTS);
            lista.addAll(Escanteio.PERIODOS);
            return lista;
        }

        public static List<SelectItem> Selects() {
            return Escanteio.Todos()
                    .stream()
                    .map(Estatisticas::toSelect)
                    .collect(Collectors.toList());
        }

        public static final LinkedList<IOverEscanteio> OVERS = new LinkedList<>() {
            {
                add(new Over7EscanteioEstatistica());
                add(new Over8EscanteioEstatistica());
                add(new Over9EscanteioEstatistica());
                add(new Over10EscanteioEstatistica());
                add(new Over11EscanteioEstatistica());
                add(new Over12EscanteioEstatistica());
            }
        };

        public static final LinkedList<IHtFtEscanteio> HTS = new LinkedList<>() {
            {
                add(new HT10EscanteioEstatistica());
                add(new HT20EscanteioEstatistica());
                add(new HT35EscanteioEstatistica());
                add(new HT38EscanteioEstatistica());
                add(new HT50EscanteioEstatistica());
                add(new HT60EscanteioEstatistica());
                add(new HTLimiteEscanteioEstatistica());
            }
        };


        public static final LinkedList<IHtFtEscanteio> FTS = new LinkedList<>() {
            {
                add(new FT75EscanteioEstatistica());
                add(new FT82EscanteioEstatistica());
                add(new FTLimiteEscanteioEstatistica());
            }
        };

        public static final LinkedList<IHtFtEscanteio> PERIODOS = new LinkedList<>() {
            {
                add(new PrimeiroTempoEscanteioEstatistica());
                add(new SegundoTempoEscanteioEstatistica());
                add(new TempoTotalEscanteioEstatistica());
            }
        };
    }

    public static class Gol {

        public static List<IEstatistica> Todos() {
            var lista = new ArrayList<IEstatistica>();
            lista.addAll(Gol.OVERS);
            lista.addAll(Gol.PERIODOS);
            lista.add(Gol.AMBOS_MARCARAM);
            return lista;
        }

        public static List<SelectItem> Selects() {
            return Todos()
                    .stream()
                    .map(Estatisticas::toSelect)
                    .collect(Collectors.toList());
        }


        public static final IEstatistica AMBOS_MARCARAM = new AmbosMarcaramGolEstatistica();

        public static final LinkedList<IOverGolEstatistica> OVERS = new LinkedList<>() {
            {
                add(new Over0_5HTGolsEstatistica());
                add(new Over1_5FTGolsEstatistica());
                add(new Over2_5FTGolsEstatistica());
            }
        };

        public static final LinkedList<IGolEstatistica> PERIODOS = new LinkedList<>() {
            {
                add(new PrimeiroTempoGolsEstatistica());
                add(new SegundoTempoGolsEstatistica());
                add(new TempoTotalGolsEstatistica());
            }
        };

    }

    private static SelectItem toSelect(IEstatistica iEstatistica) {
        return new SelectItem(iEstatistica.nome(), iEstatistica.chave());
    }
}
