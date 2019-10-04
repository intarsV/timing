package lv.initex.eventRegistry.singleRegistry.services;

import lv.initex.Error;
import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.domain.EventSingleRegistry;
import lv.initex.eventRegistry.singleRegistry.EventSingleRegistryView;
import lv.initex.eventRegistry.singleRegistry.validation.EventSingleRegistryUpdateValidator;
import lv.initex.eventRegistry.singleRegistry.validation.EventSingleRegistryUpdateValidatorImpl;
import lv.initex.genericServices.GetObjectFromCBoxCompetitor;
import lv.initex.genericServices.GetObjectFromCBoxGroup;
import lv.initex.genericServices.GetObjectFromCBoxSingleBoatClass;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.List;


public class UpdateToRegistry {


    private EventSingleRegistryUpdateValidator updateValidator=new EventSingleRegistryUpdateValidatorImpl();

    public void execute(EventSingleRegistryView view,SingleEventRegistryRepository database) {
        int row = view.getTable().getSelectedRow();
        if (row > -1) {
            Long searchId = Long.valueOf(view.getModel().getValueAt(row, 0).toString());
            EventSingleRegistry eventSingleRegistry = database.findSingleRaceRegistryByID(searchId).get();
            eventSingleRegistry.setGroup(GetObjectFromCBoxGroup.getObject(view.getComboBoxGroup()));
            eventSingleRegistry.setSingleBoatClass(GetObjectFromCBoxSingleBoatClass.getObject(view.getComboBoxClass()));
            eventSingleRegistry.setCompetitor(GetObjectFromCBoxCompetitor.getObject(view.getComboBoxCompetitor()));
            eventSingleRegistry.setBib(Integer.valueOf(view.getTextFieldBIB().getText()));

            List<Error> errors = updateValidator.validate(eventSingleRegistry,database);

            if (errors.isEmpty()) {
                database.updateEventSingleRegistry(eventSingleRegistry);
                GenerateNextBib.generateNextBib(view);
                InitEventSingleRegistryModel.init(view,database);
                view.getComboBoxCompetitor().setSelectedIndex(-1);
            } else {
                JOptionPane.showMessageDialog(null, errors.get(0).getDescription());
            }
        }
    }
}
