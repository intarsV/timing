package lv.timing.raceConfig.services;

import lv.timing.raceConfig.RaceConfigView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefreshRaceConfigModel {

    @Autowired
    private RaceConfigView view;

    @Autowired
    private InitRaceConfigModel getList;

    public void refresh(){
        view.getModel().setRowCount(0);
        getList.init(view);
    }
}
