package lv.initex.competitors.services;

import lv.initex.competitors.CompetitorsView;
import lv.initex.database.CompetitorRepository;
import lv.initex.domain.Competitor;

import javax.swing.event.TableModelEvent;
import java.util.Vector;

public class UpdateValuesCompetitors {

    public void execute(TableModelEvent tme, CompetitorsView view,  CompetitorRepository database) {
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
