package lv.initex.competitors.validation;

import lv.initex.Error;
import lv.initex.competitors.validation.rules.*;
import lv.initex.database.CompetitorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CompetitorValidatorImpl implements CompetitorValidator {

    private DuplicateNameRule duplicateNameRule = new DuplicateNameRule();
    private EmptyNameRule emptyNameRule = new EmptyNameRule();
    private EmptyBirthYearRule emptyBirthYearRule = new EmptyBirthYearRule();
    private EmptyClubRule emptyClubRule = new EmptyClubRule();
    private EmptyCountryRule emptyCountryRule = new EmptyCountryRule();

    @Override
    public List<Error> validate(List valueList, CompetitorRepository database) {
        List<Error> errors = new ArrayList<>();
        duplicateNameRule.execute(valueList, database).ifPresent(errors::add);
        emptyNameRule.execute(valueList).ifPresent(errors::add);
        emptyBirthYearRule.execute(valueList).ifPresent(errors::add);
        emptyClubRule.execute(valueList).ifPresent(errors::add);
        emptyCountryRule.execute(valueList).ifPresent(errors::add);
        return errors;
    }
}
