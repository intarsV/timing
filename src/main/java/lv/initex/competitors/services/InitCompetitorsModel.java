package lv.initex.competitors.services;

import lv.initex.competitors.CompetitorsView;
import lv.initex.database.CompetitorRepository;
import lv.initex.domain.Competitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class InitCompetitorsModel {

    @Autowired
    private CompetitorRepository database;

    public void init(CompetitorsView view) {
        try {
            view.getModel().setRowCount(0);
            List<Competitor> competitorList = database.competitorList();
            for (Competitor competitor : competitorList) {
                Object[] o = {competitor.getId().intValue()
                        , competitor.getCompetitorName()
                        , competitor.getBirthYear()
                        , competitor.getClub()
                        , competitor.getCountry()
                        , competitor.isDeleted()};
                view.getModel().addRow(o);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR getting competitor list");
        }
    }
}
