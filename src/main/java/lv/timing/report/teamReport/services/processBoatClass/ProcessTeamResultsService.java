package lv.timing.report.teamReport.services.processBoatClass;

import lv.timing.domain.*;
import lv.timing.domain.reportDomain.team.TeamRaceResultList;
import lv.timing.report.singleReport.services.processBoatClass.claclulations.RankList;
import lv.timing.report.teamReport.services.processBoatClass.claclulations.RankTeamList;
import lv.timing.report.teamReport.services.processBoatClass.convert.ConvertToTeamResultList;
import lv.timing.report.teamReport.services.processList.GetTeamInitialClassListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessTeamResultsService {

    @Autowired
    private GetTeamInitialClassListService getInitialClassListService;


    public List<TeamRaceResultList> process(CompetitionEvent competitionEvent, TeamBoatClass boatClass) {

        List<EventTeamRegistry> initialList = getInitialClassListService.getInitialList(competitionEvent, boatClass);

        List<TeamRaceResultList> list = ConvertToTeamResultList.convert(initialList);

        RankTeamList.rank(list);

        return list;
    }
}
