package lv.timing.race.teamRace.services;

import lv.timing.database.TeamRaceRepository;
import lv.timing.domain.TeamRace;
import lv.timing.race.teamRace.abstractClass.TeamView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.TableModelEvent;
import java.util.Vector;

@Service
public class UpdateValuesTeamRace {

    @Autowired
    private TeamRaceRepository database;

    public void execute(TableModelEvent tme, TeamView view) {
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
