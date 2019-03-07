package lv.timing.report.singleReport.services;

import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SingleBoatClass;
import lv.timing.domain.reportDomain.single.RaceResultList;
import lv.timing.genericServices.GetObjectFromCBoxEvent;
import lv.timing.genericServices.GetObjectFromCBoxSingleBoatClass;
import lv.timing.report.singleReport.SingleRaceReportView;
import lv.timing.report.singleReport.services.processBoatClass.ProcessResultsService;
import lv.timing.report.singleReport.services.processList.GetGrandTotalClassListService;
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
            }else{
                //for all boat classes
            }
        }
    }
}
