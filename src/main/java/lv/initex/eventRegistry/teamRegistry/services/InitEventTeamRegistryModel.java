package lv.initex.eventRegistry.teamRegistry.services;

import lv.initex.database.TeamEventRegistryRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.EventTeamRegistry;
import lv.initex.eventRegistry.teamRegistry.EventTeamRegistryView;
import lv.initex.genericServices.GetObjectFromCBoxEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class InitEventTeamRegistryModel {

    @Autowired
    private EventTeamRegistryView view;

    @Autowired
    private TeamEventRegistryRepository database;

    public void init() {
        if (view.getComboBoxEvent().getSelectedIndex() > 0) {
            try {
                view.getModel().setRowCount(0);
                CompetitionEvent selectedEvent = GetObjectFromCBoxEvent.getObject(view.getComboBoxEvent());

                List<EventTeamRegistry> eventTeamRegistryList = database.registryList(selectedEvent);
                for (EventTeamRegistry eventTeamRegistry : eventTeamRegistryList) {
                    Object[] o = {eventTeamRegistry.getId().intValue()
                            , eventTeamRegistry.getCompetitionEvent()
                            , eventTeamRegistry.getSingleBoatClass()
                            , eventTeamRegistry.getCompetitorOne()
                            , eventTeamRegistry.getCompetitorTwo()
                            , eventTeamRegistry.getCompetitorThree()
                            , eventTeamRegistry.getCompetitorOne().getCompetitorName()
                            , eventTeamRegistry.getCompetitorTwo().getCompetitorName()
                            , eventTeamRegistry.getCompetitorThree().getCompetitorName()
                            , eventTeamRegistry.getSingleBoatClass().getBoatClass()
                            , eventTeamRegistry.getBib()};
                    view.getModel().addRow(o);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR getting team race registry  list");
            }
        } else {
            view.getModel().setRowCount(0);
        }
    }
}
