package lv.timing.report.teamReport.services.processList;

import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SingleBoatClass;
import lv.timing.domain.SubEvent;
import lv.timing.domain.TeamBoatClass;
import lv.timing.domain.reportDomain.single.RaceResultList;
import lv.timing.domain.reportDomain.team.TeamRaceResultList;
import lv.timing.report.singleReport.services.processBoatClass.ProcessResultsService;
import lv.timing.report.teamReport.services.processBoatClass.ProcessTeamResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetTeamSingleStageAllStartList {

    @Autowired
    private ProcessTeamResultsService process;

    public List<TeamRaceResultList> execute(CompetitionEvent event, SubEvent subEvent) {
        List<TeamRaceResultList> filteredC1Woman = getC1Woman(event, subEvent);
        List<TeamRaceResultList> filteredC1Man = getC1Man(event, subEvent);
        List<TeamRaceResultList> filteredK1Woman = getK1Woman(event, subEvent);
        List<TeamRaceResultList> filteredK1Man = getK1Man(event, subEvent);
        List<TeamRaceResultList> merged = new ArrayList<>();
        merged.addAll(filteredC1Woman);
        merged.addAll(filteredC1Man);
        merged.addAll(filteredK1Woman);
        merged.addAll(filteredK1Man);
        return merged;
    }

    private List<TeamRaceResultList> getC1Woman(CompetitionEvent event, SubEvent subEvent) {
        TeamBoatClass boatClass = new TeamBoatClass();
        boatClass.setId(new Long(1));
        List<TeamRaceResultList> list = process.process(event, boatClass);
        List<TeamRaceResultList> filtered = GetTeamSingleStageAndClassStartList.execute(list, event, subEvent);
        return filtered;
    }

    private List<TeamRaceResultList> getC1Man(CompetitionEvent event, SubEvent subEvent) {
        TeamBoatClass boatClass = new TeamBoatClass();
        boatClass.setId(new Long(2));
        List<TeamRaceResultList> list = process.process(event, boatClass);
        List<TeamRaceResultList> filtered = GetTeamSingleStageAndClassStartList.execute(list, event, subEvent);
        return filtered;
    }

    private List<TeamRaceResultList> getK1Woman(CompetitionEvent event, SubEvent subEvent) {
        TeamBoatClass boatClass = new TeamBoatClass();
        boatClass.setId(new Long(3));
        List<TeamRaceResultList> list = process.process(event, boatClass);
        List<TeamRaceResultList> filtered = GetTeamSingleStageAndClassStartList.execute(list, event, subEvent);
        return filtered;
    }

    private List<TeamRaceResultList> getK1Man(CompetitionEvent event, SubEvent subEvent) {
        TeamBoatClass boatClass = new TeamBoatClass();
        boatClass.setId(new Long(4));
        List<TeamRaceResultList> list = process.process(event, boatClass);
        List<TeamRaceResultList> filtered = GetTeamSingleStageAndClassStartList.execute(list, event, subEvent);
        return filtered;
    }
}
