package lv.timing.eventRegistry.teamRegistry.services;

import lv.timing.eventRegistry.teamRegistry.EventTeamRegistryView;
import lv.timing.genericServices.GetObjectFromCBoxCompetitor;
import lv.timing.genericServices.GetObjectFromCBoxEvent;
import lv.timing.genericServices.GetObjectFromCBoxTeamBoatClass;

import java.util.Arrays;
import java.util.List;


public class GetObjectsFromCBoxesTeam {

    public static List<Object> getObjects(EventTeamRegistryView view) {
        List<Object> valueList = Arrays.asList(GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent())
                , GetObjectFromCBoxCompetitor.getObject(view.getComboBoxCompetitorOne())
                , GetObjectFromCBoxCompetitor.getObject(view.getComboBoxCompetitorTwo())
                , GetObjectFromCBoxCompetitor.getObject(view.getComboBoxCompetitorThree())
                , GetObjectFromCBoxTeamBoatClass.getObject(view.getComboBoxClass())
                , view.getTextFieldBIB().getText());
        return valueList;
    }


}
