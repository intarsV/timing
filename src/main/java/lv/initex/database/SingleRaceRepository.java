package lv.initex.database;

import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.EventSingleRegistry;
import lv.initex.domain.SingleRace;
import lv.initex.domain.SubEvent;

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
