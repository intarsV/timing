package lv.timing.eventRegistry.singleRegistry.validation.rules;

import lv.timing.Error;
import lv.timing.database.SingleEventRegistryRepository;
import lv.timing.domain.SingleBoatClass;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.Competitor;
import lv.timing.domain.EventSingleRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateActionDuplicateCompetitorInClassRule {
    @Autowired
    private SingleEventRegistryRepository database;

    public Optional<Error> execute(EventSingleRegistry eventSingleRegistry) {
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
