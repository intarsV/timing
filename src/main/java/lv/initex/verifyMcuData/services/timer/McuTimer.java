package lv.initex.verifyMcuData.services.timer;

import lv.initex.verifyMcuData.VerifyMcuDataView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class McuTimer {

    @Autowired
    private McuTimerTask processMcuTmpDataTimer;

    public void timer(VerifyMcuDataView view) {
        Timer timerAccept = new Timer();
        TimerTask tTask = new TimerTask() {
            public void run() {
                processMcuTmpDataTimer.processTmpDataTimer(timerAccept,view);
            }
        };
        if (view.getFrame().isVisible()) {
            timerAccept.scheduleAtFixedRate(tTask, 0, 3000);
        }
    }
}
