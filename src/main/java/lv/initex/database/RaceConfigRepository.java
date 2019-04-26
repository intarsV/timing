package lv.initex.database;

import lv.initex.domain.SingleBoatClass;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.RaceConfig;

import java.util.List;
import java.util.Optional;

public interface RaceConfigRepository {

    List<RaceConfig> raceConfigList(CompetitionEvent competitionEvent);

    void addRaceConfig(RaceConfig raceConfig);

    boolean deleteRaceConfig(RaceConfig raceConfig);

    Optional<RaceConfig> findRaceConfigById(Long id);

    Optional<RaceConfig> getQualifiedNumber(CompetitionEvent event,SingleBoatClass boatClass);
}
