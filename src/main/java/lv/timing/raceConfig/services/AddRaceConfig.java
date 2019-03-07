package lv.timing.raceConfig.services;

import lv.timing.database.RaceConfigRepository;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.RaceConfig;
import lv.timing.domain.SingleBoatClass;
import lv.timing.genericServices.GetObjectFromCBoxEvent;
import lv.timing.genericServices.GetObjectFromCBoxSingleBoatClass;
import lv.timing.raceConfig.RaceConfigView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AddRaceConfig {

    @Autowired
    private RaceConfigRepository database;

    @Autowired
    private RefreshRaceConfigModel refresh;

    public void execute(RaceConfigView view) {
        if (view.getComboBoxEvent().getSelectedIndex() > 0 && view.getComboBoxClass().getSelectedIndex() > 0) {
            CompetitionEvent selectedEvent = GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent());
            SingleBoatClass selectedSingleBoatClass = GetObjectFromCBoxSingleBoatClass.getObject(view.getComboBoxClass());
            List<Object> valueList = Arrays.asList(selectedEvent
                    , selectedSingleBoatClass
                    , view.getTextFieldH1().getText()
                    , view.getTextFieldH2().getText()
                    , view.getTextFieldSf().getText());
            RaceConfig raceConfig = new RaceConfig(valueList);
            database.addRaceConfig(raceConfig);
            refresh.refresh();
            resetTextBoxes(view);
        }
    }

    private void resetTextBoxes(RaceConfigView view) {
        view.getComboBoxClass().setSelectedIndex(-1);
        view.getTextFieldH1().setText(null);
        view.getTextFieldH2().setText(null);
        view.getTextFieldSf().setText(null);
    }
}