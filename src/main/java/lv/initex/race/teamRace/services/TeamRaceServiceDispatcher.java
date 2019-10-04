package lv.initex.race.teamRace.services;

import lv.initex.database.TeamRaceRepository;
import lv.initex.database.VerifyMcuDataRepository;
import lv.initex.race.teamRace.abstractClass.TeamView;
import lv.initex.race.teamRace.processTeamRace.TeamRaceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.TableModelEvent;

@Service
public class TeamRaceServiceDispatcher {

    private TeamRaceRepository database;
    private VerifyMcuDataRepository databaseMcu;
    private InitTeamRaceModel initTeamRaceModel = new InitTeamRaceModel();
    private DeleteTeamRaceRow deleteTeamRaceRow = new DeleteTeamRaceRow();
    private UpdateValuesTeamRace updateValuesTeamRace = new UpdateValuesTeamRace();
    private TeamProcessMCUData teamProcessMCUData=new TeamProcessMCUData();

    @Autowired
    public TeamRaceServiceDispatcher(TeamRaceRepository database) {
        this.database = database;
    }

    public void initTeamRaceModel(boolean isEditMode, TeamView view) {
        initTeamRaceModel.init(isEditMode, view, database);
    }

    public void deleteTeamRaceRow(TeamView view) {
        deleteTeamRaceRow.execute(view, database);
    }

    public void updateValuesTeamRace(TableModelEvent tme, TeamView view) {
        updateValuesTeamRace.execute(tme, view, database);
    }

    public void teamProcessMCUData(TeamRaceView view){
        teamProcessMCUData.processTmpDataTimer(view,database,databaseMcu);
    }
}
