package lv.timing.database;

import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.EventSingleRegistry;
import lv.timing.domain.SingleRace;
import lv.timing.domain.SubEvent;

import java.util.List;
import java.util.Optional;

public interface SingleRaceRepository {

    List<SingleRace> singleRaceListDone(CompetitionEvent competitionEvent, SubEvent subEvent);

    List<SingleRace> singleRaceListNotDone(CompetitionEvent competitionEvent, SubEvent subEvent);

    void saveSingleRace(SingleRace singleRace);

    Optional<EventSingleRegistry> findEventSingleRegistry(int bib, CompetitionEvent competitionEvent);

    Optional<SingleRace> findSingleRaceWithEventSingleRegistry(EventSingleRegistry eventSingleRegistry, SubEvent subEvent);

    boolean updateSingleRace(SingleRace singleRace);

    boolean deleteSingleRace(SingleRace singleRace);


}
