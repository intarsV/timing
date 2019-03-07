package lv.timing.genericServices;

import lv.timing.database.GenericServicesRepository;
import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SubEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class InitCBoxSubEvent {

    @Autowired
    private GenericServicesRepository database;

    public void init(JComboBox cBoxEvent, JComboBox cBoxSubEvent) {
        if (cBoxEvent.getSelectedIndex() > 0) {
            CompetitionEvent event =GetObjectFromCBoxEvent.getObject(cBoxEvent);
            List<SubEvent> subEventList = database.subEventList(event);
            try {
                cBoxSubEvent.removeAllItems();
                cBoxSubEvent.addItem(new ComboBoxItem<SubEvent>(new SubEvent(), ""));
                for (SubEvent subEvent : subEventList) {
                    cBoxSubEvent.addItem(new ComboBoxItem<SubEvent>(subEvent, subEvent.getSubEvent()));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR creating sub event ComboBox");
            }
        }
    }

}
