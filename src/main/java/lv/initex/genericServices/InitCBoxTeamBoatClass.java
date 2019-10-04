package lv.initex.genericServices;

import lv.initex.database.GenericServicesRepository;
import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.TeamBoatClass;

import javax.swing.*;
import java.util.List;


public class InitCBoxTeamBoatClass {

    public void init(JComboBox comboBox, GenericServicesRepository database) {
        try {
            comboBox.removeAllItems();
            List<TeamBoatClass> teamBoatClassList = database.teamBoatClassList();
            comboBox.addItem(new ComboBoxItem<TeamBoatClass>(new TeamBoatClass(), ""));
            for (TeamBoatClass teamBoatClass : teamBoatClassList) {
                comboBox.addItem(new ComboBoxItem<TeamBoatClass>(teamBoatClass, teamBoatClass.getBoatClass()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR creating boat class comboBox");
        }
    }
}
