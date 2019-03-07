package lv.timing.eventRegistry.singleRegistry.validation;



import lv.timing.Error;

import java.util.List;

public interface EventSingleRegistryInsertValidator {

    List<Error> validate(List valueList);
}
