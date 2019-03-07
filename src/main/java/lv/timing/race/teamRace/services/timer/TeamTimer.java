package lv.timing.race.teamRace.services.timer;

import lv.timing.race.teamRace.processTeamRace.TeamRaceView;
import lv.timing.race.teamRace.services.InitTeamRaceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class TeamTimer {

    @Autowired
    private InitTeamRaceModel initTeamRaceModel;

    @Autowired
    private TeamTimerTask teamTimerTask;

    public void timer(TeamRaceView view) {
        if (view.getComboBoxEvent().getSelectedIndex() > 0 && view.getComboBoxSubEvent().getSelectedIndex() > 0) {
//            competitionEvent = getObject();
//            subEvent = getSubEventObjectFromSelection();
            initTeamRaceModel.init(false,view);
        //    initTeamRaceModel();
            Timer timerProcess = new Timer();
            TimerTask tTaskProcess = new TimerTask() {
                public void run() {
                    teamTimerTask.processTmpDataTimer(view,timerProcess);
                }
            };
            if (view.getFrame().isVisible()) {
                timerProcess.scheduleAtFixedRate(tTaskProcess, 0, 3000);
            }
        }
    }
}
