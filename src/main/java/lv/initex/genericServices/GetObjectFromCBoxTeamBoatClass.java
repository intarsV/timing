package lv.initex.genericServices;

import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.TeamBoatClass;

import javax.swing.*;

public class GetObjectFromCBoxTeamBoatClass {

    public static TeamBoatClass getObject(JComboBox combo) {
        ComboBoxItem item = (ComboBoxItem) combo.getSelectedItem();
        return (TeamBoatClass) item.getValue();
    }
}
