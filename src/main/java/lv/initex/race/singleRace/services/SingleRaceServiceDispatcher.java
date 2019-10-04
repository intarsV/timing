package lv.initex.race.singleRace.services;

import lv.initex.database.SingleRaceRepository;
import lv.initex.database.VerifyMcuDataRepository;
import lv.initex.race.singleRace.abstractClass.SingleView;
import lv.initex.race.singleRace.processSingleRace.SingleRaceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.TableModelEvent;

@Service
public class SingleRaceServiceDispatcher {

    private SingleRaceRepository database;
    private VerifyMcuDataRepository databaseMcu;
    private DeleteSingleRaceRow deleteSingleRaceRow = new DeleteSingleRaceRow();
    private UpdateValuesSingleRace updateValuesSingleRace=new UpdateValuesSingleRace();
    private SingleProcessMCUData singleProcessMCUData=new SingleProcessMCUData();

    @Autowired
    public SingleRaceServiceDispatcher(SingleRaceRepository database, VerifyMcuDataRepository databaseMcu) {
        this.database = database;
        this.databaseMcu=databaseMcu;
    }

    public void initSingleRaceModel(boolean isEditMode, SingleView view) {
        InitSingleRaceModel.init(isEditMode, view, database);
    }

    public void deleteSingleRaceRow(SingleView view){
        deleteSingleRaceRow.execute(view,database);
    }

    public void updateValuesSingleRace(TableModelEvent tme, SingleView view){
        updateValuesSingleRace.execute(tme,view,database);
    }

    public void singleProcessMCUData(SingleRaceView view){
        singleProcessMCUData.processTmpDataTimer(view,database,databaseMcu);
    }
}
