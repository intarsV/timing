package lv.initex.eventRegistry.singleRegistry.validation;

import lv.initex.Error;
import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.domain.EventSingleRegistry;
import lv.initex.eventRegistry.singleRegistry.validation.rules.UpdateDuplicateCompetitorInClassRule;
import lv.initex.eventRegistry.singleRegistry.validation.rules.UpdateDuplicateBibRule;

import java.util.ArrayList;
import java.util.List;


public class EventSingleRegistryUpdateValidatorImpl implements EventSingleRegistryUpdateValidator {


    private UpdateDuplicateBibRule updateDuplicateBibRule =new UpdateDuplicateBibRule();


    private UpdateDuplicateCompetitorInClassRule updateDuplicateCompetitorInClassRule =new UpdateDuplicateCompetitorInClassRule();

    @Override
    public List<Error> validate(EventSingleRegistry eventSingleRegistry, SingleEventRegistryRepository database) {
        List<Error> errors = new ArrayList<>();

        updateDuplicateBibRule.execute(eventSingleRegistry,database).ifPresent(errors::add);
        updateDuplicateCompetitorInClassRule.execute(eventSingleRegistry, database).ifPresent(errors::add);
        return errors;
    }
}
