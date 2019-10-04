package lv.initex.eventRegistry.teamRegistry.services;

import lv.initex.database.TeamEventRegistryRepository;
import lv.initex.domain.EventTeamRegistry;
import lv.initex.eventRegistry.teamRegistry.EventTeamRegistryView;

import java.util.List;

public class AddTeamRegistry {

    public void execute(EventTeamRegistryView view, TeamEventRegistryRepository database) {
        List<Object> valueList = GetObjectsFromCBoxesTeam.getObjects(view);
//                Arrays.asList(getObject()
//                , getCompetitorOneObjectFromSelection()
//                , getCompetitorTwoObjectFromSelection()
//                , getCompetitorThreeObjectFromSelection()
//                , getBoatClassObjectFromSelection()
//                , view.getTextFieldBIB().getText()
//        );

        //  List<Error> errors = insertValidator.validate(valueList);           //validation?

        //  if (errors.isEmpty()) {
        EventTeamRegistry eventTeamRegistry = new EventTeamRegistry(valueList);
        database.saveEventTeamRegistry(eventTeamRegistry);
        GenerateNextBibTeam.generateNextBib(view);
        InitEventTeamRegistryModel.init(view, database);
        view.getComboBoxCompetitorOne().setSelectedIndex(-1);
        view.getComboBoxCompetitorTwo().setSelectedIndex(-1);
        view.getComboBoxCompetitorThree().setSelectedIndex(-1);
        //  } else {
        //       JOptionPane.showMessageDialog(null, errors.get(0).getDescription());
        //  }
    }
}
