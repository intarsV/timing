package lv.timing.eventRegistry.teamRegistry.services;

import lv.timing.database.TeamEventRegistryRepository;
import lv.timing.domain.EventTeamRegistry;
import lv.timing.eventRegistry.teamRegistry.EventTeamRegistryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteFromRegistryTeam {

    @Autowired
    private TeamEventRegistryRepository database;

    @Autowired
    private EventTeamRegistryView view;

    public void execute() {
        if (view.getResultTable().getSelectedRow() != -1) {
            Long deleteEventTeamRegistry = Long.valueOf(view.getModel().getValueAt(view.getResultTable().getSelectedRow(), 0).toString());
            EventTeamRegistry eventTeamRegistry = database.findTeamRaceRegistryByID(deleteEventTeamRegistry).get();
            database.deleteEventTeamRaceRegistry(eventTeamRegistry);
            //  refreshModel();
            ResetCBoxesTeam.resetControlBoxes(view);
        }
    }
}
