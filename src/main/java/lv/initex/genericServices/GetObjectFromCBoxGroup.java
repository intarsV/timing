package lv.initex.genericServices;

import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.Group;

import javax.swing.*;

public class GetObjectFromCBoxGroup {

    public static Group getObject(JComboBox combo) {
        ComboBoxItem item = (ComboBoxItem) combo.getSelectedItem();
        return (Group) item.getValue();
    }
}
