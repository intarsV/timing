package lv.initex.mainWindow.services;

import lv.initex.competitionEvent.CompetitionEventController;
import lv.initex.competitors.CompetitorsController;
import lv.initex.eventRegistry.singleRegistry.EventSingleRegistryController;
import lv.initex.eventRegistry.teamRegistry.EventTeamRegistryController;
import lv.initex.race.singleRace.editSingleRace.EditSingleRaceController;
import lv.initex.race.singleRace.processSingleRace.SingleRaceController;
import lv.initex.race.teamRace.editTeamRace.EditTeamRaceController;
import lv.initex.race.teamRace.processTeamRace.TeamRaceController;
import lv.initex.raceConfig.RaceConfigController;
import lv.initex.report.singleReport.SingleRaceReportController;
import lv.initex.report.teamReport.TeamRaceReportController;
import lv.initex.verifyMcuData.VerifyMcuDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class AddActions {

    @Autowired
    private CompetitorsController competitorsController;
    @Autowired
    private CompetitionEventController competitionEventController;
    @Autowired
    private EditSingleRaceController editSingleRaceController;
    @Autowired
    private EditTeamRaceController editTeamRaceController;
    @Autowired
    private EventSingleRegistryController eventSingleRegistryController;
    @Autowired
    private EventTeamRegistryController eventTeamRegistryController;
    @Autowired
    private RaceConfigController raceConfigController;
    @Autowired
    private SingleRaceReportController singleRaceReportController;
    @Autowired
    private TeamRaceReportController teamRaceReportController;
    @Autowired
    private SingleRaceController singleRaceController;
    @Autowired
    private TeamRaceController teamRaceController;
    @Autowired
    private VerifyMcuDataController verifyMcuDataController;

    public void addListeners(JMenuBar menuBar) {

        menuBar.getMenu(0).getItem(0).addActionListener(e -> openCompetitorsForm());
        menuBar.getMenu(0).getItem(1).addActionListener(e -> openCompetitionForm());
        menuBar.getMenu(0).getItem(2).addActionListener(e -> openRaceConfig());
        menuBar.getMenu(0).getItem(3).addActionListener(e -> openSingleRaceReg());
        menuBar.getMenu(0).getItem(4).addActionListener(e -> openTeamRaceReg());
        menuBar.getMenu(0).getItem(5).addActionListener(e -> System.exit(0));

        menuBar.getMenu(1).getItem(0).addActionListener(e -> openVerifyMcuData());
        menuBar.getMenu(1).getItem(1).addActionListener(e -> openSingleRace());
        menuBar.getMenu(1).getItem(2).addActionListener(e -> openTeamRace());
        menuBar.getMenu(1).getItem(3).addActionListener(e -> openEditSingleRace());
        menuBar.getMenu(1).getItem(4).addActionListener(e -> openEditTeamRace());

        menuBar.getMenu(2).getItem(0).addActionListener(e -> openSingleReport());
        menuBar.getMenu(2).getItem(1).addActionListener(e -> openTeamReport());
    }


    private void openCompetitorsForm() {
        competitorsController.execute();
    }

    private void openCompetitionForm() {
        competitionEventController.execute();
    }

    private void openEditSingleRace() {
        editSingleRaceController.execute();
    }

    private void openEditTeamRace() {
        editTeamRaceController.execute();
    }

    private void openSingleRaceReg() {
        eventSingleRegistryController.execute();
    }

    private void openTeamRaceReg() {
        eventTeamRegistryController.execute();
    }

    private void openRaceConfig() {
        raceConfigController.execute();
    }

    private void openSingleReport() {
        singleRaceReportController.execute();
    }

    private void openTeamReport() {
        teamRaceReportController.execute();
    }

    private void openSingleRace() {
        singleRaceController.execute();
    }

    private void openTeamRace() {
        teamRaceController.execute();
    }

    private void openVerifyMcuData() {
        verifyMcuDataController.execute();
    }

}
