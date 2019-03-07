package lv.timing.eventRegistry.singleRegistry.services;

import lv.timing.Error;
import lv.timing.database.SingleEventRegistryRepository;
import lv.timing.domain.EventSingleRegistry;
import lv.timing.eventRegistry.singleRegistry.EventSingleRegistryView;
import lv.timing.eventRegistry.singleRegistry.validation.EventSingleRegistryUpdateValidator;
import lv.timing.genericServices.GetObjectFromCBoxSingleBoatClass;
import lv.timing.genericServices.GetObjectFromCBoxCompetitor;
import lv.timing.genericServices.GetObjectFromCBoxGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class UpdateToRegistry {
    @Autowired
    private EventSingleRegistryView view;

    @Autowired
    private SingleEventRegistryRepository database;

    @Autowired
    private EventSingleRegistryUpdateValidator updateValidator;

    @Autowired
    private GetEventSingleRegistry refreshModel;

    public void execute() {
        int row = view.getTable().getSelectedRow();
        if (row > -1) {
            Long searchId = Long.valueOf(view.getModel().getValueAt(row, 0).toString());
            EventSingleRegistry eventSingleRegistry = database.findSingleRaceRegistryByID(searchId).get();
            eventSingleRegistry.setGroup(GetObjectFromCBoxGroup.getObject(view.getComboBoxGroup()));
            eventSingleRegistry.setSingleBoatClass(GetObjectFromCBoxSingleBoatClass.getObject(view.getComboBoxClass()));
            eventSingleRegistry.setCompetitor(GetObjectFromCBoxCompetitor.getObject(view.getComboBoxCompetitor()));
            eventSingleRegistry.setBib(Integer.valueOf(view.getTextFieldBIB().getText()));

            List<Error> errors = updateValidator.validate(eventSingleRegistry);

            if (errors.isEmpty()) {
                database.updateEventSingleRegistry(eventSingleRegistry);
                GenerateNextBib.generateNextBib(view);
                refreshModel.execute();
                view.getComboBoxCompetitor().setSelectedIndex(-1);
            } else {
                JOptionPane.showMessageDialog(null, errors.get(0).getDescription());
            }
        }
    }
}
