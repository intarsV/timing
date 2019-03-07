package lv.timing.genericServices;

import lv.timing.domain.SingleBoatClass;
import lv.timing.domain.ComboBoxItem;

import javax.swing.*;

public class GetObjectFromCBoxSingleBoatClass {

    public static SingleBoatClass getObject(JComboBox combo) {
        ComboBoxItem item = (ComboBoxItem) combo.getSelectedItem();
        return (SingleBoatClass) item.getValue();
    }
}
