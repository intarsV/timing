package lv.initex.genericServices;

import lv.initex.database.GenericServicesRepository;
import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.CompetitionEvent;

import javax.swing.*;
import java.util.List;


public class InitCBoxEvent {

    public void init(JComboBox cBoxEvent, GenericServicesRepository database) {
        List<CompetitionEvent> eventList = database.eventList();
        try {
            cBoxEvent.removeAllItems();
            cBoxEvent.addItem(new ComboBoxItem<CompetitionEvent>(new CompetitionEvent(), ""));
            for (CompetitionEvent competitionEvent : eventList) {
                cBoxEvent.addItem(new ComboBoxItem<CompetitionEvent>(competitionEvent, competitionEvent.getEventName()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR creating event ComboBox");
        }
    }
}
