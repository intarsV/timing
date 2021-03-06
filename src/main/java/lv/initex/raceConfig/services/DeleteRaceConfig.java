package lv.initex.raceConfig.services;

import lv.initex.database.RaceConfigRepository;
import lv.initex.domain.RaceConfig;
import lv.initex.raceConfig.RaceConfigView;

public class DeleteRaceConfig {

    public void execute(RaceConfigView view, RaceConfigRepository database) {
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
