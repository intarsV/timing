package lv.timing.eventRegistry.teamRegistry.services;

import lv.timing.database.TeamEventRegistryRepository;
import lv.timing.domain.EventTeamRegistry;
import lv.timing.eventRegistry.teamRegistry.EventTeamRegistryView;
import lv.timing.genericServices.GetObjectFromCBoxCompetitor;
import lv.timing.genericServices.GetObjectFromCBoxTeamBoatClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateToRegistryTeam {

    @Autowired
    private EventTeamRegistryView view;

    @Autowired
    private TeamEventRegistryRepository database;

    @Autowired
    private InitEventTeamRegistryModel refreshModel;

    public void execute() {
        int row = view.getResultTable().getSelectedRow();
        if (row > -1) {
            Long searchId = Long.valueOf(view.getModel().getValueAt(row, 0).toString());
            EventTeamRegistry eventTeamRegistry = database.findTeamRaceRegistryByID(searchId).get();
            eventTeamRegistry.setSingleBoatClass(GetObjectFromCBoxTeamBoatClass.getObject(view.getComboBoxClass()));
            eventTeamRegistry.setCompetitorOne(GetObjectFromCBoxCompetitor.getObject(view.getComboBoxCompetitorOne()));
            eventTeamRegistry.setCompetitorTwo(GetObjectFromCBoxCompetitor.getObject(view.getComboBoxCompetitorTwo()));
            eventTeamRegistry.setCompetitorThree(GetObjectFromCBoxCompetitor.getObject(view.getComboBoxCompetitorThree()));
            eventTeamRegistry.setBib(Integer.valueOf(view.getTextFieldBIB().getText()));

            //  List<Error> errors = insertValidator.validate(valueList);           //validation?

            //  if (errors.isEmpty()) {
            database.updateEventTeamRegistry(eventTeamRegistry);
            GenerateNextBibTeam.generateNextBib(view);
            refreshModel.init();

            view.getComboBoxCompetitorOne().setSelectedIndex(-1);
            view.getComboBoxCompetitorTwo().setSelectedIndex(-1);
            view.getComboBoxCompetitorThree().setSelectedIndex(-1);
            //   } else {
            //     JOptionPane.showMessageDialog(null, errors.get(0).getDescription());
            //}
        }
    }
}
