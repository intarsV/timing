package lv.timing.genericServices;

import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.SubEvent;

import javax.swing.*;


public class GetObjectFromCBoxSubEvent {

    public static SubEvent getObject(JComboBox comboBox) {
        ComboBoxItem item = (ComboBoxItem) comboBox.getSelectedItem();
        return (SubEvent) item.getValue();
    }
}
