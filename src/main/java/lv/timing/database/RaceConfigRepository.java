package lv.timing.database;

import lv.timing.domain.SingleBoatClass;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.RaceConfig;

import java.util.List;
import java.util.Optional;

public interface RaceConfigRepository {

    List<RaceConfig> raceConfigList(CompetitionEvent competitionEvent);

    void addRaceConfig(RaceConfig raceConfig);

    boolean deleteRaceConfig(RaceConfig raceConfig);

    Optional<RaceConfig> findRaceConfigById(Long id);

    Optional<RaceConfig> getQualifiedNumber(CompetitionEvent event,SingleBoatClass boatClass);
}
