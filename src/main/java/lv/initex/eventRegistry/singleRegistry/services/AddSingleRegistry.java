package lv.initex.eventRegistry.singleRegistry.services;

import lv.initex.Error;
import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.domain.EventSingleRegistry;
import lv.initex.eventRegistry.singleRegistry.EventSingleRegistryView;
import lv.initex.eventRegistry.singleRegistry.validation.EvtSingleRegInsertValidator;
import lv.initex.eventRegistry.singleRegistry.validation.EvtSingleRegInsertValidatorImpl;

import javax.swing.*;
import java.util.List;

public class AddSingleRegistry {

    private EvtSingleRegInsertValidator insertValidator = new EvtSingleRegInsertValidatorImpl();

    public void execute(EventSingleRegistryView view, SingleEventRegistryRepository database) {
        List<Object> valueList = GetObjectsFromCBoxesSingle.getObjects(view);

        List<Error> errors = insertValidator.validate(valueList, database);

        if (errors.isEmpty()) {
            EventSingleRegistry eventSingleRegistry = new EventSingleRegistry(valueList);
            database.saveEventSingleRegistry(eventSingleRegistry);
            GenerateNextBib.generateNextBib(view);
            InitEventSingleRegistryModel.init(view, database);
            view.getComboBoxCompetitor().setSelectedIndex(-1);
        } else {
            JOptionPane.showMessageDialog(null, errors.get(0).getDescription());
        }
    }


}
