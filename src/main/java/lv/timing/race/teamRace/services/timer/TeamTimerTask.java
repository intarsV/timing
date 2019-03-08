package lv.timing.race.teamRace.services.timer;

import lv.timing.database.TeamRaceRepository;
import lv.timing.database.VerifyMcuDataRepository;
import lv.timing.domain.*;
import lv.timing.genericServices.GetObjectFromCBoxEvent;
import lv.timing.genericServices.GetObjectFromCBoxSubEvent;
import lv.timing.race.teamRace.processTeamRace.TeamRaceView;
import lv.timing.race.teamRace.services.InitTeamRaceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Timer;

@Service
public class TeamTimerTask {

    @Autowired
    private TeamRaceRepository database;

    @Autowired
    private VerifyMcuDataRepository databaseMcu;

    @Autowired
    private InitTeamRaceModel initTeamRaceModel;

    public void processTmpDataTimer(TeamRaceView view, Timer timerProcess) {
        CompetitionEvent competitionEvent = GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent());
        SubEvent subEvent = GetObjectFromCBoxSubEvent.getObject(view.getComboBoxSubEvent());

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
            initTeamRaceModel.init(false, view);
        }
        if (!view.getFrame().isVisible()) {
            timerProcess.cancel();
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
