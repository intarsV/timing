package lv.timing.database.implementations;

import lv.timing.database.TeamEventRegistryRepository;
import lv.timing.domain.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class TeamEventRegistryRepositoryImpl extends Repository implements TeamEventRegistryRepository {

    @Override
    public List<EventTeamRegistry> registryList(CompetitionEvent competitionEvent) {
        return session()
                .createCriteria(EventTeamRegistry.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .addOrder(Order.asc("bib"))
                .list();
    }

    @Override
    public List<EventTeamRegistry> registryListByEventAndBoatClass(CompetitionEvent competitionEvent, TeamBoatClass boatClass) {
        return session()
                .createCriteria(EventTeamRegistry.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .add(Restrictions.eq("teamBoatClass", boatClass))
                .list();
    }

    @Override
    public boolean deleteEventTeamRaceRegistry(EventTeamRegistry eventTeamRegistry) {
        session().delete(eventTeamRegistry);
        return true;
    }

    @Override
    public Optional<EventTeamRegistry> findTeamRaceRegistryByID(Long id) {
        EventTeamRegistry eventTeamRegistry = (EventTeamRegistry) session()
                .createCriteria(EventTeamRegistry.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(eventTeamRegistry);
    }

    @Override
    public Optional<EventTeamRegistry> findTeamRaceRegistryByBib(CompetitionEvent competitionEvent, int bib) {
        EventTeamRegistry teamRaceRegistry = (EventTeamRegistry) session()
                .createCriteria(EventTeamRegistry.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .add(Restrictions.eq("bib", bib))
                .uniqueResult();
        return Optional.ofNullable(teamRaceRegistry);
    }

    @Override
    public Optional<EventTeamRegistry> findTeamRaceRegistryByIdEventBib(Long id, CompetitionEvent competitionEvent, int bib) {
        EventTeamRegistry teamRaceRegistry = (EventTeamRegistry) session()
                .createCriteria(EventTeamRegistry.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .add(Restrictions.eq("bib", bib))
                .add(Restrictions.ne("id", id))
                .uniqueResult();
        return Optional.ofNullable(teamRaceRegistry);
    }

    @Override
    public Optional<EventTeamRegistry> findTeamRaceRegistryByEventClassCompetitor(CompetitionEvent competitionEvent, Competitor competitor, SingleBoatClass singleBoatClass) {
        EventTeamRegistry teamRaceRegistry = (EventTeamRegistry) session()
                .createCriteria(EventSingleRegistry.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .add(Restrictions.eq("competitor", competitor))
                .add(Restrictions.eq("singleBoatClass", singleBoatClass))
                .uniqueResult();
        return Optional.ofNullable(teamRaceRegistry);
    }

    @Override
    public Optional<EventTeamRegistry> updateFindTeamRaceRegistryByEventClassCompetitor(Long id, CompetitionEvent competitionEvent, Competitor competitor, SingleBoatClass singleBoatClass) {
        EventTeamRegistry teamRaceRegistry = (EventTeamRegistry) session()
                .createCriteria(EventTeamRegistry.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .add(Restrictions.eq("competitor", competitor))
                .add(Restrictions.eq("singleBoatClass", singleBoatClass))
                .add(Restrictions.ne("id", id))
                .uniqueResult();
        return Optional.ofNullable(teamRaceRegistry);
    }

    @Override
    public Optional<CompetitionEvent> findEventByName(String eventName) {
        CompetitionEvent competitionEvent = (CompetitionEvent) session()
                .createCriteria(CompetitionEvent.class)
                .add(Restrictions.eq("competitionEvent", eventName))
                .add(Restrictions.eq("deleted", false))
                .uniqueResult();
        return Optional.ofNullable(competitionEvent);
    }

    @Override
    public Optional<SingleBoatClass> findBoatClassByName(String boatClassName) {
        SingleBoatClass singleBoatClass = (SingleBoatClass) session()
                .createCriteria(SingleBoatClass.class)
                .add(Restrictions.eq("singleBoatClass", boatClassName))
                .add(Restrictions.eq("deleted", false))
                .uniqueResult();
        return Optional.ofNullable(singleBoatClass);
    }

    @Override
    public Optional<Competitor> findCompetitorByName(String competitorName) {
        Competitor competitor = (Competitor) session()
                .createCriteria(Competitor.class)
                .add(Restrictions.eq("competitorName", competitorName))
                .add(Restrictions.eq("deleted", false))
                .uniqueResult();
        return Optional.ofNullable(competitor);
    }

    @Override
    public void saveEventTeamRegistry(EventTeamRegistry teamRaceRegistry) {
        session().save(teamRaceRegistry);
    }

    @Override
    public boolean updateEventTeamRegistry(EventTeamRegistry teamRaceRegistry) {
        session().update(teamRaceRegistry);
        return true;
    }


}
