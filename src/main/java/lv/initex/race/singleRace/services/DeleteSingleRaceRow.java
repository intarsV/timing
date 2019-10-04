package lv.initex.race.singleRace.services;

import lv.initex.database.SingleRaceRepository;
import lv.initex.domain.SingleRace;
import lv.initex.race.singleRace.abstractClass.SingleView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class DeleteSingleRaceRow {

    public void execute(SingleView view, SingleRaceRepository database) {
        JTable table = view.getDataTable();
        DefaultTableModel model = view.getModel();
        int i = table.getSelectedRow();
        if (i > -1) {
            Vector row = (Vector) model.getDataVector().elementAt(i);
            SingleRace singleRace = new SingleRace(row);
            model.removeRow(i);
            database.deleteSingleRace(singleRace);
        }
    }
}
