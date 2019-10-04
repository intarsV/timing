package lv.initex.eventRegistry.singleRegistry.validation.rules;

import lv.initex.Error;
import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.EventSingleRegistry;

import java.util.List;
import java.util.Optional;


public class InsertActDuplicateBibRule {

    public Optional<Error> execute(List valueList, SingleEventRegistryRepository database) {

        CompetitionEvent competitionEvent = (CompetitionEvent) valueList.get(0);
        int searchBIB = Integer.valueOf(valueList.get(4).toString());

        if (searchBIB > 0) {
            Optional<EventSingleRegistry> findEventSingleRegistry = database.findSingleRaceRegistryByBib(competitionEvent, searchBIB);
            if (findEventSingleRegistry.isPresent()) {
                Error error = new Error("Duplicate bib number  exists");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}
