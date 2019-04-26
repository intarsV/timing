package lv.initex.eventRegistry.teamRegistry.services;

import lv.initex.domain.ComboBoxItem;
import lv.initex.eventRegistry.teamRegistry.EventTeamRegistryView;

import javax.swing.*;


public class UpdateControlsTeam {

    public static void update(EventTeamRegistryView view) {
        int row = view.getResultTable().getSelectedRow();
        if (row > -1) {
            getComboBoxListIndex(view.getComboBoxClass(),view.getModel().getValueAt(row, 9).toString());
            getComboBoxListIndex(view.getComboBoxCompetitorOne(), view.getModel().getValueAt(row, 6).toString());
            getComboBoxListIndex(view.getComboBoxCompetitorTwo(), view.getModel().getValueAt(row, 7).toString());
            getComboBoxListIndex(view.getComboBoxCompetitorThree(), view.getModel().getValueAt(row, 8).toString());
            view.getTextFieldBIB().setText(view.getResultTable().getValueAt(row, 4).toString());
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
