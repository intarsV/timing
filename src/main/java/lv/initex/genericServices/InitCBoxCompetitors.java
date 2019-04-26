package lv.initex.genericServices;

import lv.initex.database.GenericServicesRepository;
import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.Competitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class InitCBoxCompetitors {

    @Autowired
    private GenericServicesRepository database;

    public void init(JComboBox cBoxCompetitors) {
        try {
            cBoxCompetitors.removeAllItems();
            List<Competitor> competitorList = database.competitorList();
            cBoxCompetitors.addItem(new ComboBoxItem<Competitor>(new Competitor(), ""));
            for (Competitor competitor : competitorList) {
                cBoxCompetitors.addItem(new ComboBoxItem<Competitor>(competitor, competitor.getCompetitorName()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR creating competitor comboBox");
        }
    }
}
