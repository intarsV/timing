package lv.timing.database.implementations;

import lv.timing.database.RaceConfigRepository;
import lv.timing.domain.SingleBoatClass;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.RaceConfig;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class RaceConfigRepositoryImpl extends Repository implements RaceConfigRepository {

    @Override
    public List<RaceConfig> raceConfigList(CompetitionEvent competitionEvent) {
        return session()
                .createCriteria(RaceConfig.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .list();
    }

    @Override
    public void addRaceConfig(RaceConfig raceConfig) {
        session().save(raceConfig);
    }

    @Override
    public boolean deleteRaceConfig(RaceConfig raceConfig) {
        session().delete(raceConfig);
        return true;
    }

    @Override
    public Optional<RaceConfig> findRaceConfigById(Long id) {
        RaceConfig raceConfig = (RaceConfig) session()
                .createCriteria(RaceConfig.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(raceConfig);
    }

    @Override
    public Optional<RaceConfig> getQualifiedNumber(CompetitionEvent event, SingleBoatClass boatClass) {
        RaceConfig raceConfig = (RaceConfig) session()
                .createCriteria(RaceConfig.class)
                .add(Restrictions.eq("competitionEvent", event))
                .add(Restrictions.eq("singleBoatClass", boatClass))
                .uniqueResult();
        return Optional.ofNullable(raceConfig);
    }
}
