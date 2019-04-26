package lv.initex.report.teamReport.services.processList;

import lv.initex.database.TeamEventRegistryRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.EventTeamRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTeamInitialAllListService {

    @Autowired
    private TeamEventRegistryRepository database;

    public List<EventTeamRegistry> getInitialList(CompetitionEvent competitionEvent) {
        return database.registryList(competitionEvent);
    }

}
