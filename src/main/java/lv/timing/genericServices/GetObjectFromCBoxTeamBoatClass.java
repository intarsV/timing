package lv.timing.genericServices;

import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.TeamBoatClass;

import javax.swing.*;

public class GetObjectFromCBoxTeamBoatClass {

    public static TeamBoatClass getObject(JComboBox combo) {
        ComboBoxItem item = (ComboBoxItem) combo.getSelectedItem();
        return (TeamBoatClass) item.getValue();
    }
}
