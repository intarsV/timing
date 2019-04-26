package lv.initex.report.singleReport.services;


import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.SingleBoatClass;
import lv.initex.domain.SubEvent;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.genericServices.GetObjectFromCBoxEvent;
import lv.initex.genericServices.GetObjectFromCBoxSingleBoatClass;
import lv.initex.genericServices.GetObjectFromCBoxSubEvent;
import lv.initex.report.singleReport.SingleRaceReportView;
import lv.initex.report.singleReport.services.jasperFrame.CreateAllStartListFrame;
import lv.initex.report.singleReport.services.processBoatClass.ProcessResultsService;
import lv.initex.report.singleReport.services.processBoatClass.claclulations.CalcMillisec;
import lv.initex.report.singleReport.services.processBoatClass.convert.ConvertToResultList;
import lv.initex.report.singleReport.services.processList.GetInitialAllListService;
import lv.initex.report.singleReport.services.processList.GetInitialClassListService;
import lv.initex.report.singleReport.services.processList.GetSingleStageAllStartList;
import lv.initex.report.singleReport.services.processList.GetSingleStageAndClassStartList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat splitFormat = new SimpleDateFormat("HH:mm:ss");
        int eventIndex = view.getComboBoxEvent().getSelectedIndex();

        if (eventIndex > 0) {
            CompetitionEvent event = GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent());
            SingleBoatClass boatClass = GetObjectFromCBoxSingleBoatClass.getObject(view.getComboBoxClass());
            SubEvent subEvent = GetObjectFromCBoxSubEvent.getObject(view.getComboBoxSubEvent());
            long startTime = 0;
            long split = 0;
            if (!view.getStartTime().getText().equals("") && !view.getSplitTime().getText().equals("")) {
                startTime = CalcMillisec.calcStartTimeMillis(view.getStartTime().getText());
                split = CalcMillisec.calcSplitmillis(view.getSplitTime().getText());
            }
            if (view.getComboBoxClass().getSelectedIndex() > 0) {
                if (view.getComboBoxSubEvent().getSelectedIndex() > 1) {
                    //process start list for current boat class && current stage OK
                    List<RaceResultList> list = process.process(event, boatClass);
                    List<RaceResultList> filtered = GetSingleStageAndClassStartList.execute(list, event, subEvent);
                    CreateAllStartListFrame.previewList(filtered, subEvent, startTime, split);
                } else {
                    //process initial start list for current boat class OK
                    List<RaceResultList> list = ConvertToResultList.convert(getInitialClassListService.getInitialList(event, boatClass)).stream()
                            .sorted(Comparator.comparing(RaceResultList::getBib).reversed())
                            .collect(Collectors.toList());
                    CreateAllStartListFrame.previewList(list, subEvent, startTime, split);
                }
            } else if (view.getComboBoxSubEvent().getSelectedIndex() > 1) {
                //process initial start list for all boat classes current stage
                List<RaceResultList> filtered = getSingleStageAllStartList.execute(event, subEvent);
                CreateAllStartListFrame.previewList(filtered, subEvent, startTime, split);

            } else {
                //process initial start list for all boat classes  OK
                List<RaceResultList> list = ConvertToResultList.convert(getInitialAllListService.getInitialList(event)).stream()
                        .sorted(Comparator.comparing(RaceResultList::getBib).reversed())
                        .collect(Collectors.toList());
                CreateAllStartListFrame.previewList(list, subEvent, startTime, split);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select event");
        }
    }


    public void print(List<RaceResultList> list) {
        System.out.println(list.get(0).getEventSingleRegistry().getCompetitor().getCompetitorName() + list.get(0).isHeatOneQualified());
    }
}