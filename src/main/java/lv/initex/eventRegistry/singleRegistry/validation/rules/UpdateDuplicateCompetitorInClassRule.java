package lv.initex.eventRegistry.singleRegistry.validation.rules;

import lv.initex.Error;
import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.Competitor;
import lv.initex.domain.EventSingleRegistry;
import lv.initex.domain.SingleBoatClass;

import java.util.Optional;


public class UpdateDuplicateCompetitorInClassRule {

    public Optional<Error> execute(EventSingleRegistry eventSingleRegistry, SingleEventRegistryRepository database) {
        Long id=eventSingleRegistry.getId();
        CompetitionEvent competitionEvent=eventSingleRegistry.getCompetitionEvent();
        Competitor competitor=eventSingleRegistry.getCompetitor();
        SingleBoatClass singleBoatClass =eventSingleRegistry.getSingleBoatClass();

        if (competitionEvent!=null||competitor!=null|| singleBoatClass !=null) {
            Optional<EventSingleRegistry> findEventSingleRegistry = database.updateFindSingleRaceRegistryByEventClassCompetitor(id,competitionEvent, competitor, singleBoatClass);
            if (findEventSingleRegistry.isPresent()) {
                Error error = new Error( "Duplicate competitor in class  exists");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}
