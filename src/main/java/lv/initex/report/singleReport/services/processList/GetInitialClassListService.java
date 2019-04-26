package lv.initex.report.singleReport.services.processList;

import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.EventSingleRegistry;
import lv.initex.domain.SingleBoatClass;
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
