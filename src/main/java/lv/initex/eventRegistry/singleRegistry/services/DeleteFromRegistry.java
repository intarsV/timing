package lv.initex.eventRegistry.singleRegistry.services;

import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.domain.EventSingleRegistry;
import lv.initex.eventRegistry.singleRegistry.EventSingleRegistryView;

public class DeleteFromRegistry {

    public void execute(EventSingleRegistryView view, SingleEventRegistryRepository database) {
        if (view.getTable().getSelectedRow() != -1) {
            Long deleteEventSingleRegistry = Long.valueOf(view.getModel().getValueAt(view.getTable().getSelectedRow(), 0).toString());
            EventSingleRegistry singleRaceRegistry = database.findSingleRaceRegistryByID(deleteEventSingleRegistry).get();
            database.deleteEventSingleRaceRegistry(singleRaceRegistry);
            view.getModel().removeRow(view.getTable().getSelectedRow());
            ResetCBoxes.resetControlBoxes(view);
        }
    }
}
