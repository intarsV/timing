package lv.timing.report.singleReport.services;


import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SingleBoatClass;
import lv.timing.domain.SubEvent;
import lv.timing.domain.reportDomain.single.RaceResultList;
import lv.timing.genericServices.GetObjectFromCBoxEvent;
import lv.timing.genericServices.GetObjectFromCBoxSingleBoatClass;
import lv.timing.genericServices.GetObjectFromCBoxSubEvent;
import lv.timing.report.singleReport.SingleRaceReportView;
import lv.timing.report.singleReport.services.jasperFrame.CreateAllStartListFrame;
import lv.timing.report.singleReport.services.processBoatClass.convert.ConvertToResultList;
import lv.timing.report.singleReport.services.processBoatClass.ProcessResultsService;
import lv.timing.report.singleReport.services.processList.GetInitialAllListService;
import lv.timing.report.singleReport.services.processList.GetInitialClassListService;
import lv.timing.report.singleReport.services.processList.GetSingleStageAllStartList;
import lv.timing.report.singleReport.services.processList.GetSingleStageAndClassStartList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreviewStartListService {

    @Autowired
    private SingleRaceReportView view;

    @Autowired
    private GetInitialClassListService getInitialClassListService;

    @Autowired
    private GetInitialAllListService getInitialAllListService;

    @Autowired
    private GetSingleStageAllStartList getSingleStageAllStartList;

    @Autowired
    private ProcessResultsService process;


    public void execute() {

        int eventIndex=view.getComboBoxEvent().getSelectedIndex();

        if (eventIndex>0 ) {

        CompetitionEvent event = GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent());
        SingleBoatClass boatClass = GetObjectFromCBoxSingleBoatClass.getObject(view.getComboBoxClass());
        SubEvent subEvent = GetObjectFromCBoxSubEvent.getObject(view.getComboBoxSubEvent());

        if (view.getComboBoxClass().getSelectedIndex() > 0) {
            if (view.getComboBoxSubEvent().getSelectedIndex() > 1) {
                //process start list for current boat class && current stage OK
                List<RaceResultList> list = process.process(event, boatClass);
                List<RaceResultList> filtered = GetSingleStageAndClassStartList.execute(list, event, subEvent);
                CreateAllStartListFrame.previewList(filtered,subEvent);
            } else {
                //process initial start list for current boat class OK
                List<RaceResultList> list = ConvertToResultList.convert(getInitialClassListService.getInitialList(event, boatClass)).stream()
                        .sorted(Comparator.comparing(RaceResultList::getBib).reversed())
                        .collect(Collectors.toList());
                CreateAllStartListFrame.previewList(list,subEvent);
            }
        } else if (view.getComboBoxSubEvent().getSelectedIndex() > 1) {
            //process initial start list for all boat classes current stage
            List<RaceResultList> filtered=getSingleStageAllStartList.execute(event, subEvent);
            CreateAllStartListFrame.previewList(filtered,subEvent);

        } else {
            //process initial start list for all boat classes  OK
            List<RaceResultList> list = ConvertToResultList.convert(getInitialAllListService.getInitialList(event)).stream()
                    .sorted(Comparator.comparing(RaceResultList::getBib).reversed())
                    .collect(Collectors.toList());
            CreateAllStartListFrame.previewList(list,subEvent);
        }
    }else{
            JOptionPane.showMessageDialog(null, "Select event");
        }
    }


    public void print(List<RaceResultList> list) {
        System.out.println(list.get(0).getEventSingleRegistry().getCompetitor().getCompetitorName() + list.get(0).isHeatOneQualified());
    }
}