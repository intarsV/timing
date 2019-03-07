package lv.timing.race.singleRace.services;

import lv.timing.database.SingleRaceRepository;
import lv.timing.domain.SingleRace;
import lv.timing.race.singleRace.abstractClass.SingleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

@Service
public class UpdateValuesSingleRace {

    @Autowired
    private SingleRaceRepository database;

    public void execute(TableModelEvent tme, SingleView view) {
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
