package lv.initex.verifyMcuData.services.timer;

import lv.initex.verifyMcuData.VerifyMcuDataView;
import lv.initex.verifyMcuData.services.VerifyMCuServiceDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;

@Service
public class McuTimerTask {

    @Autowired
    private VerifyMCuServiceDispatcher service;

    public void processTmpDataTimer(Timer timer, VerifyMcuDataView view) {
        if (view.getTableStart().getCellEditor() == null && view.getTableFinish().getCellEditor() == null) {
            if (view.getModelStart().getRowCount() < service.countRecords(true)) {
                service.initMcuModel(true, view);
            }
            if (view.getModelFinish().getRowCount() < service.countRecords(false)) {
                service.initMcuModel(false, view);
            }
        }
        if (!view.getFrame().isVisible()) {
            timer.cancel();
        }
    }
}
