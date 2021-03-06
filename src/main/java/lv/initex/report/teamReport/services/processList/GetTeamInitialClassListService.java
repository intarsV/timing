package lv.initex.report.teamReport.services.processList;

import lv.initex.database.TeamEventRegistryRepository;
import lv.initex.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTeamInitialClassListService {

    @Autowired
    private TeamEventRegistryRepository database;

    public List<EventTeamRegistry> getInitialList(CompetitionEvent competitionEvent, TeamBoatClass boatClass) {
        return database.registryListByEventAndBoatClass(competitionEvent, boatClass);
    }
}
