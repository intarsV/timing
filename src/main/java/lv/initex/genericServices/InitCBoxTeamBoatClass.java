package lv.initex.genericServices;

import lv.initex.database.GenericServicesRepository;
import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.TeamBoatClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class InitCBoxTeamBoatClass {

    @Autowired
    private GenericServicesRepository database;

    public void init(JComboBox comboBox) {
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