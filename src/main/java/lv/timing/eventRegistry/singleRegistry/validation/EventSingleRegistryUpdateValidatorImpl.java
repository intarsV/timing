package lv.timing.eventRegistry.singleRegistry.validation;

import lv.timing.Error;
import lv.timing.domain.EventSingleRegistry;
import lv.timing.eventRegistry.singleRegistry.validation.rules.UpdateActionDuplicateCompetitorInClassRule;
import lv.timing.eventRegistry.singleRegistry.validation.rules.UpdateActionduplicateBibRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventSingleRegistryUpdateValidatorImpl implements EventSingleRegistryUpdateValidator {

    @Autowired
    private UpdateActionduplicateBibRule updateActionduplicateBibRule;

    @Autowired
    private UpdateActionDuplicateCompetitorInClassRule updateActionDuplicateCompetitorInClassRule;

    @Override
    public List<Error> validate(EventSingleRegistry eventSingleRegistry) {
        List<Error> errors = new ArrayList<>();

        updateActionduplicateBibRule.execute(eventSingleRegistry).ifPresent(errors::add);
        updateActionDuplicateCompetitorInClassRule.execute(eventSingleRegistry).ifPresent(errors::add);
        return errors;
    }
}
