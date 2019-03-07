package lv.timing.verifyMcuData.services.timer;

import lv.timing.verifyMcuData.VerifyMcuDataView;
import lv.timing.verifyMcuData.services.CountRecords;
import lv.timing.verifyMcuData.services.GetTMPList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;

@Service

public class McuTimerTask {

    @Autowired
    private CountRecords countRec;

    @Autowired
    private GetTMPList getTMPList;

    public void processTmpDataTimer(Timer timer,VerifyMcuDataView view) {
        if (view.getTableStart().getCellEditor() == null && view.getTableFinish().getCellEditor() == null) {
            Boolean forStart = true;
            if (view.getModelStart().getRowCount() < countRec.countRecords(forStart)) {
                getTMPList.getTmpList(forStart,view);
            }
            if (view.getModelFinish().getRowCount() < countRec.countRecords(!forStart)) {
                getTMPList.getTmpList(!forStart,view);
            }
        }
        if (!view.getFrame().isVisible()) {
            timer.cancel();
        }
    }
}
