package lv.initex.eventRegistry.singleRegistry.validation;

import lv.initex.Error;
import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.eventRegistry.singleRegistry.validation.rules.InsertActDuplicateBibRule;
import lv.initex.eventRegistry.singleRegistry.validation.rules.InsertActDuplicateCompetitorInClassRule;

import java.util.ArrayList;
import java.util.List;

public class EvtSingleRegInsertValidatorImpl implements EvtSingleRegInsertValidator {


    private InsertActDuplicateBibRule duplicateBibRule = new InsertActDuplicateBibRule();

    private InsertActDuplicateCompetitorInClassRule duplicateCompetitorInClassRule = new InsertActDuplicateCompetitorInClassRule();

    @Override
    public List<Error> validate(List valueList, SingleEventRegistryRepository database) {
        List<Error> errors = new ArrayList<>();
        duplicateCompetitorInClassRule.execute(valueList, database).ifPresent(errors::add);
        duplicateBibRule.execute(valueList, database).ifPresent(errors::add);
        return errors;
    }
}
