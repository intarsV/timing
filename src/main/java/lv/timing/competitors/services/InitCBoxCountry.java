package lv.timing.competitors.services;

import lv.timing.competitors.CompetitorsView;
import lv.timing.database.CompetitorRepository;
import lv.timing.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class InitCBoxCountry {

    @Autowired
    private CompetitorRepository database;

    public void initComboBoxCountry(CompetitorsView view) {
        try {
            view.getComboBoxCountry().removeAllItems();
            List<Country> countryList = database.countryList();
            view.getComboBoxCountry().addItem("");
            for (Country country : countryList) {
                view.getComboBoxCountry().addItem(country.getCountry());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR creating ComboBox");
        }
    }
}
