package lv.timing.competitors.validation;

import lv.timing.Error;

import java.util.List;

public interface CompetitorValidator {
    List<Error> validate(List valueList);
}
