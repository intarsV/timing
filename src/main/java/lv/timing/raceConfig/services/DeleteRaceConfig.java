package lv.timing.raceConfig.services;

import lv.timing.database.RaceConfigRepository;
import lv.timing.domain.RaceConfig;
import lv.timing.raceConfig.RaceConfigView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteRaceConfig {

    @Autowired
    private RaceConfigRepository database;

    public void execute(RaceConfigView view) {
        int i = view.getRaceConfigTable().getSelectedRow();
        if (i != -1) {
            if (view.getRaceConfigTable().getSelectedRow() != -1) {
                Long deleteRaceConfig = Long.valueOf(view.getModel().getValueAt(view.getRaceConfigTable().getSelectedRow(), 0).toString());
                RaceConfig raceConfig = database.findRaceConfigById(deleteRaceConfig).get();
                database.deleteRaceConfig(raceConfig);
                view.getModel().removeRow(i);
            }
        }
    }
}
