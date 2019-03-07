package lv.timing.eventRegistry.singleRegistry.services;

import lv.timing.domain.ComboBoxItem;
import lv.timing.eventRegistry.singleRegistry.EventSingleRegistryView;

import javax.swing.*;

public class UpdateControls {

    public static void update(EventSingleRegistryView view) {
        int row = view.getTable().getSelectedRow();
        if (row > -1) {
            getComboBoxListIndex(view.getComboBoxGroup(), view.getModel().getValueAt(row, 6).toString());
            getComboBoxListIndex(view.getComboBoxClass(), view.getModel().getValueAt(row, 7).toString());
            getComboBoxListIndex(view.getComboBoxCompetitor(), view.getModel().getValueAt(row, 5).toString());
            view.getTextFieldBIB().setText(view.getTable().getValueAt(row, 3).toString());
        }
    }

    private static void getComboBoxListIndex(JComboBox comboBox, String c) {
        ComboBoxItem item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            item = (ComboBoxItem) comboBox.getItemAt(i);
            if (item.getDescription().equalsIgnoreCase(c)) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }
}
