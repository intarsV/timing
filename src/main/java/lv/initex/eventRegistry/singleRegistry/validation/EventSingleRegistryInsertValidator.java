package lv.initex.eventRegistry.singleRegistry.validation;



import lv.initex.Error;

import java.util.List;

public interface EventSingleRegistryInsertValidator {

    List<Error> validate(List valueList);
}
