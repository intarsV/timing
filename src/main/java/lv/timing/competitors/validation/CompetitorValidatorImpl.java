package lv.timing.competitors.validation;

import lv.timing.Error;
import lv.timing.competitors.validation.rules.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompetitorValidatorImpl implements CompetitorValidator{

    @Autowired
    private DuplicateNameRule duplicateNameRule;

    @Autowired
    private EmptyNameRule emptyNameRule;

    @Autowired
    private EmptyBirthYearRule emptyBirthYearRule;

    @Autowired
    private EmptyClubRule emptyClubRule;

    @Autowired
    private EmptyCountryRule emptyCountryRule;

    @Override
    public List<Error> validate(List valueList) {
        List<Error> errors = new ArrayList<>();
        duplicateNameRule.execute(valueList).ifPresent(errors::add);
        emptyNameRule.execute(valueList).ifPresent(errors::add);
        emptyBirthYearRule.execute(valueList).ifPresent(errors::add);
        emptyClubRule.execute(valueList).ifPresent(errors::add);
        emptyCountryRule.execute(valueList).ifPresent(errors::add);

        return errors;
    }
}
