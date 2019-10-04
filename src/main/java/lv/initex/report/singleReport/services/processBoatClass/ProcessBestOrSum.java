package lv.initex.report.singleReport.services.processBoatClass;

import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.reportDomain.single.RaceResultList;

import java.util.List;

public class ProcessBestOrSum {

    public static void execute(List<RaceResultList> list, CompetitionEvent competitionEvent) {
        Long format = competitionEvent.getEventFormat().getId();

        if (format == 1) {
            //process best
            processBest(list);
        } else if (format == 4 || format == 7) {
            //process sum
            processSum(list);
        } else if (format == 5) {
            processBest(list);
        }
    }

    private static void processBest(List<RaceResultList> list) {
        for (RaceResultList i : list) {
            int compare = i.getHeatOneTotal().compareTo(i.getHeatTwoTotal());
            if (compare == 1) {
                i.setBestH1H2(i.getHeatTwoTotal());
            } else {
                i.setBestH1H2(i.getHeatOneTotal());
            }
        }
    }

    private static void processSum(List<RaceResultList> list) {
        for (RaceResultList i : list) {
            i.setSumH1H2(i.getHeatOneTotal().add(i.getHeatTwoTotal()));
        }
    }
}
