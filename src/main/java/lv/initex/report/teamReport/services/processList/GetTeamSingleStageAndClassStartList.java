package lv.initex.report.teamReport.services.processList;

import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.SubEvent;
import lv.initex.domain.reportDomain.team.TeamRaceResultList;

import java.util.ArrayList;
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
