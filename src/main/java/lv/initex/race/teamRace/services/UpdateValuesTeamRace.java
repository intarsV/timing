package lv.initex.race.teamRace.services;

import lv.initex.database.TeamRaceRepository;
import lv.initex.domain.TeamRace;
import lv.initex.race.teamRace.abstractClass.TeamView;

import javax.swing.event.TableModelEvent;
import java.util.Vector;

public class UpdateValuesTeamRace {

    public void execute(TableModelEvent tme, TeamView view, TeamRaceRepository database) {
        if (tme.getType() == TableModelEvent.UPDATE) {
            int i = view.getResultTable().getSelectedRow();
            if (i > -1) {
                int col = view.getResultTable().getSelectedColumn();
                Vector row = (Vector) view.getModel().getDataVector().elementAt(i);
                TeamRace teamRace = new TeamRace(row);
                database.updateTeamRace(teamRace);
                if (col == 29) {     ///????
                    view.getModel().removeRow(i);
                    // refreshModel();
                }
            }
        }
    }
}
