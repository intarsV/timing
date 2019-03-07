package lv.timing.database;

import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.CompetitionFormat;

import java.util.List;
import java.util.Optional;

public interface CompetitionEventRepository {
    List<CompetitionEvent> eventList();

    List<CompetitionFormat> competitionFormat();

    Optional<CompetitionEvent> findEventByName(String eventName);

    void addEvent(CompetitionEvent competitionEvent);

    boolean updateEvent(CompetitionEvent competitionEvent);
}
