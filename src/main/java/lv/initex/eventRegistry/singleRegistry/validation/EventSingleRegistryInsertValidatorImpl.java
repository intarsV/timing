package lv.initex.eventRegistry.singleRegistry.validation;


import lv.initex.Error;
import lv.initex.eventRegistry.singleRegistry.validation.rules.InsertActionDuplicateBibRule;
import lv.initex.eventRegistry.singleRegistry.validation.rules.InsertActionDuplicateCompetitorInClassRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventSingleRegistryInsertValidatorImpl implements EventSingleRegistryInsertValidator {

    @Autowired
    private InsertActionDuplicateBibRule duplicateBibRule;

    @Autowired
    private InsertActionDuplicateCompetitorInClassRule duplicateCompetitorInClassRule;

    @Override
    public List<Error> validate(List valueList) {
        List<Error> errors = new ArrayList<>();
        duplicateCompetitorInClassRule.execute(valueList).ifPresent(errors::add);
        duplicateBibRule.execute(valueList).ifPresent(errors::add);
        return errors;
    }
}
