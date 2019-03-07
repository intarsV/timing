package lv.timing.competitors.validation.rules;

import lv.timing.Error;
import lv.timing.database.CompetitorRepository;
import lv.timing.domain.Competitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DuplicateNameRule {

    @Autowired
    private CompetitorRepository database;

    public Optional<Error> execute(List valueList) {
        String searchName=valueList.get(0).toString();

        if (searchName != null) {
            Optional<Competitor> findCompetitor = database.findCompetitorByName(searchName);
            if (findCompetitor.isPresent()) {
                Error error = new Error( "Duplicate competitor  exists");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }
}
