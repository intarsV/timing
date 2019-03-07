package lv.timing.database;

import lv.timing.domain.*;

import java.util.List;
import java.util.Optional;

public interface SingleEventRegistryRepository {

    List<EventSingleRegistry> registryList(CompetitionEvent competitionEvent);

    List<EventSingleRegistry> registryListByEventAndBoatClass(CompetitionEvent competitionEvent, SingleBoatClass boatClass);

    boolean deleteEventSingleRaceRegistry(EventSingleRegistry eventSingleregistry);

    Optional<EventSingleRegistry> findSingleRaceRegistryByID(Long id);

    Optional<EventSingleRegistry> findSingleRaceRegistryByBib(CompetitionEvent competitionEvent,int bib);

    Optional<EventSingleRegistry> findSingleRaceRegistryByIdEventBib(Long id,CompetitionEvent competitionEvent,int bib);

    Optional<EventSingleRegistry> findSingleRaceRegistryByEventClassCompetitor(CompetitionEvent competitionEvent, Competitor competitor, SingleBoatClass singleBoatClass);

    Optional<EventSingleRegistry> updateFindSingleRaceRegistryByEventClassCompetitor(Long id, CompetitionEvent competitionEvent, Competitor competitor, SingleBoatClass singleBoatClass);

    void saveEventSingleRegistry(EventSingleRegistry singleRaceRegistry);

    boolean updateEventSingleRegistry(EventSingleRegistry singleRaceRegistry);
}
