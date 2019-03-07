package lv.timing.eventRegistry.singleRegistry.validation.rules;

import lv.timing.Error;
import lv.timing.database.SingleEventRegistryRepository;
import lv.timing.domain.SingleBoatClass;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.Competitor;
import lv.timing.domain.EventSingleRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InsertActionDuplicateCompetitorInClassRule {
    @Autowired
    private SingleEventRegistryRepository database;

    public Optional<Error> execute(List valueList) {
        CompetitionEvent competitionEvent=(CompetitionEvent)valueList.get(0);
        Competitor competitor=(Competitor)valueList.get(1);
        SingleBoatClass singleBoatClass =(SingleBoatClass)valueList.get(3);



        if (competitionEvent!=null||competitor!=null|| singleBoatClass !=null) {
            Optional<EventSingleRegistry> findEventSingleRegistry = database.findSingleRaceRegistryByEventClassCompetitor(competitionEvent, competitor, singleBoatClass);
            if (findEventSingleRegistry.isPresent()) {
                Error error = new Error( "Duplicate competitor in class  exists");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}
