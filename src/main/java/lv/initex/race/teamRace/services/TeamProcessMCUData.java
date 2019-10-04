package lv.initex.race.teamRace.services;

import lv.initex.database.TeamRaceRepository;
import lv.initex.database.VerifyMcuDataRepository;
import lv.initex.domain.*;
import lv.initex.genericServices.GetObjectFromCBoxEvent;
import lv.initex.genericServices.GetObjectFromCBoxSubEvent;
import lv.initex.race.teamRace.processTeamRace.TeamRaceView;

import java.util.List;
import java.util.Optional;

public class TeamProcessMCUData {

    private CompetitionEvent competitionEvent;
    private SubEvent subEvent;
    private TeamRaceRepository database;
    private VerifyMcuDataRepository databaseMcu;

    public void processTmpDataTimer(TeamRaceView view, TeamRaceRepository database, VerifyMcuDataRepository databaseMcu) {
        this.database = database;
        this.databaseMcu = databaseMcu;
        competitionEvent = GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent());
        subEvent = GetObjectFromCBoxSubEvent.getObject(view.getComboBoxSubEvent());

        List<VerifyMcuData> verifyMcuDataList = databaseMcu.getListWithAccepted();
        if (view.getResultTable().getCellEditor() == null && verifyMcuDataList.size() > 0) {

            for (VerifyMcuData verifyMcuData : verifyMcuDataList) {
                EventTeamRegistry eventTeamRegistry = database.findEventTeamRegistry(verifyMcuData.getBib(), competitionEvent).get();

                Optional<TeamRace> findTeamRace = database.findTeamRaceWithEventTeamRegistry(eventTeamRegistry);

                if (findTeamRace.isPresent()) {
                    processIfExists(verifyMcuData, findTeamRace);
                } else {
                    processIfNotExists(verifyMcuData, eventTeamRegistry, competitionEvent, subEvent);
                }
            }
            InitTeamRaceModel.init(false, view, database);
        }
    }

    private void processIfExists(VerifyMcuData verifyMcuData, Optional<TeamRace> findTeamRace) {
        TeamRace teamRace = findTeamRace.get();
        if (teamRace.getStartTime() == 0) {
            teamRace.setStartTime(verifyMcuData.getTimeStamp());
        } else {
            teamRace.setFinishTime(verifyMcuData.getTimeStamp());
        }
        database.updateTeamRace(teamRace);
        verifyMcuData.setDone(true);
        databaseMcu.update(verifyMcuData);
    }

    private void processIfNotExists(VerifyMcuData verifyMcuData, EventTeamRegistry eventTeamRegistry, CompetitionEvent competitionEvent, SubEvent subEvent) {
        TeamRace teamRace = new TeamRace();
        teamRace.setCompetitionEvent(competitionEvent);
        teamRace.setEventTeamRegistry(eventTeamRegistry);
        teamRace.setSubEvent(subEvent);

        if (verifyMcuData.getUnitId() == 1) {
            teamRace.setStartTime(verifyMcuData.getTimeStamp());
        } else {
            teamRace.setFinishTime(verifyMcuData.getTimeStamp());
        }
        database.saveTeamRace(teamRace);
        verifyMcuData.setDone(true);
        databaseMcu.update(verifyMcuData);
    }
}
