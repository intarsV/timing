package lv.timing.eventRegistry.singleRegistry.validation;

import lv.timing.Error;
import lv.timing.domain.EventSingleRegistry;

import java.util.List;

public interface EventSingleRegistryUpdateValidator {

    List<Error> validate(EventSingleRegistry eventSingleRegistry);
}
