package lv.timing.database;

import lv.timing.domain.Competitor;
import lv.timing.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CompetitorRepository {

    List<Competitor> competitorList();

    List<Country> countryList();

    void addCompetitor(Competitor competitor);

    boolean updateCompetitor(Competitor competitor);

    Optional<Competitor> findCompetitorByName(String competitorName);
}
