package lv.timing.competitors.services;

import lv.timing.Error;
import lv.timing.competitors.CompetitorsView;
import lv.timing.competitors.validation.CompetitorValidator;
import lv.timing.database.CompetitorRepository;
import lv.timing.domain.Competitor;
import lv.timing.eventRegistry.singleRegistry.EventSingleRegistryView;
import lv.timing.eventRegistry.teamRegistry.EventTeamRegistryView;
import lv.timing.genericServices.InitCBoxCompetitors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

@Service
public class AddCompetitor {

    @Autowired
    private CompetitorRepository database;

    @Autowired
    private CompetitorValidator validator;

    @Autowired
    private InitCompetitorsModel initCompetitorsModel;

    @Autowired
    private EventSingleRegistryView eventSingleRegistryView;

    @Autowired
    private EventTeamRegistryView eventTeamRegistryView;

    @Autowired
    private InitCBoxCompetitors initCBoxCompetitors;

    public void execute(CompetitorsView view) {
        List<Object> valueList = Arrays.asList(view.getTextFieldName().getText()
                , view.getTextField_Year().getText()
                , view.getTextFieldClub().getText()
                , view.getComboBoxCountry().getSelectedItem().toString());

        List<Error> errors = validator.validate(valueList);

        if (errors.isEmpty()) {
            Competitor competitor = new Competitor(valueList);
            database.addCompetitor(competitor);
            initCompetitorsModel.init(view);
            resetTextBoxes(view);
            initCBoxCompetitors.init(eventSingleRegistryView.getComboBoxCompetitor());
            initCBoxCompetitors.init(eventTeamRegistryView.getComboBoxCompetitorOne());
            initCBoxCompetitors.init(eventTeamRegistryView.getComboBoxCompetitorTwo());
            initCBoxCompetitors.init(eventTeamRegistryView.getComboBoxCompetitorThree());
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
