package lv.timing.verifyMcuData.services;

import lv.timing.database.VerifyMcuDataRepository;
import lv.timing.domain.VerifyMcuData;
import lv.timing.verifyMcuData.VerifyMcuDataView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.TableModelEvent;
import java.util.Vector;

@Service
public class UpdateStart {

    @Autowired
    private VerifyMcuDataRepository database;

    public void execute(TableModelEvent tme, VerifyMcuDataView view) {
        if (tme.getType() == TableModelEvent.UPDATE) {
            int i = view.getTableStart().getSelectedRow();
            if (i != -1) {
                Vector row = (Vector) view.getModelStart().getDataVector().elementAt(i);
                VerifyMcuData verifyMcuData = new VerifyMcuData(row);
                database.updateStartLine(verifyMcuData);
                view.getModelStart().removeRow(i);
            }
        }
    }

}
