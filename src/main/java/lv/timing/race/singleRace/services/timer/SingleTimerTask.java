package lv.timing.race.singleRace.services.timer;

import lv.timing.database.SingleRaceRepository;
import lv.timing.database.VerifyMcuDataRepository;
import lv.timing.domain.*;
import lv.timing.genericServices.GetObjectFromCBoxEvent;
import lv.timing.genericServices.GetObjectFromCBoxSubEvent;
import lv.timing.race.singleRace.processSingleRace.SingleRaceView;
import lv.timing.race.singleRace.services.RefreshSingleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Timer;

@Service
public class SingleTimerTask {

    @Autowired
    private SingleRaceRepository database;

    @Autowired
    private VerifyMcuDataRepository databaseMcu;

    @Autowired
    private RefreshSingleModel refreshSingleModel;


    public void processTmpDataTimer(SingleRaceView view, Timer timerProcess) {

        CompetitionEvent competitionEvent = GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent());
        SubEvent subEvent = GetObjectFromCBoxSubEvent.getObject(view.getComboBoxSubEvent());


        List<VerifyMcuData> verifyMcuDataList = databaseMcu.getListWithAccepted();
        if (view.getDataTable().getCellEditor() == null && verifyMcuDataList.size() > 0) {

            for (VerifyMcuData verifyMcuData : verifyMcuDataList) {
                EventSingleRegistry eventSingleRegistry = database.findEventSingleRegistry(verifyMcuData.getBib(), competitionEvent).get();
                Optional<SingleRace> findSingleRace = database.findSingleRaceWithEventSingleRegistry(eventSingleRegistry,subEvent);

                if (findSingleRace.isPresent()) {
                    processIfExists(verifyMcuData, findSingleRace);
                } else {
                    processIfNotExists(verifyMcuData, eventSingleRegistry, competitionEvent, subEvent);
                }
            }
            refreshSingleModel.updateModel(view);
        }
        if (!view.getFrame().isVisible()) {
            timerProcess.cancel();
        }
    }

    public void processIfExists(VerifyMcuData verifyMcuData, Optional<SingleRace> findSingleRace) {
        SingleRace singleRace = findSingleRace.get();
        if (singleRace.getStartTime() == 0) {
            singleRace.setStartTime(verifyMcuData.getTimeStamp());
        } else {
            singleRace.setFinishTime(verifyMcuData.getTimeStamp());
        }
        database.updateSingleRace(singleRace);
        verifyMcuData.setDone(true);
        databaseMcu.update(verifyMcuData);
    }

    public void processIfNotExists(VerifyMcuData verifyMcuData, EventSingleRegistry eventSingleRegistry, CompetitionEvent competitionEvent, SubEvent subEvent) {
        SingleRace singleRace = new SingleRace();
        singleRace.setEventSingleRegistry(eventSingleRegistry);
        singleRace.setCompetitionEvent(competitionEvent);
        singleRace.setSubEvent(subEvent);

        if (verifyMcuData.getUnitId() == 1) {
            singleRace.setStartTime(verifyMcuData.getTimeStamp());
        } else {
            singleRace.setFinishTime(verifyMcuData.getTimeStamp());
        }
        database.saveSingleRace(singleRace);

        verifyMcuData.setDone(true);
        databaseMcu.update(verifyMcuData);
    }
}
