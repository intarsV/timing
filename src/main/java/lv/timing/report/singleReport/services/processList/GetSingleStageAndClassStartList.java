package lv.timing.report.singleReport.services.processList;

import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SubEvent;
import lv.timing.domain.reportDomain.single.RaceResultList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GetSingleStageAndClassStartList {
    public static List<RaceResultList> execute(List<RaceResultList> list, CompetitionEvent event, SubEvent subEvent) {
        String stage = subEvent.getSubEvent();
        List<RaceResultList> filteredTmp = new ArrayList<>();
        List<RaceResultList> filtered = new ArrayList<>();
        switch (stage) {
            case "Heat 1":
                filtered = list.stream()
                        .collect(Collectors.toList());
                break;
            case "Heat 2":
                filtered = list.stream()
                        .filter(s -> true != (s.isHeatOneQualified()))
                        .sorted(Comparator.comparing(RaceResultList::getBib).reversed())
                        .collect(Collectors.toList());
                break;
            case "Semi-Final":
                filteredTmp = list.stream()
                        .filter(s -> true == (s.isHeatOneQualified()) )
                        .sorted(Comparator.comparing(RaceResultList::getHeatOneTotal).reversed())
                        .collect(Collectors.toList());
                filtered = list.stream()
                        .filter(s -> true == ( true == (s.isHeatTwoQualified())))
                        .sorted(Comparator.comparing(RaceResultList::getHeatTwoTotal).reversed())
                        .collect(Collectors.toList());
                filtered.addAll(filteredTmp);
                break;
            case "Final":
                Long format = event.getEventFormat().getId();
                if (format == 6) {
                    filtered = list.stream()
                            .filter(s -> true == (s.isHeatOneQualified()))
                            .sorted(Comparator.comparing(RaceResultList::getHeatOneTotal).reversed())
                            .collect(Collectors.toList());
                } else if (format == 3) {
                    filtered = list.stream()
                            .filter(s -> true == (s.isSemiFinalQualified()))
                            .sorted(Comparator.comparing(RaceResultList::getSemiFinalTotal).reversed())
                            .collect(Collectors.toList());
                } else if (format == 2) {
                    filteredTmp = list.stream()
                            .filter(s -> true == (s.isHeatOneQualified()) )
                            .sorted(Comparator.comparing(RaceResultList::getHeatOneTotal).reversed())
                            .collect(Collectors.toList());
                    filtered = list.stream()
                            .filter(s -> true == ( true == (s.isHeatTwoQualified())))
                            .sorted(Comparator.comparing(RaceResultList::getHeatTwoTotal).reversed())
                            .collect(Collectors.toList());
                    filtered.addAll(filteredTmp);
                } else if (format == 5) {
                    filtered = list.stream()
                            .filter(s -> true == (s.isBestH1h2Qualified()))
                            .sorted(Comparator.comparing(RaceResultList::getBestH1H2).reversed())
                            .collect(Collectors.toList());
                }
                break;
        }
        return filtered;
    }
}
