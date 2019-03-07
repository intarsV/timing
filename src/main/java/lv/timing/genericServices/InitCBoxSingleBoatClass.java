package lv.timing.genericServices;

import lv.timing.database.GenericServicesRepository;
import lv.timing.domain.SingleBoatClass;
import lv.timing.domain.ComboBoxItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class InitCBoxSingleBoatClass {

    @Autowired
    private GenericServicesRepository database;

    public void init(JComboBox comboBox) {
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
