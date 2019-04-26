package lv.initex.genericServices;

import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.CompetitionEvent;

import javax.swing.*;


public class GetObjectFromCBoxEvent {

    public static CompetitionEvent getObject(JComboBox comboBox) {
        ComboBoxItem item = (ComboBoxItem) comboBox.getSelectedItem();
        return (CompetitionEvent) item.getValue();
    }
}
