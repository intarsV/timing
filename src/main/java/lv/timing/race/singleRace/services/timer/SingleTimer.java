package lv.timing.race.singleRace.services.timer;

import lv.timing.race.singleRace.processSingleRace.SingleRaceView;
import lv.timing.race.singleRace.services.GetSingleRaceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class SingleTimer {

    @Autowired
    private GetSingleRaceList getSingleRaceList;

    @Autowired
    private SingleTimerTask singleTimerTask;

    public void timer(SingleRaceView view) {
        if (view.getComboBoxEvent().getSelectedIndex() > 0 && view.getComboBoxSubEvent().getSelectedIndex() > 0) {
            getSingleRaceList.getSingleRaceList(false, view);
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
