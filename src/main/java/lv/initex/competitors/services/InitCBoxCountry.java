package lv.initex.competitors.services;

import lv.initex.competitors.CompetitorsView;
import lv.initex.database.CompetitorRepository;
import lv.initex.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

//@Service
public class InitCBoxCountry {

//    @Autowired
//    private CompetitorRepository database;

    public void initComboBoxCountry(CompetitorsView view,CompetitorRepository database) {
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
