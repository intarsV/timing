package lv.initex.genericServices;

import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.Competitor;

import javax.swing.*;

public class GetObjectFromCBoxCompetitor {

    public static Competitor getObject(JComboBox combo) {
        ComboBoxItem item = (ComboBoxItem) combo.getSelectedItem();
        return (Competitor) item.getValue();
    }
}
