package lv.initex.competitors.validation.rules;

import lv.initex.Error;

import java.util.List;
import java.util.Optional;

public class EmptyCountryRule {
    public Optional<Error> execute(List valueList) {

        if (valueList.get(3).toString() == null
                || valueList.get(3).toString().isEmpty()
                || valueList.get(3).toString().equals("")) {
            Error error = new Error("Competitor country field is empty");
            return Optional.of(error);
        } else {
            return Optional.empty();
        }
    }
}
