package lv.timing.database.implementations;

import lv.timing.database.CompetitorRepository;
import lv.timing.domain.Competitor;
import lv.timing.domain.Country;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class CompetitorRepositoryImpl extends Repository implements CompetitorRepository {
    @Override
    public List<Competitor> competitorList() {
        return session()
                .createCriteria(Competitor.class)
                .add(Restrictions.eq("deleted", false))
                .addOrder(Order.asc("competitorName"))
                .list();
    }

    @Override
    public List<Country> countryList() {
        return session()
                .createCriteria(Country.class)
                .list();
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
    public void addCompetitor(Competitor competitor) {
        session().save(competitor);
    }

    @Override
    public boolean updateCompetitor(Competitor competitor) {
        session().update(competitor);
        return true;
    }
}
