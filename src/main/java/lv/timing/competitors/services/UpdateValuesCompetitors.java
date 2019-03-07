package lv.timing.competitors.services;

import lv.timing.competitors.CompetitorsView;
import lv.timing.database.CompetitorRepository;
import lv.timing.domain.Competitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.TableModelEvent;
import java.util.Vector;

@Service
public class UpdateValuesCompetitors {

    @Autowired
    CompetitorRepository database;

    public void execute(TableModelEvent tme, CompetitorsView view) {
        int i = view.getCompetitorsTable().getSelectedRow();
        if (tme.getType() == TableModelEvent.UPDATE) {
            if (i != -1) {
                Vector row = (Vector) view.getModel().getDataVector().elementAt(i);
                Competitor competitor = new Competitor(row);
                database.updateCompetitor(competitor);
            }
        }
    }
}
