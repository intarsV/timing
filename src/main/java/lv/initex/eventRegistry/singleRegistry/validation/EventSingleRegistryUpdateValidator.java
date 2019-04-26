package lv.initex.eventRegistry.singleRegistry.validation;

import lv.initex.Error;
import lv.initex.domain.EventSingleRegistry;

import java.util.List;

public interface EventSingleRegistryUpdateValidator {

    List<Error> validate(EventSingleRegistry eventSingleRegistry);
}
