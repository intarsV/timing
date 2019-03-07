package lv.timing.genericServices;

import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.CompetitionEvent;

import javax.swing.*;


public class GetObjectFromCBoxEvent {

    public static CompetitionEvent getObject(JComboBox comboBox) {
        ComboBoxItem item = (ComboBoxItem) comboBox.getSelectedItem();
        return (CompetitionEvent) item.getValue();
    }
}
