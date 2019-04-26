package lv.initex.verifyMcuData.services;

import lv.initex.database.VerifyMcuDataRepository;
import lv.initex.domain.VerifyMcuData;
import lv.initex.verifyMcuData.VerifyMcuDataView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.TableModelEvent;
import java.util.Vector;

@Service
public class UpdateFinish {

    @Autowired
    private VerifyMcuDataRepository database;

    public void execute(TableModelEvent tme, VerifyMcuDataView view) {
        if (tme.getType() == TableModelEvent.UPDATE) {
            int i = view.getTableFinish().getSelectedRow();
            if (i != -1) {
                Vector row = (Vector) view.getModelFinish().getDataVector().elementAt(i);
                VerifyMcuData verifyMcuData = new VerifyMcuData(row);
                database.updateFinishLine(verifyMcuData);
                view.getModelFinish().removeRow(i);
            }
        }
    }
}
