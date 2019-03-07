package lv.timing.report.singleReport.services;

import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SingleBoatClass;
import lv.timing.domain.SubEvent;
import lv.timing.domain.reportDomain.single.RaceResultList;
import lv.timing.domain.reportDomain.single.SingleRaceStageList;
import lv.timing.genericServices.GetObjectFromCBoxEvent;
import lv.timing.genericServices.GetObjectFromCBoxSingleBoatClass;
import lv.timing.genericServices.GetObjectFromCBoxSubEvent;
import lv.timing.report.singleReport.SingleRaceReportView;
import lv.timing.report.singleReport.services.jasperFrame.CreateResultFrame;
import lv.timing.report.singleReport.services.processBoatClass.ProcessStageBoatClassList;
import lv.timing.report.singleReport.services.processBoatClass.ProcessResultsService;
import lv.timing.report.singleReport.services.processList.GetSingleStageAndClassStartList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreviewStageResultsService {

    @Autowired
    private ProcessResultsService processResultsService;

    @Autowired
    private SingleRaceReportView view;


    public void execute() {
        int eventIndex=view.getComboBoxEvent().getSelectedIndex();
        int subEventIndex=view.getComboBoxSubEvent().getSelectedIndex();
        int boatClassIndex=view.getComboBoxClass().getSelectedIndex();

        if (eventIndex>0 && subEventIndex>0 && boatClassIndex>0) {

            CompetitionEvent event = GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent());
            SingleBoatClass boatClass = GetObjectFromCBoxSingleBoatClass.getObject(view.getComboBoxClass());
            SubEvent subEvent = GetObjectFromCBoxSubEvent.getObject(view.getComboBoxSubEvent());
            List<RaceResultList> list = processResultsService.process(event, boatClass);
            //print(list);
            List<RaceResultList> filtered = GetSingleStageAndClassStartList.execute(list, event, subEvent);

            List<SingleRaceStageList> sorted = ProcessStageBoatClassList.prepareList(filtered, subEvent).stream()
                    .sorted(Comparator.comparing(SingleRaceStageList::getTotal))
                    .collect(Collectors.toList());

            CreateResultFrame.previewList(sorted);
        } else {
            JOptionPane.showMessageDialog(null, "Select event, subEvent and boatClass");
        }
    }


}
