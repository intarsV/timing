package lv.initex.competitors.validation.rules;

import lv.initex.Error;

import java.util.List;
import java.util.Optional;

public class EmptyClubRule {
    public Optional<Error> execute(List valueList) {

        if (valueList.get(2) == null || valueList.get(2).toString().isEmpty()) {
            Error error = new Error("Competitor club field is empty");
            return Optional.of(error);
        } else {
            return Optional.empty();
        }
    }
}
