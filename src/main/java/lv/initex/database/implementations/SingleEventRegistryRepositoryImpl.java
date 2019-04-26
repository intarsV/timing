package lv.initex.database.implementations;

import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.domain.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class SingleEventRegistryRepositoryImpl extends Repository implements SingleEventRegistryRepository {

    @Override
    public List<EventSingleRegistry> registryList(CompetitionEvent competitionEvent) {
        return session()
                .createCriteria(EventSingleRegistry.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .addOrder(Order.asc("bib"))
                .list();
    }

    @Override
    public List<EventSingleRegistry> registryListByEventAndBoatClass(CompetitionEvent competitionEvent, SingleBoatClass boatClass) {
        return session()
                .createCriteria(EventSingleRegistry.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .add(Restrictions.eq("singleBoatClass", boatClass))
                .list();
    }

    @Override
    public boolean deleteEventSingleRaceRegistry(EventSingleRegistry eventSingleRegistry) {
        session().delete(eventSingleRegistry);
        return true;
    }

    @Override
    public Optional<EventSingleRegistry> findSingleRaceRegistryByID(Long id) {
        EventSingleRegistry eventSingleRegistry = (EventSingleRegistry) session()
                .createCriteria(EventSingleRegistry.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(eventSingleRegistry);
    }

    @Override
    public Optional<EventSingleRegistry> findSingleRaceRegistryByBib(CompetitionEvent competitionEvent, int bib) {
        EventSingleRegistry eventSingleRegistry = (EventSingleRegistry) session()
                .createCriteria(EventSingleRegistry.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .add(Restrictions.eq("bib", bib))
                .uniqueResult();
        return Optional.ofNullable(eventSingleRegistry);
    }

    @Override
    public Optional<EventSingleRegistry> findSingleRaceRegistryByIdEventBib(Long id, CompetitionEvent competitionEvent, int bib) {
        EventSingleRegistry eventSingleRegistry = (EventSingleRegistry) session()
                .createCriteria(EventSingleRegistry.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .add(Restrictions.eq("bib", bib))
                .add(Restrictions.ne("id", id))
                .uniqueResult();
        return Optional.ofNullable(eventSingleRegistry);
    }

    @Override
    public Optional<EventSingleRegistry> findSingleRaceRegistryByEventClassCompetitor(CompetitionEvent competitionEvent, Competitor competitor, SingleBoatClass singleBoatClass) {
        EventSingleRegistry eventSingleRegistry = (EventSingleRegistry) session()
                .createCriteria(EventSingleRegistry.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .add(Restrictions.eq("competitor", competitor))
                .add(Restrictions.eq("singleBoatClass", singleBoatClass))
                .uniqueResult();
        return Optional.ofNullable(eventSingleRegistry);
    }

    @Override
    public Optional<EventSingleRegistry> updateFindSingleRaceRegistryByEventClassCompetitor(Long id, CompetitionEvent competitionEvent, Competitor competitor, SingleBoatClass singleBoatClass) {
        EventSingleRegistry eventSingleRegistry = (EventSingleRegistry) session()
                .createCriteria(EventSingleRegistry.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .add(Restrictions.eq("competitor", competitor))
                .add(Restrictions.eq("singleBoatClass", singleBoatClass))
                .add(Restrictions.ne("id", id))
                .uniqueResult();
        return Optional.ofNullable(eventSingleRegistry);
    }

    @Override
    public void saveEventSingleRegistry(EventSingleRegistry singleRaceRegistry) {
        session().save(singleRaceRegistry);
    }

    @Override
    public boolean updateEventSingleRegistry(EventSingleRegistry singleRaceRegistry) {
        session().update(singleRaceRegistry);
        return true;
    }
}
