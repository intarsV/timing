package lv.initex.eventRegistry.singleRegistry.services;

import lv.initex.Error;
import lv.initex.database.SingleEventRegistryRepository;
import lv.initex.domain.EventSingleRegistry;
import lv.initex.eventRegistry.singleRegistry.EventSingleRegistryView;
import lv.initex.eventRegistry.singleRegistry.validation.EventSingleRegistryInsertValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class AddSingleRegistry {

    @Autowired
    private EventSingleRegistryView view;

    @Autowired
    private SingleEventRegistryRepository database;

    @Autowired
    private EventSingleRegistryInsertValidator insertValidator;

    @Autowired
    private InitEventSingleRegistryModel refreshModel;


    public void execute() {
        List<Object> valueList = GetObjectsFromCBoxesSingle.getObjects(view);

        List<Error> errors = insertValidator.validate(valueList);

        if (errors.isEmpty()) {
            EventSingleRegistry eventSingleRegistry = new EventSingleRegistry(valueList);
            database.saveEventSingleRegistry(eventSingleRegistry);
            GenerateNextBib.generateNextBib(view);
            refreshModel.init();
            view.getComboBoxCompetitor().setSelectedIndex(-1);
        } else {
            JOptionPane.showMessageDialog(null, errors.get(0).getDescription());
        }
    }


}
