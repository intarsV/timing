package lv.initex.genericServices;

import lv.initex.domain.SingleBoatClass;
import lv.initex.domain.ComboBoxItem;

import javax.swing.*;

public class GetObjectFromCBoxSingleBoatClass {

    public static SingleBoatClass getObject(JComboBox combo) {
        ComboBoxItem item = (ComboBoxItem) combo.getSelectedItem();
        return (SingleBoatClass) item.getValue();
    }
}
