package lv.timing.report.teamReport.services;


import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SingleBoatClass;
import lv.timing.domain.SubEvent;
import lv.timing.domain.TeamBoatClass;
import lv.timing.domain.reportDomain.single.RaceResultList;
import lv.timing.domain.reportDomain.team.TeamRaceResultList;
import lv.timing.genericServices.GetObjectFromCBoxEvent;
import lv.timing.genericServices.GetObjectFromCBoxSingleBoatClass;
import lv.timing.genericServices.GetObjectFromCBoxSubEvent;
import lv.timing.genericServices.GetObjectFromCBoxTeamBoatClass;
import lv.timing.report.singleReport.services.jasperFrame.CreateAllStartListFrame;
import lv.timing.report.singleReport.services.processBoatClass.ProcessResultsService;
import lv.timing.report.singleReport.services.processBoatClass.convert.ConvertToResultList;
import lv.timing.report.singleReport.services.processList.GetSingleStageAndClassStartList;
import lv.timing.report.teamReport.TeamRaceReportView;
import lv.timing.report.teamReport.services.jasperFrame.CreateTeamAllStartListFrame;
import lv.timing.report.teamReport.services.processBoatClass.ProcessTeamResultsService;
import lv.timing.report.teamReport.services.processBoatClass.convert.ConvertToTeamResultList;
import lv.timing.report.teamReport.services.processList.GetTeamInitialAllListService;
import lv.timing.report.teamReport.services.processList.GetTeamInitialClassListService;
import lv.timing.report.teamReport.services.processList.GetTeamSingleStageAllStartList;
import lv.timing.report.teamReport.services.processList.GetTeamSingleStageAndClassStartList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreviewTeamStartListService {

    @Autowired
    private TeamRaceReportView view;

    @Autowired
    private GetTeamInitialClassListService getInitialClassListService;

    @Autowired
    private GetTeamInitialAllListService getInitialAllListService;

    @Autowired
    private GetTeamSingleStageAllStartList getSingleStageAllStartList;

    @Autowired
    private ProcessTeamResultsService process;


    public void execute() {

        int eventIndex=view.getComboBoxEvent().getSelectedIndex();

        if (eventIndex>0 ) {

        CompetitionEvent event = GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent());
        TeamBoatClass boatClass = GetObjectFromCBoxTeamBoatClass.getObject(view.getComboBoxClass());
        SubEvent subEvent = GetObjectFromCBoxSubEvent.getObject(view.getComboBoxSubEvent());

        if (view.getComboBoxClass().getSelectedIndex() > 0) {
            if (view.getComboBoxSubEvent().getSelectedIndex() > 1) {
                //process start list for current boat class && current stage OK
                List<TeamRaceResultList> list = process.process(event, boatClass);
                List<TeamRaceResultList> filtered = GetTeamSingleStageAndClassStartList.execute(list, event, subEvent);
                CreateTeamAllStartListFrame.previewList(filtered,subEvent);
            } else {
                //process initial start list for current boat class OK
                List<TeamRaceResultList> list = ConvertToTeamResultList.convert(getInitialClassListService.getInitialList(event, boatClass)).stream()
                        .sorted(Comparator.comparing(TeamRaceResultList::getBib).reversed())
                        .collect(Collectors.toList());
                CreateTeamAllStartListFrame.previewList(list,subEvent);
            }
        } else if (view.getComboBoxSubEvent().getSelectedIndex() > 1) {
            //process initial start list for all boat classes current stage
            List<TeamRaceResultList> filtered=getSingleStageAllStartList.execute(event, subEvent);
            CreateTeamAllStartListFrame.previewList(filtered,subEvent);

        } else {
            //process initial start list for all boat classes  OK
            List<TeamRaceResultList> list = ConvertToTeamResultList.convert(getInitialAllListService.getInitialList(event)).stream()
                    .sorted(Comparator.comparing(TeamRaceResultList::getBib).reversed())
                    .collect(Collectors.toList());
            CreateTeamAllStartListFrame.previewList(list,subEvent);
        }
    }else{
            JOptionPane.showMessageDialog(null, "Select event");
        }
    }


    public void print(List<RaceResultList> list) {
        System.out.println(list.get(0).getEventSingleRegistry().getCompetitor().getCompetitorName() + list.get(0).isHeatOneQualified());
    }
}