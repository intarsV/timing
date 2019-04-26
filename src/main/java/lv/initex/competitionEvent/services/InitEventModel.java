package lv.initex.competitionEvent.services;

import lv.initex.competitionEvent.CompetitionEventView;
import lv.initex.database.CompetitionEventRepository;
import lv.initex.domain.CompetitionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class InitEventModel {

    @Autowired
    private CompetitionEventRepository database;

    public void init(CompetitionEventView view) {
        try {
            view.getModel().setRowCount(0);
            List<CompetitionEvent> eventList = database.eventList();
            for (CompetitionEvent competitionEvent : eventList) {
                Object[] o = {competitionEvent.getId().intValue()
                        , competitionEvent.getEventName(), competitionEvent.getEventFormat().getFormatName()
                        , competitionEvent.getPlaceDate()};
                view.getModel().addRow(o);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR getting event list");
            e.printStackTrace();
        }
    }
}
