package lv.timing.verifyMcuData.services;

import lv.timing.database.VerifyMcuDataRepository;
import lv.timing.domain.VerifyMcuData;
import lv.timing.verifyMcuData.VerifyMcuDataView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

@Service
public class InitMcuModel {

    @Autowired
    private VerifyMcuDataRepository database;

    public void init(boolean forStart, VerifyMcuDataView view) {
        if (forStart) {
            try {
                view.getModelStart().setRowCount(0);
                List<VerifyMcuData> verifyMcuDataList = database.startList();
                addToModel(view.getModelStart(), verifyMcuDataList);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR getting start list");
            }
        } else {
            try {
                view.getModelFinish().setRowCount(0);
                List<VerifyMcuData> verifyMcuDataList = database.finishList();
                addToModel(view.getModelFinish(), verifyMcuDataList);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR getting finish list");
            }
        }
    }

    private void addToModel(DefaultTableModel model, List<VerifyMcuData> verifyMcuDataList) {
        for (VerifyMcuData verifyMcuData : verifyMcuDataList) {
            Object[] o = {verifyMcuData.getId().intValue()
                    , verifyMcuData.getBib()
                    , verifyMcuData.getTimeStamp()
                    , verifyMcuData.getUnitId()
                    , verifyMcuData.getSubEvent()
                    , verifyMcuData.isDone()
                    , verifyMcuData.isAccepted()};
            model.addRow(o);
        }
    }
}
