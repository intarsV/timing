package lv.initex.report.teamReport.services;

import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.SubEvent;
import lv.initex.domain.TeamBoatClass;
import lv.initex.domain.reportDomain.team.TeamRaceResultList;
import lv.initex.domain.reportDomain.team.TeamRaceStageList;
import lv.initex.genericServices.GetObjectFromCBoxEvent;
import lv.initex.genericServices.GetObjectFromCBoxSubEvent;
import lv.initex.genericServices.GetObjectFromCBoxTeamBoatClass;
import lv.initex.report.teamReport.TeamRaceReportView;
import lv.initex.report.teamReport.services.jasperFrame.CreateTeamResultFrame;
import lv.initex.report.teamReport.services.processBoatClass.ProcessTeamResultsService;
import lv.initex.report.teamReport.services.processBoatClass.ProcessTeamStageBoatClassList;
import lv.initex.report.teamReport.services.processList.GetTeamSingleStageAndClassStartList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreviewTeamStageResultsService {

    @Autowired
    private ProcessTeamResultsService processResultsService;

    @Autowired
    private TeamRaceReportView view;


    public void execute() {
        int eventIndex = view.getComboBoxEvent().getSelectedIndex();
        int subEventIndex = view.getComboBoxSubEvent().getSelectedIndex();
        int boatClassIndex = view.getComboBoxClass().getSelectedIndex();
        if (eventIndex > 0 && subEventIndex > 0 && boatClassIndex > 0) {
            CompetitionEvent event = GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent());
            TeamBoatClass boatClass = GetObjectFromCBoxTeamBoatClass.getObject(view.getComboBoxClass());
            SubEvent subEvent = GetObjectFromCBoxSubEvent.getObject(view.getComboBoxSubEvent());
            List<TeamRaceResultList> list = processResultsService.process(event, boatClass);
            //print(list);
            List<TeamRaceResultList> filtered = GetTeamSingleStageAndClassStartList.execute(list, event, subEvent);

            List<TeamRaceStageList> sorted = ProcessTeamStageBoatClassList.prepareList(filtered, subEvent).stream()
                    .sorted(Comparator.comparing(TeamRaceStageList::getTotal))
                    .collect(Collectors.toList());

            CreateTeamResultFrame.previewList(sorted);
        } else {
            JOptionPane.showMessageDialog(null, "Select event, subEvent and boatClass");
        }
    }


}
