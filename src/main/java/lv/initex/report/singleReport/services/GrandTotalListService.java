package lv.initex.report.singleReport.services;

import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.SingleBoatClass;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.genericServices.GetObjectFromCBoxEvent;
import lv.initex.genericServices.GetObjectFromCBoxSingleBoatClass;
import lv.initex.report.singleReport.SingleRaceReportView;
import lv.initex.report.singleReport.services.processBoatClass.ProcessResultsService;
import lv.initex.report.singleReport.services.processList.GetGrandTotalClassListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrandTotalListService {

    @Autowired
    private ProcessResultsService processResultsService;

    @Autowired
    private SingleRaceReportView view;

    public void execute() {

        int eventIndex = view.getComboBoxEvent().getSelectedIndex();
        int boatClassIndex = view.getComboBoxClass().getSelectedIndex();

        if (eventIndex > 0) {
            CompetitionEvent event = GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent());
            SingleBoatClass boatClass = GetObjectFromCBoxSingleBoatClass.getObject(view.getComboBoxClass());
            if (boatClassIndex > 0) {
                //for single boat class
                List<RaceResultList> list = processResultsService.process(event, boatClass);
                GetGrandTotalClassListService.process(list, event);
            } else {
                //for all boat classes
            }
        }
    }
}
