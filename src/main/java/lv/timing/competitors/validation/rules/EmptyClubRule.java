package lv.timing.competitors.validation.rules;

import lv.timing.Error;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class EmptyClubRule {
    public Optional<Error> execute(List valueList) {

        if (valueList.get(2) == null || valueList.get(2).toString().isEmpty()) {
            Error error = new Error( "Competitor club field is empty");
            return Optional.of(error);
        } else {
            return Optional.empty();
        }
    }
}
