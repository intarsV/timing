package lv.timing.eventRegistry.singleRegistry.validation.rules;

import lv.timing.Error;
import lv.timing.database.SingleEventRegistryRepository;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.EventSingleRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InsertActionDuplicateBibRule {

    @Autowired
    private SingleEventRegistryRepository database;

    public Optional<Error> execute(List valueList) {

        CompetitionEvent competitionEvent=(CompetitionEvent)valueList.get(0);
        int searchBIB=Integer.valueOf(valueList.get(4).toString());

        if (searchBIB >0) {
            Optional<EventSingleRegistry> findEventSingleRegistry = database.findSingleRaceRegistryByBib(competitionEvent,searchBIB);
            if (findEventSingleRegistry.isPresent()) {
                Error error = new Error( "Duplicate bib number  exists");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}
