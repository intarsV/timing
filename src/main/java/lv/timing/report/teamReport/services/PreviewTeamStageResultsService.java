package lv.timing.report.teamReport.services;

import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SubEvent;
import lv.timing.domain.TeamBoatClass;
import lv.timing.domain.reportDomain.team.TeamRaceResultList;
import lv.timing.domain.reportDomain.team.TeamRaceStageList;
import lv.timing.genericServices.GetObjectFromCBoxEvent;
import lv.timing.genericServices.GetObjectFromCBoxSubEvent;
import lv.timing.genericServices.GetObjectFromCBoxTeamBoatClass;
import lv.timing.report.teamReport.TeamRaceReportView;
import lv.timing.report.teamReport.services.jasperFrame.CreateTeamResultFrame;
import lv.timing.report.teamReport.services.processBoatClass.ProcessTeamResultsService;
import lv.timing.report.teamReport.services.processBoatClass.ProcessTeamStageBoatClassList;
import lv.timing.report.teamReport.services.processList.GetTeamSingleStageAndClassStartList;
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
