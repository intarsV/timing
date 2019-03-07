package lv.timing.report.singleReport.services.processList;

import lv.timing.database.SingleEventRegistryRepository;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.EventSingleRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetInitialAllListService {

    @Autowired
    private SingleEventRegistryRepository database;

    public List<EventSingleRegistry> getInitialList(CompetitionEvent competitionEvent) {
        return database.registryList(competitionEvent);
    }

}
