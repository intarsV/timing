package lv.timing.genericServices;

import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.Competitor;

import javax.swing.*;

public class GetObjectFromCBoxCompetitor {

    public static Competitor getObject(JComboBox combo) {
        ComboBoxItem item = (ComboBoxItem) combo.getSelectedItem();
        return (Competitor) item.getValue();
    }
}
