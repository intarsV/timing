package lv.timing.competitors.services;

import lv.timing.competitors.CompetitorsView;
import lv.timing.database.CompetitorRepository;
import lv.timing.domain.Competitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCompetitor {

    @Autowired
    private CompetitorRepository database;

    public void execute(CompetitorsView view) {
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
