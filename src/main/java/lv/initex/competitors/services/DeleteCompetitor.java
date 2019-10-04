package lv.initex.competitors.services;

import lv.initex.competitors.CompetitorsView;
import lv.initex.database.CompetitorRepository;
import lv.initex.domain.Competitor;

public class DeleteCompetitor {

    public void execute(CompetitorsView view, CompetitorRepository database) {
        int i = view.getCompetitorsTable().getSelectedRow();
        if (i != -1) {
            String deleteUserName = view.getModel().getValueAt(view.getCompetitorsTable().getSelectedRow(), 1).toString();
            Competitor competitor = database.findCompetitorByName(deleteUserName).get();
            competitor.setDeleted(true);
            database.updateCompetitor(competitor);
            view.getModel().removeRow(i);
        }
    }
}
