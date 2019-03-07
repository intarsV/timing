package lv.timing.report.singleReport.services.processList;

import lv.timing.database.SingleEventRegistryRepository;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.EventSingleRegistry;
import lv.timing.domain.SingleBoatClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetInitialClassListService {

    @Autowired
    private SingleEventRegistryRepository database;

    public List<EventSingleRegistry> getInitialList(CompetitionEvent competitionEvent, SingleBoatClass boatClass) {
        return database.registryListByEventAndBoatClass(competitionEvent, boatClass);
    }
}
