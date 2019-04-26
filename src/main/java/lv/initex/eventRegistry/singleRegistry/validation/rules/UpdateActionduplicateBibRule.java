package lv.initex.eventRegistry.singleRegistry.validation.rules;

import lv.initex.Error;
import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.EventSingleRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateActionduplicateBibRule {

    @Autowired
    private SingleEventRegistryRepository database;

    public Optional<Error> execute(EventSingleRegistry eventSingleRegistry) {

        Long eventSingleRegistryId=eventSingleRegistry.getId();
        CompetitionEvent competitionEvent=eventSingleRegistry.getCompetitionEvent();
        int searchBIB=eventSingleRegistry.getBib();

        if (searchBIB >0) {
            Optional<EventSingleRegistry> findEventSingleRegistry =database.findSingleRaceRegistryByIdEventBib(eventSingleRegistryId,competitionEvent,searchBIB) ;
            if (findEventSingleRegistry.isPresent()) {
                Error error = new Error( "Duplicate bib number  exists");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }

}
