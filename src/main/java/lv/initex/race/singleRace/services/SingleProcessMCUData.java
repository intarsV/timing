package lv.initex.race.singleRace.services;

import lv.initex.database.SingleRaceRepository;
import lv.initex.database.VerifyMcuDataRepository;
import lv.initex.domain.*;
import lv.initex.genericServices.GetObjectFromCBoxEvent;
import lv.initex.genericServices.GetObjectFromCBoxSubEvent;
import lv.initex.race.singleRace.processSingleRace.SingleRaceView;

import java.util.List;
import java.util.Optional;

public class SingleProcessMCUData {

    private CompetitionEvent competitionEvent;
    private SubEvent subEvent;
    private SingleRaceRepository database;
    private VerifyMcuDataRepository databaseMcu;

    public void processTmpDataTimer(SingleRaceView view, SingleRaceRepository database, VerifyMcuDataRepository databaseMcu) {

        this.database = database;
        this.databaseMcu = databaseMcu;
        competitionEvent = GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent());
        subEvent = GetObjectFromCBoxSubEvent.getObject(view.getComboBoxSubEvent());

        List<VerifyMcuData> verifyMcuDataList = databaseMcu.getListWithAccepted();
        if (view.getDataTable().getCellEditor() == null && verifyMcuDataList.size() > 0) {

            for (VerifyMcuData verifyMcuData : verifyMcuDataList) {
                final int bib = verifyMcuData.getBib();
                EventSingleRegistry eventSingleRegistry = new EventSingleRegistry();
                Optional<EventSingleRegistry> findEventSingleRegistry = database.findEventSingleRegistry(bib, competitionEvent);
                if (findEventSingleRegistry.isPresent()) {
                    eventSingleRegistry = findEventSingleRegistry.get();
                }

                Optional<SingleRace> findSingleRace = database.findSingleRaceWithEventSingleRegistry(eventSingleRegistry, subEvent);

                if (findSingleRace.isPresent()) {
                    SingleRace singleRace = findSingleRace.get();
                    processIfExists(verifyMcuData, singleRace);
                } else {
                    processIfNotExists(verifyMcuData, eventSingleRegistry);
                }
            }
            InitSingleRaceModel.init(false, view, database);
        }

    }

    private void processIfExists(VerifyMcuData verifyMcuData, SingleRace singleRace) {

        if (singleRace.getStartTime() == 0 && verifyMcuData.getUnitId() == 1) {
            singleRace.setStartTime(verifyMcuData.getTimeStamp());
        } else if (singleRace.getFinishTime() == 0 && verifyMcuData.getUnitId() == 2) {
            singleRace.setFinishTime(verifyMcuData.getTimeStamp());
        } else {
            System.out.println("be, what did you gave me!");
        }
        database.updateSingleRace(singleRace);
        verifyMcuData.setDone(true);
        databaseMcu.update(verifyMcuData);
    }

    private void processIfNotExists(VerifyMcuData verifyMcuData, EventSingleRegistry eventSingleRegistry) {
        SingleRace singleRace = new SingleRace();
        singleRace.setEventSingleRegistry(eventSingleRegistry);
        singleRace.setCompetitionEvent(competitionEvent);
        singleRace.setSubEvent(subEvent);

        if (verifyMcuData.getUnitId() == 1) {
            singleRace.setStartTime(verifyMcuData.getTimeStamp());
        } else if (verifyMcuData.getUnitId() == 2) {
            singleRace.setFinishTime(verifyMcuData.getTimeStamp());
        } else {
            System.out.println("be, what did you gave me!");
        }
        database.saveSingleRace(singleRace);

        verifyMcuData.setDone(true);
        databaseMcu.update(verifyMcuData);
    }
}
