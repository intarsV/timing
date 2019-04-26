package lv.initex.competitors.validation;

import lv.initex.Error;

import java.util.List;

public interface CompetitorValidator {
    List<Error> validate(List valueList);
}
