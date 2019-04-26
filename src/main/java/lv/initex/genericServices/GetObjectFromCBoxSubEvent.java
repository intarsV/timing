package lv.initex.genericServices;

import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.SubEvent;

import javax.swing.*;


public class GetObjectFromCBoxSubEvent {

    public static SubEvent getObject(JComboBox comboBox) {
        ComboBoxItem item = (ComboBoxItem) comboBox.getSelectedItem();
        return (SubEvent) item.getValue();
    }
}
