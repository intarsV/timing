package lv.initex.database;

import lv.initex.domain.*;

import java.util.List;

public interface GenericServicesRepository {

    List<CompetitionEvent> eventList();

    List<SubEvent> subEventList(CompetitionEvent competitionEvent);

    List<Group> groupsList();

    List<SingleBoatClass> singleBoatClassList();

    List<TeamBoatClass> teamBoatClassList();

    List<Competitor> competitorList();
}
