package lv.initex.eventRegistry.singleRegistry.services;

import lv.initex.eventRegistry.singleRegistry.EventSingleRegistryView;
import lv.initex.genericServices.GetObjectFromCBoxSingleBoatClass;
import lv.initex.genericServices.GetObjectFromCBoxCompetitor;
import lv.initex.genericServices.GetObjectFromCBoxEvent;
import lv.initex.genericServices.GetObjectFromCBoxGroup;

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
