package lv.timing.report.teamReport.services.processBoatClass.convert;

import lv.timing.domain.EventTeamRegistry;
import lv.timing.domain.TeamRace;
import lv.timing.domain.reportDomain.team.TeamRaceResultList;
import lv.timing.report.singleReport.services.processBoatClass.claclulations.CalcRaceTime;
import lv.timing.report.singleReport.services.processBoatClass.claclulations.CalcTotal;
import lv.timing.report.teamReport.services.processBoatClass.claclulations.SetTeamStartFinishPenDsqr;

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
