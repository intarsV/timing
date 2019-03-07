package lv.timing.eventRegistry.singleRegistry.services;

import lv.timing.eventRegistry.singleRegistry.EventSingleRegistryView;
import lv.timing.genericServices.GetObjectFromCBoxSingleBoatClass;
import lv.timing.genericServices.GetObjectFromCBoxCompetitor;
import lv.timing.genericServices.GetObjectFromCBoxEvent;
import lv.timing.genericServices.GetObjectFromCBoxGroup;

import java.util.Arrays;
import java.util.List;


public class GetObjectsFromCBoxesSingle {

    public static List<Object> getObjects(EventSingleRegistryView view) {
        List<Object> valueList = Arrays.asList(GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent())
                , GetObjectFromCBoxCompetitor.getObject(view.getComboBoxCompetitor())
                , GetObjectFromCBoxGroup.getObject(view.getComboBoxGroup())
                , GetObjectFromCBoxSingleBoatClass.getObject(view.getComboBoxClass())
                , view.getTextFieldBIB().getText());
        return valueList;
    }
}
