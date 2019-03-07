package lv.timing.race.singleRace.services.timer;

import lv.timing.race.singleRace.processSingleRace.SingleRaceView;
import lv.timing.race.singleRace.services.InitSingleRaceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class SingleTimer {

    @Autowired
    private InitSingleRaceModel initSingleRaceModel;

    @Autowired
    private SingleTimerTask singleTimerTask;

    public void timer(SingleRaceView view) {
        if (view.getComboBoxEvent().getSelectedIndex() > 0 && view.getComboBoxSubEvent().getSelectedIndex() > 0) {
            initSingleRaceModel.init(false, view);
            Timer timerProcess = new Timer();
            TimerTask tTaskProcess = new java.util.TimerTask() {
                public void run() {
                    singleTimerTask.processTmpDataTimer(view, timerProcess);
                }
            };
            if (view.getFrame().isVisible()) {
                timerProcess.scheduleAtFixedRate(tTaskProcess, 0, 3000);
            }
        }
    }
}
