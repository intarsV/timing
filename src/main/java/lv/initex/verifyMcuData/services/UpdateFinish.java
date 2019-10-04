package lv.initex.verifyMcuData.services;

import lv.initex.database.VerifyMcuDataRepository;
import lv.initex.domain.VerifyMcuData;
import lv.initex.verifyMcuData.VerifyMcuDataView;

import javax.swing.event.TableModelEvent;
import java.util.Vector;

public class UpdateFinish {

    public void execute(TableModelEvent tme, VerifyMcuDataView view, VerifyMcuDataRepository database) {
        if (tme.getType() == TableModelEvent.UPDATE) {
            int i = view.getTableFinish().getSelectedRow();
            if (i != -1) {
                Vector row = (Vector) view.getModelFinish().getDataVector().elementAt(i);
                VerifyMcuData verifyMcuData = new VerifyMcuData(row);
                final int EXCLUDED = 333;
                final boolean isExcluded = verifyMcuData.getBib() == EXCLUDED;
                if (isExcluded) {
                    verifyMcuData.setDone(true);
                }
                database.update(verifyMcuData);
                view.getModelFinish().removeRow(i);
                view.getModelStart().notifyObservers();
            }
        }
    }
}


