package lv.initex.report.teamReport.services.processBoatClass.convert;

import lv.initex.domain.EventTeamRegistry;
import lv.initex.domain.TeamRace;
import lv.initex.domain.reportDomain.team.TeamRaceResultList;
import lv.initex.report.singleReport.services.processBoatClass.claclulations.CalcRaceTime;
import lv.initex.report.singleReport.services.processBoatClass.claclulations.CalcTotal;
import lv.initex.report.teamReport.services.processBoatClass.claclulations.SetTeamStartFinishPenDsqr;

import java.util.ArrayList;
import java.util.List;

public class ConvertToTeamResultList {

    public static List<TeamRaceResultList> convert(List<EventTeamRegistry> initialList) {
        List<TeamRaceResultList> list = new ArrayList<>();
        for (EventTeamRegistry eventTeamRegistry : initialList) {
            TeamRaceResultList item = new TeamRaceResultList(eventTeamRegistry, eventTeamRegistry.getBib());

            if (item.getEventTeamRegistry().getRaceResult().size() > 0) {
                for (TeamRace s : item.getEventTeamRegistry().getRaceResult()) {

                    processHeatOne(s, item);

                }
            }
            list.add(item);
        }
        return list;
    }

    private static void processHeatOne(TeamRace teamRace, TeamRaceResultList item) {
        SetTeamStartFinishPenDsqr.processHeatOne(teamRace, item);
        item.setHeatOneRaceTime(CalcRaceTime.execute(item.getHeatOneStartTime(), item.getHeatOneFinishTime()));
        item.setHeatOneTotal(CalcTotal.execute(item.getHeatOneFinishTime(), item.getHeatOneRaceTime()
                , item.getHeatOnePenaltyList(), item.isHeatOneDsqr()));
    }

}
