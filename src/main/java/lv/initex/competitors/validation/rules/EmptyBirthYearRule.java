package lv.initex.competitors.validation.rules;

import lv.initex.Error;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmptyBirthYearRule {
    public Optional<Error> execute(List valueList) {

        if (valueList.get(1).toString() == null
                || valueList.get(1).toString().isEmpty()
                || valueList.get(1).toString().equals(" ")
                || Integer.parseInt(valueList.get(1).toString()) == 0) {
            Error error = new Error("Competitor birth year field is empty");
            return Optional.of(error);
        } else {
            return Optional.empty();
        }
    }
}
