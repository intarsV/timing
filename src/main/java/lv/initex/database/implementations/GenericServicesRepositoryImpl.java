package lv.initex.database.implementations;

import lv.initex.database.GenericServicesRepository;
import lv.initex.domain.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GenericServicesRepositoryImpl extends Repository implements GenericServicesRepository {

    @Override
    public List<CompetitionEvent> eventList() {
        return session()
                .createCriteria(CompetitionEvent.class)
                .add(Restrictions.eq("deleted", false))
                .list();
    }

    @Override
    public List<SubEvent> subEventList(CompetitionEvent competitionEvent) {
        return session()
                .createCriteria(SubEvent.class)
                .add(Restrictions.eq("eventFormat", competitionEvent.getEventFormat()))
                .list();
    }

    @Override
    public List<Group> groupsList() {
        return session()
                .createCriteria(Group.class)
                .add(Restrictions.eq("deleted", false))
                .list();
    }

    @Override
    public List<SingleBoatClass> singleBoatClassList() {
        return session()
                .createCriteria(SingleBoatClass.class)
                .list();
    }

    @Override
    public List<TeamBoatClass> teamBoatClassList() {
        return session()
                .createCriteria(TeamBoatClass.class)
                .list();
    }

    @Override
    public List<Competitor> competitorList() {
        return session()
                .createCriteria(Competitor.class)
                .add(Restrictions.eq("deleted", false))
                .addOrder(Order.asc("competitorName"))
                .list();
    }
}
