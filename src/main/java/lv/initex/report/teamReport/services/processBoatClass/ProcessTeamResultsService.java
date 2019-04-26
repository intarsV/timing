package lv.initex.report.teamReport.services.processBoatClass;

import lv.initex.domain.*;
import lv.initex.domain.reportDomain.team.TeamRaceResultList;
import lv.initex.report.teamReport.services.processBoatClass.claclulations.RankTeamList;
import lv.initex.report.teamReport.services.processBoatClass.convert.ConvertToTeamResultList;
import lv.initex.report.teamReport.services.processList.GetTeamInitialClassListService;
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
