package lv.initex.raceConfig.services;

import lv.initex.database.RaceConfigRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.RaceConfig;
import lv.initex.domain.SingleBoatClass;
import lv.initex.genericServices.GetObjectFromCBoxEvent;
import lv.initex.genericServices.GetObjectFromCBoxSingleBoatClass;
import lv.initex.raceConfig.RaceConfigView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

public class AddRaceConfig {

    public void execute(RaceConfigView view,RaceConfigRepository database) {
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
            InitRaceConfigModel.init(view,database);
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
