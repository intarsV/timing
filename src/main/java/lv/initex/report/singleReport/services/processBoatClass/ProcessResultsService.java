package lv.initex.report.singleReport.services.processBoatClass;

import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.EventSingleRegistry;
import lv.initex.domain.SingleBoatClass;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.report.singleReport.services.processBoatClass.claclulations.RankList;
import lv.initex.report.singleReport.services.processBoatClass.claclulations.SetQualified;
import lv.initex.report.singleReport.services.processBoatClass.convert.ConvertToResultList;
import lv.initex.report.singleReport.services.processList.GetInitialClassListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessResultsService {

    @Autowired
    private GetInitialClassListService getInitialClassListService;

    @Autowired
    private SetQualified setQualified;

    public List<RaceResultList> process(CompetitionEvent competitionEvent, SingleBoatClass boatClass) {

        List<EventSingleRegistry> initialList = getInitialClassListService.getInitialList(competitionEvent, boatClass);

        List<RaceResultList> list = ConvertToResultList.convert(initialList);

        ProcessBestOrSum.execute(list, competitionEvent);

        RankList.rank(list);

        setQualified.setQualified(list, competitionEvent, boatClass);

        return list;
    }
}
