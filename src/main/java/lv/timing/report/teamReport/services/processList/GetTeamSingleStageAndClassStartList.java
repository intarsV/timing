package lv.timing.report.teamReport.services.processList;

import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SubEvent;
import lv.timing.domain.reportDomain.single.RaceResultList;
import lv.timing.domain.reportDomain.team.TeamRaceResultList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GetTeamSingleStageAndClassStartList {
    public static List<TeamRaceResultList> execute(List<TeamRaceResultList> list, CompetitionEvent event, SubEvent subEvent) {
        String stage = subEvent.getSubEvent();
        List<TeamRaceResultList> filteredTmp = new ArrayList<>();
        List<TeamRaceResultList> filtered = new ArrayList<>();

                filtered = list.stream()
                        .collect(Collectors.toList());
        return filtered;
    }
}
