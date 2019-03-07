package lv.timing.database;

import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.EventTeamRegistry;
import lv.timing.domain.SubEvent;
import lv.timing.domain.TeamRace;

import java.util.List;
import java.util.Optional;

public interface TeamRaceRepository {



    List<TeamRace> teamRaceListDone(CompetitionEvent competitionEvent, SubEvent subEvent);

    List<TeamRace> teamRaceListNotDone(CompetitionEvent competitionEvent, SubEvent subEvent);

    void saveTeamRace(TeamRace teamRace);

    Optional<EventTeamRegistry> findEventTeamRegistry(int bib, CompetitionEvent competitionEvent);

    Optional<TeamRace> findTeamRaceWithEventTeamRegistry(EventTeamRegistry eventTeamRegistry);

    Optional<TeamRace> findTeamRaceById(Long id);

   boolean updateTeamRace(TeamRace teamRace);

   boolean deleteTeamRace(TeamRace teamRace);


}
