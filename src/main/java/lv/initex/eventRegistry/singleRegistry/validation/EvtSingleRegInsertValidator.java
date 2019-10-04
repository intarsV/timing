package lv.initex.eventRegistry.singleRegistry.validation;


import lv.initex.Error;
import lv.initex.database.SingleEventRegistryRepository;

import java.util.List;

public interface EvtSingleRegInsertValidator {

    List<Error> validate(List valueList, SingleEventRegistryRepository database);
}
