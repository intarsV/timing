package lv.initex.database.implementations;

import lv.initex.database.TeamRaceRepository;
import lv.initex.domain.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class TeamRaceRepositoryImpl extends Repository implements TeamRaceRepository {

    @Override
    public List<TeamRace> teamRaceListDone(CompetitionEvent competitionEvent, SubEvent subEvent) {
        return session()
                .createCriteria(TeamRace.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .add(Restrictions.eq("subEvent", subEvent))
                .add(Restrictions.eq("done", true))
                .list();
    }

    @Override
    public List<TeamRace> teamRaceListNotDone(CompetitionEvent competitionEvent, SubEvent subEvent) {
        return session()
                .createCriteria(TeamRace.class)
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .add(Restrictions.eq("subEvent", subEvent))
                .add(Restrictions.eq("done", false))
                .list();
    }

    @Override
    public void saveTeamRace(TeamRace teamRace) {
        session().save(teamRace);
    }

    @Override
    public Optional<EventTeamRegistry> findEventTeamRegistry(int bib, CompetitionEvent competitionEvent) {
        EventTeamRegistry eventTeamRegistry = (EventTeamRegistry) session()
                .createCriteria(EventTeamRegistry.class)
                .add(Restrictions.eq("bib", bib))
                .add(Restrictions.eq("competitionEvent", competitionEvent))
                .uniqueResult();
        return Optional.ofNullable(eventTeamRegistry);
    }

    @Override
    public Optional<TeamRace> findTeamRaceWithEventTeamRegistry(EventTeamRegistry eventTeamRegistry) {
        TeamRace teamRace = (TeamRace) session()
                .createCriteria(TeamRace.class)
                .add(Restrictions.eq("eventTeamRegistry", eventTeamRegistry))
                .uniqueResult();
        return Optional.ofNullable(teamRace);
    }

    @Override
    public Optional<TeamRace> findTeamRaceById(Long id) {
        TeamRace teamRace = (TeamRace) session()
                .createCriteria(TeamRace.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(teamRace);
    }

    @Override
    public boolean updateTeamRace(TeamRace teamRace) {
        session().update(teamRace);
        return true;
    }

    @Override
    public boolean deleteTeamRace(TeamRace teamRace) {
        session().delete(teamRace);
        return true;
    }


}
