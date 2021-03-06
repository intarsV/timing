package lv.initex.eventRegistry.singleRegistry.validation.rules;

import lv.initex.Error;
import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.EventSingleRegistry;

import java.util.Optional;


public class UpdateDuplicateBibRule {

    public Optional<Error> execute(EventSingleRegistry eventSingleRegistry, SingleEventRegistryRepository database) {

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
