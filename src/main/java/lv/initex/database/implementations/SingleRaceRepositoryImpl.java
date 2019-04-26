package lv.initex.database.implementations;

import lv.initex.database.SingleRaceRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.EventSingleRegistry;
import lv.initex.domain.SingleRace;
import lv.initex.domain.SubEvent;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class SingleRaceRepositoryImpl extends Repository implements SingleRaceRepository {

    @Override
    public List<SingleRace> singleRaceListDone(CompetitionEvent competitionEvent, SubEvent subEvent) {
        return session()
                .createCriteria(SingleRace.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .add(Restrictions.eq("subEvent", subEvent))
                .add(Restrictions.eq("done", true))
                .list();
    }

    @Override
    public List<SingleRace> singleRaceListNotDone(CompetitionEvent competitionEvent, SubEvent subEvent) {
        return session()
                .createCriteria(SingleRace.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .add(Restrictions.eq("subEvent", subEvent))
                .add(Restrictions.eq("done", false))
                .list();
    }

    @Override
    public void saveSingleRace(SingleRace singleRace) {
        session().save(singleRace);
    }

    @Override
    public Optional<EventSingleRegistry> findEventSingleRegistry(int bib, CompetitionEvent competitionEvent) {
        EventSingleRegistry eventSingleRegistry = (EventSingleRegistry) session()
                .createCriteria(EventSingleRegistry.class)
                .add(Restrictions.eq("bib", bib))
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .uniqueResult();
        return Optional.ofNullable(eventSingleRegistry);
    }

    @Override
    public Optional<SingleRace> findSingleRaceWithEventSingleRegistry(EventSingleRegistry eventSingleRegistry, SubEvent subEvent) {
        SingleRace singleRace = (SingleRace) session()
                .createCriteria(SingleRace.class)
                .add(Restrictions.eq("eventSingleRegistry", eventSingleRegistry))
                .add(Restrictions.eq("subEvent",subEvent))
                .uniqueResult();
        return Optional.ofNullable(singleRace);
    }

    @Override
    public boolean updateSingleRace(SingleRace singleRace) {
        session().update(singleRace);
        return true;
    }

    @Override
    public boolean deleteSingleRace(SingleRace singleRace) {
        session().delete(singleRace);
        return true;
    }


}
