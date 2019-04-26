package lv.initex.competitors.validation.rules;

import lv.initex.Error;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmptyNameRule {
    public Optional<Error> execute(List valueList) {

        if (valueList.get(0) == null || valueList.get(0).toString().isEmpty()) {
            Error error = new Error( "Competitor name field is empty");
            return Optional.of(error);
        } else {
            return Optional.empty();
        }
    }
}
