package lv.initex.eventRegistry.singleRegistry.validation.rules;

import lv.initex.Error;
import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.Competitor;
import lv.initex.domain.EventSingleRegistry;
import lv.initex.domain.SingleBoatClass;

import java.util.List;
import java.util.Optional;


public class InsertActDuplicateCompetitorInClassRule {

    public Optional<Error> execute(List valueList, SingleEventRegistryRepository database) {
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
