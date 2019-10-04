package lv.initex.eventRegistry.teamRegistry.services;

import lv.initex.database.TeamEventRegistryRepository;
import lv.initex.domain.EventTeamRegistry;
import lv.initex.eventRegistry.teamRegistry.EventTeamRegistryView;
import lv.initex.genericServices.GetObjectFromCBoxCompetitor;
import lv.initex.genericServices.GetObjectFromCBoxTeamBoatClass;

public class UpdateToRegistryTeam {

    public void execute(EventTeamRegistryView view, TeamEventRegistryRepository database) {
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
            InitEventTeamRegistryModel.init(view, database);

            view.getComboBoxCompetitorOne().setSelectedIndex(-1);
            view.getComboBoxCompetitorTwo().setSelectedIndex(-1);
            view.getComboBoxCompetitorThree().setSelectedIndex(-1);
            //   } else {
            //     JOptionPane.showMessageDialog(null, errors.get(0).getDescription());
            //}
        }
    }
}
