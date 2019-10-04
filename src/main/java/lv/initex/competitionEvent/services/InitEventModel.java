package lv.initex.competitionEvent.services;

import lv.initex.competitionEvent.CompetitionEventView;
import lv.initex.database.CompetitionEventRepository;
import lv.initex.domain.CompetitionEvent;

import javax.swing.*;
import java.util.List;

public class InitEventModel {

    public static void init(CompetitionEventView view, CompetitionEventRepository database) {
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
