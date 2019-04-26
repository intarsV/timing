package lv.initex.report.teamReport.services.processBoatClass;

import lv.initex.domain.SubEvent;
import lv.initex.domain.reportDomain.team.TeamRaceResultList;
import lv.initex.domain.reportDomain.team.TeamRaceStageList;

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
