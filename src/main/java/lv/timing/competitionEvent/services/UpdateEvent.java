package lv.timing.competitionEvent.services;

import lv.timing.competitionEvent.CompetitionEventView;
import lv.timing.database.CompetitionEventRepository;
import lv.timing.domain.CompetitionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.TableModelEvent;
import java.util.Vector;

@Service
public class UpdateEvent {

    @Autowired
    private CompetitionEventRepository database;

    public void execute(TableModelEvent tme, CompetitionEventView view) {
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
