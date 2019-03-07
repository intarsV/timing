package lv.timing.race.singleRace.services;

import lv.timing.race.singleRace.processSingleRace.SingleRaceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefreshSingleModel {

    @Autowired
    private GetSingleRaceList getList;

    public void updateModel(SingleRaceView view) {
        view.getModel().setRowCount(0);
        getList.getSingleRaceList(false, view);
    }
}
