package lv.timing.genericServices;

import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.Group;

import javax.swing.*;

public class GetObjectFromCBoxGroup {

    public static Group getObject(JComboBox combo) {
        ComboBoxItem item = (ComboBoxItem) combo.getSelectedItem();
        return (Group) item.getValue();
    }
}
