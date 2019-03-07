package lv.timing.database;

import lv.timing.domain.*;

import java.util.List;
import java.util.Optional;

public interface TeamEventRegistryRepository {

    List<EventTeamRegistry> registryList(CompetitionEvent competitionEvent);

    boolean deleteEventTeamRaceRegistry(EventTeamRegistry eventteamRegistry);

    Optional<EventTeamRegistry> findTeamRaceRegistryByID(Long id);

    Optional<EventTeamRegistry> findTeamRaceRegistryByBib(CompetitionEvent competitionEvent, int bib);

    Optional<EventTeamRegistry> findTeamRaceRegistryByIdEventBib(Long id, CompetitionEvent competitionEvent, int bib);

    Optional<EventTeamRegistry> findTeamRaceRegistryByEventClassCompetitor(CompetitionEvent competitionEvent, Competitor competitor, SingleBoatClass singleBoatClass);

    Optional<EventTeamRegistry> updateFindTeamRaceRegistryByEventClassCompetitor(Long id, CompetitionEvent competitionEvent, Competitor competitor, SingleBoatClass singleBoatClass);

    Optional<CompetitionEvent> findEventByName(String eventName);

    Optional<SingleBoatClass> findBoatClassByName(String boatClassName);

    Optional<Competitor> findCompetitorByName(String competitorName);

    void saveEventTeamRegistry(EventTeamRegistry teamRaceRegistry);

    boolean updateEventTeamRegistry(EventTeamRegistry teamRaceRegistry);
}
