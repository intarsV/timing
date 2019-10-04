package lv.initex.competitors.validation.rules;

import lv.initex.Error;
import lv.initex.database.CompetitorRepository;
import lv.initex.domain.Competitor;

import java.util.List;
import java.util.Optional;


public class DuplicateNameRule {

    public Optional<Error> execute(List valueList, CompetitorRepository database) {
        String searchName = valueList.get(0).toString();

        if (searchName != null) {
            Optional<Competitor> findCompetitor = database.findCompetitorByName(searchName);
            if (findCompetitor.isPresent()) {
                Error error = new Error("Duplicate competitor  exists");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}
