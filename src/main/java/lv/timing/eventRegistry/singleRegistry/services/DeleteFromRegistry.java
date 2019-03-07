package lv.timing.eventRegistry.singleRegistry.services;

import lv.timing.database.SingleEventRegistryRepository;
import lv.timing.domain.EventSingleRegistry;
import lv.timing.eventRegistry.singleRegistry.EventSingleRegistryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteFromRegistry {

    @Autowired
    private SingleEventRegistryRepository database;

    @Autowired
    private EventSingleRegistryView view;

    public void execute() {
        if (view.getTable().getSelectedRow() != -1) {
            Long deleteEventSingleRegistry = Long.valueOf(view.getModel().getValueAt(view.getTable().getSelectedRow(), 0).toString());
            EventSingleRegistry singleRaceRegistry = database.findSingleRaceRegistryByID(deleteEventSingleRegistry).get();
            database.deleteEventSingleRaceRegistry(singleRaceRegistry);
            view.getModel().removeRow(view.getTable().getSelectedRow());
            ResetCBoxes.resetControlBoxes(view);
        }
    }
}
