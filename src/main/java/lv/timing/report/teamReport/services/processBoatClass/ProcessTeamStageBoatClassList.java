package lv.timing.report.teamReport.services.processBoatClass;

import lv.timing.domain.SubEvent;
import lv.timing.domain.reportDomain.team.TeamRaceResultList;
import lv.timing.domain.reportDomain.team.TeamRaceStageList;

import java.util.ArrayList;
import java.util.List;

public class ProcessTeamStageBoatClassList {

    public static List<TeamRaceStageList> prepareList(List<TeamRaceResultList> list, SubEvent subevent) {
        List<TeamRaceStageList> previewList = new ArrayList<>();
        for (TeamRaceResultList item : list) {

            previewList.add(new TeamRaceStageList(item.getEventTeamRegistry(), item.getHeatOneStartTime()
                    , item.getHeatOneFinishTime(), item.getHeatOnePenaltyList(), item.getHeatOneRaceTime()
                    , item.isHeatOneDsqr(), item.getHeatOneTotal(), item.getRankHeatOne()
                    , subevent.getSubEvent()));
        }
        return previewList;
    }
}
