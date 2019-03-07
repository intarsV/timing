package lv.timing.report.teamReport.services.processBoatClass.claclulations;

import lv.timing.domain.TeamRace;
import lv.timing.domain.reportDomain.single.RaceResultList;
import lv.timing.domain.reportDomain.team.TeamRaceResultList;

public class SetTeamStartFinishPenDsqr {

    public static void processHeatOne(TeamRace teamRace, TeamRaceResultList item) {
        item.setHeatOneStartTime(teamRace.getStartTime());
        item.setHeatOneFinishTime(teamRace.getFinishTime());
        item.setHeatOnePenaltyList(teamRace.getPenaltyList());
        item.setHeatOneDsqr(teamRace.isDsqr());
    }
}
