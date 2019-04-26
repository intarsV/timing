package lv.initex.database;

import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.EventTeamRegistry;
import lv.initex.domain.SubEvent;
import lv.initex.domain.TeamRace;

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
