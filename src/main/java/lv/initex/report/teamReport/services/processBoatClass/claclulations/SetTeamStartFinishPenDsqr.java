package lv.initex.report.teamReport.services.processBoatClass.claclulations;

import lv.initex.domain.TeamRace;
import lv.initex.domain.reportDomain.team.TeamRaceResultList;

public class SetTeamStartFinishPenDsqr {

    public static void processHeatOne(TeamRace teamRace, TeamRaceResultList item) {
        item.setHeatOneStartTime(teamRace.getStartTime());
        item.setHeatOneFinishTime(teamRace.getFinishTime());
        item.setHeatOnePenaltyList(teamRace.getPenaltyList());
        item.setHeatOneDsqr(teamRace.isDsqr());
    }
}
