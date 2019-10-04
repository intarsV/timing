package lv.initex.race.teamRace.services;

import lv.initex.database.TeamRaceRepository;
import lv.initex.domain.TeamRace;
import lv.initex.race.teamRace.abstractClass.TeamView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class DeleteTeamRaceRow {

    public void execute(TeamView view, TeamRaceRepository database) {
        JTable table = view.getResultTable();
        DefaultTableModel model = view.getModel();
        int i = table.getSelectedRow();
        if (i > -1) {
            Vector row = (Vector) model.getDataVector().elementAt(i);
            TeamRace teamRace = new TeamRace(row);
            model.removeRow(i);
            database.deleteTeamRace(teamRace);
        }
    }
}
