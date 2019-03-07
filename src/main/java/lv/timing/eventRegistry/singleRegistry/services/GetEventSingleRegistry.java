package lv.timing.eventRegistry.singleRegistry.services;

import lv.timing.database.SingleEventRegistryRepository;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.EventSingleRegistry;
import lv.timing.eventRegistry.singleRegistry.EventSingleRegistryView;
import lv.timing.genericServices.GetObjectFromCBoxEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class GetEventSingleRegistry {

    @Autowired
    private EventSingleRegistryView view;

    @Autowired
    private SingleEventRegistryRepository database;

    public void execute() {
        if (view.getComboBoxEvent().getSelectedIndex() > 0) {
            try {
                view.getModel().setRowCount(0);
                CompetitionEvent selectedEvent = GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent());

                List<EventSingleRegistry> eventSingleRegistryList = database.registryList(selectedEvent);
                for (EventSingleRegistry eventSingleRegistry : eventSingleRegistryList) {
                    Object[] o = {eventSingleRegistry.getId().intValue()
                            , eventSingleRegistry.getCompetitionEvent()
                            , eventSingleRegistry.getGroup()
                            , eventSingleRegistry.getSingleBoatClass()
                            , eventSingleRegistry.getCompetitor()
                            , eventSingleRegistry.getCompetitor().getCompetitorName()
                            , eventSingleRegistry.getGroup().getGroup()
                            , eventSingleRegistry.getSingleBoatClass().getBoatClass()
                            , eventSingleRegistry.getBib()};
                    view.getModel().addRow(o);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR getting single race registry  list");
            }
        } else {
            view.getModel().setRowCount(0);
        }
    }

}
