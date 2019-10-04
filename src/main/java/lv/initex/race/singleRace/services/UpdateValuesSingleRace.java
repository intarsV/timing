package lv.initex.race.singleRace.services;

import lv.initex.database.SingleRaceRepository;
import lv.initex.domain.SingleRace;
import lv.initex.race.singleRace.abstractClass.SingleView;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class UpdateValuesSingleRace {

    public void execute(TableModelEvent tme, SingleView view, SingleRaceRepository database) {
        JTable table = view.getDataTable();
        DefaultTableModel model = view.getModel();

        if (tme.getType() == TableModelEvent.UPDATE) {
            int i = table.getSelectedRow();
            int j = table.getSelectedColumn();
            if (i != -1) {
                Vector row = (Vector) model.getDataVector().elementAt(i);
                SingleRace singleRace = new SingleRace(row);
                database.updateSingleRace(singleRace);
                if (j == 28) {
                    model.removeRow(i);
                }
            }
        }
    }
}
