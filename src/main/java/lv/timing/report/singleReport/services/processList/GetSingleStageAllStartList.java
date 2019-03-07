package lv.timing.report.singleReport.services.processList;

import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SingleBoatClass;
import lv.timing.domain.SubEvent;
import lv.timing.domain.reportDomain.single.RaceResultList;
import lv.timing.report.singleReport.services.processBoatClass.ProcessResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetSingleStageAllStartList {

    @Autowired
    private ProcessResultsService process;

    public List<RaceResultList> execute(CompetitionEvent event, SubEvent subEvent) {
        List<RaceResultList> filteredC1Woman = getC1Woman(event, subEvent);
        List<RaceResultList> filteredC1Man = getC1Man(event, subEvent);
        List<RaceResultList> filteredK1Woman = getK1Woman(event, subEvent);
        List<RaceResultList> filteredK1Man = getK1Man(event, subEvent);
        List<RaceResultList> merged = new ArrayList<>();
        merged.addAll(filteredC1Woman);
        merged.addAll(filteredC1Man);
        merged.addAll(filteredK1Woman);
        merged.addAll(filteredK1Man);
        return merged;
    }

    private List<RaceResultList> getC1Woman(CompetitionEvent event, SubEvent subEvent) {
        SingleBoatClass boatClass = new SingleBoatClass();
        boatClass.setId(new Long(1));
        List<RaceResultList> list = process.process(event, boatClass);
        List<RaceResultList> filtered = GetSingleStageAndClassStartList.execute(list, event, subEvent);
        return filtered;
    }

    private List<RaceResultList> getC1Man(CompetitionEvent event, SubEvent subEvent) {
        SingleBoatClass boatClass = new SingleBoatClass();
        boatClass.setId(new Long(2));
        List<RaceResultList> list = process.process(event, boatClass);
        List<RaceResultList> filtered = GetSingleStageAndClassStartList.execute(list, event, subEvent);
        return filtered;
    }

    private List<RaceResultList> getK1Woman(CompetitionEvent event, SubEvent subEvent) {
        SingleBoatClass boatClass = new SingleBoatClass();
        boatClass.setId(new Long(3));
        List<RaceResultList> list = process.process(event, boatClass);
        List<RaceResultList> filtered = GetSingleStageAndClassStartList.execute(list, event, subEvent);
        return filtered;
    }

    private List<RaceResultList> getK1Man(CompetitionEvent event, SubEvent subEvent) {
        SingleBoatClass boatClass = new SingleBoatClass();
        boatClass.setId(new Long(4));
        List<RaceResultList> list = process.process(event, boatClass);
        List<RaceResultList> filtered = GetSingleStageAndClassStartList.execute(list, event, subEvent);
        return filtered;
    }
}
