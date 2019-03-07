package lv.timing.race.teamRace.services;

import lv.timing.race.teamRace.processTeamRace.TeamRaceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefreshTeamModel {

    @Autowired
    private TeamRaceView view;

    @Autowired
    private InitTeamRaceModel getList;

    public void updateModel() {
        view.getModel().setRowCount(0);
        getList.init(false, view);
    }
}