package lv.timing.genericServices;

import lv.timing.database.GenericServicesRepository;
import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class InitCBoxGroup {

    @Autowired
    private GenericServicesRepository database;

    public void init(JComboBox comboBox) {
        try {
            comboBox.removeAllItems();
            List<Group> groupList = database.groupsList();
            comboBox.addItem(new ComboBoxItem<Group>(new Group(), ""));
            for (Group group : groupList) {
                comboBox.addItem(new ComboBoxItem<Group>(group, group.getGroup()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR creating group ComboBox");
        }
    }
}
