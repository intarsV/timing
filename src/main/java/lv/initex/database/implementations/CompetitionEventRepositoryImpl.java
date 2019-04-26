package lv.initex.database.implementations;

import lv.initex.database.CompetitionEventRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.CompetitionFormat;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class CompetitionEventRepositoryImpl extends Repository implements CompetitionEventRepository {

    @Override
    public List<CompetitionEvent> eventList() {
        return session()
                .createCriteria(CompetitionEvent.class)
                .add(Restrictions.eq("deleted", false))
                .list();
    }

    @Override
    public List<CompetitionFormat> competitionFormat() {
        return session()
                .createCriteria(CompetitionFormat.class)
                .list();
    }

    @Override
    public Optional<CompetitionEvent> findEventByName(String eventName) {
        CompetitionEvent competitionEvent = (CompetitionEvent) session()
                .createCriteria(CompetitionEvent.class)
                .add(Restrictions.eq("eventName", eventName))
                .uniqueResult();
        return Optional.ofNullable(competitionEvent);
    }

    @Override
    public void addEvent(CompetitionEvent competitionEvent) {
        session().save(competitionEvent);
    }

    @Override
    public boolean updateEvent(CompetitionEvent competitionEvent) {
        session().update(competitionEvent);
        return true;
    }

}
