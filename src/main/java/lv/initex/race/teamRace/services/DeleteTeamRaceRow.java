package lv.initex.race.teamRace.services;

import lv.initex.database.TeamRaceRepository;
import lv.initex.domain.TeamRace;
import lv.initex.race.teamRace.abstractClass.TeamView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

@Service
public class DeleteTeamRaceRow {

    @Autowired
    private TeamRaceRepository database;

    public void execute(TeamView view) {
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