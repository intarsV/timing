package lv.timing.raceConfig.services;

import lv.timing.database.RaceConfigRepository;
import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.RaceConfig;
import lv.timing.raceConfig.RaceConfigView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class InitRaceConfigModel {

    @Autowired
    private RaceConfigRepository database;

    public void init(RaceConfigView view) {
        if (view.getComboBoxEvent().getSelectedIndex() > 0) {
            try {
                view.getModel().setRowCount(0);
                ComboBoxItem item = (ComboBoxItem) view.getComboBoxEvent().getSelectedItem();
                CompetitionEvent selectedEvent = (CompetitionEvent) item.getValue();

                List<RaceConfig> raceConfigList = database.raceConfigList(selectedEvent);

                for (RaceConfig raceConfig : raceConfigList) {
                    Object[] o = {raceConfig.getId().intValue()
                            , raceConfig.getCompetitionEvent()
                            , raceConfig.getSingleBoatClass()
                            , raceConfig.getSingleBoatClass().getBoatClass()
                            , raceConfig.getHeat1()
                            , raceConfig.getHeat2()
                            , raceConfig.getSemiFinal()};
                    view.getModel().addRow(o);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR getting race config list");
            }
        } else {
            view.getModel().setRowCount(0);
        }
    }
}
