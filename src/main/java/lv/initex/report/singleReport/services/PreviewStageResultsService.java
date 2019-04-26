package lv.initex.report.singleReport.services;

import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.SingleBoatClass;
import lv.initex.domain.SubEvent;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.domain.reportDomain.single.SingleRaceStageList;
import lv.initex.genericServices.GetObjectFromCBoxEvent;
import lv.initex.genericServices.GetObjectFromCBoxSingleBoatClass;
import lv.initex.genericServices.GetObjectFromCBoxSubEvent;
import lv.initex.report.singleReport.SingleRaceReportView;
import lv.initex.report.singleReport.services.jasperFrame.CreateResultFrame;
import lv.initex.report.singleReport.services.processBoatClass.ProcessStageBoatClassList;
import lv.initex.report.singleReport.services.processBoatClass.ProcessResultsService;
import lv.initex.report.singleReport.services.processList.GetSingleStageAndClassStartList;
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
