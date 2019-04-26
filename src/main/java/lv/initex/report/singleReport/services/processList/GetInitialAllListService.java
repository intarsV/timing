package lv.initex.report.singleReport.services.processList;

import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.EventSingleRegistry;
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
