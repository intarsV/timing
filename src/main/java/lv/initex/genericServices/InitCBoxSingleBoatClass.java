package lv.initex.genericServices;

import lv.initex.database.GenericServicesRepository;
import lv.initex.domain.SingleBoatClass;
import lv.initex.domain.ComboBoxItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

public class InitCBoxSingleBoatClass {

    public void init(JComboBox comboBox, GenericServicesRepository database) {
        try {
            comboBox.removeAllItems();
            List<SingleBoatClass> singleBoatClassList = database.singleBoatClassList();
            comboBox.addItem(new ComboBoxItem<SingleBoatClass>(new SingleBoatClass(), ""));
            for (SingleBoatClass singleBoatClass : singleBoatClassList) {
                comboBox.addItem(new ComboBoxItem<SingleBoatClass>(singleBoatClass, singleBoatClass.getBoatClass()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR creating boat class comboBox");
        }
    }
}
