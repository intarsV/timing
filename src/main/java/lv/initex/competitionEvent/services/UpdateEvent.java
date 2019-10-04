package lv.initex.competitionEvent.services;

import lv.initex.competitionEvent.CompetitionEventView;
import lv.initex.database.CompetitionEventRepository;
import lv.initex.domain.CompetitionEvent;

import javax.swing.event.TableModelEvent;
import java.util.Vector;

public class UpdateEvent {

    public void execute(TableModelEvent tme, CompetitionEventView view, CompetitionEventRepository database) {
        if (tme.getType() == TableModelEvent.UPDATE) {
            int i = view.getTableEvent().getSelectedRow();
            if (i != -1) {
                Vector row = (Vector) view.getModel().getDataVector().elementAt(i);
                CompetitionEvent competitionEvent = new CompetitionEvent(row);
                database.updateEvent(competitionEvent);
            }
        }
    }
}
