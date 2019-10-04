package lv.initex.competitors.services;

import lv.initex.Error;
import lv.initex.competitors.CompetitorsView;
import lv.initex.competitors.validation.CompetitorValidator;
import lv.initex.competitors.validation.CompetitorValidatorImpl;
import lv.initex.database.CompetitorRepository;
import lv.initex.domain.Competitor;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;


public class AddCompetitor {

    private CompetitorValidator validator = new CompetitorValidatorImpl();

    public void execute(CompetitorsView view, CompetitorRepository database) {
        List<Object> valueList = Arrays.asList(view.getTextFieldName().getText()
                , view.getTextField_Year().getText()
                , view.getTextFieldClub().getText()
                , view.getComboBoxCountry().getSelectedItem().toString());

        List<Error> errors = validator.validate(valueList, database);

        if (errors.isEmpty()) {
            Competitor competitor = new Competitor(valueList);
            database.addCompetitor(competitor);
            InitCompetitorsModel.init(view, database);
            resetTextBoxes(view);
//            initCBoxCompetitors.init(eventSingleRegistryView.getComboBoxCompetitor());
//            initCBoxCompetitors.init(eventTeamRegistryView.getComboBoxCompetitorOne());
//            initCBoxCompetitors.init(eventTeamRegistryView.getComboBoxCompetitorTwo());
//            initCBoxCompetitors.init(eventTeamRegistryView.getComboBoxCompetitorThree());
        } else {
            JOptionPane.showMessageDialog(null, errors.get(0).getDescription());
        }
    }

    private void resetTextBoxes(CompetitorsView view) {
        view.getTextFieldName().setText(null);
        view.getTextFieldClub().setText(null);
        view.getTextField_Year().setText(null);
        view.getComboBoxCountry().setSelectedIndex(-1);
    }
}
