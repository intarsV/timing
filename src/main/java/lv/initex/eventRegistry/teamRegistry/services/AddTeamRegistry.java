package lv.initex.eventRegistry.teamRegistry.services;

import lv.initex.database.TeamEventRegistryRepository;
import lv.initex.domain.EventTeamRegistry;
import lv.initex.eventRegistry.teamRegistry.EventTeamRegistryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddTeamRegistry {

    @Autowired
    private TeamEventRegistryRepository database;

    @Autowired
    private EventTeamRegistryView view;

    @Autowired
    private InitEventTeamRegistryModel refreshModel;

    public void execute() {
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
        refreshModel.init();
        view.getComboBoxCompetitorOne().setSelectedIndex(-1);
        view.getComboBoxCompetitorTwo().setSelectedIndex(-1);
        view.getComboBoxCompetitorThree().setSelectedIndex(-1);
        //  } else {
        //       JOptionPane.showMessageDialog(null, errors.get(0).getDescription());
        //  }
    }
}
