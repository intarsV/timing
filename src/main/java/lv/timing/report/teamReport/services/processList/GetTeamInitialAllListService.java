package lv.timing.report.teamReport.services.processList;

import lv.timing.database.TeamEventRegistryRepository;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.EventTeamRegistry;
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
