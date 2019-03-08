package lv.timing.competitors.services;

import lv.timing.competitors.CompetitorsModel;
import lv.timing.competitors.CompetitorsView;
import lv.timing.competitors.validation.CompetitorValidator;
import lv.timing.database.CompetitorRepository;
import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.Competitor;
import lv.timing.eventRegistry.singleRegistry.EventSingleRegistryView;
import lv.timing.eventRegistry.teamRegistry.EventTeamRegistryView;
import lv.timing.genericServices.InitCBoxCompetitors;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddCompetitorTest {

    private CompetitorsView view;
    private CompetitorsModel model;

    @Mock
    private CompetitorRepository database;

    @Mock
    private CompetitorValidator validator;

    @Mock
    private InitCompetitorsModel initCompetitorsModel;

    @Mock
    private EventSingleRegistryView eventSingleRegistryView;

    @Mock
    private EventTeamRegistryView eventTeamRegistryView;

    @Mock
    private InitCBoxCompetitors initCBoxCompetitors;

    @InjectMocks
    AddCompetitor service;

    @Before
    public void init() {
        view = new CompetitorsView();
        model = new CompetitorsModel();
        view.setModel(model);
        view.getTextFieldName().setText("Initex");
        view.getTextField_Year().setText("2001");
        view.getTextFieldClub().setText("VSA");
        view.getComboBoxCountry().addItem(" ");
        view.getComboBoxCountry().addItem("LVA");
        view.getComboBoxCountry().setSelectedIndex(1);
    }

    @Test
    public void verifyThatValidationCalled() {
        List<Object> valueList = Arrays.asList(view.getTextFieldName().getText()
                , view.getTextField_Year().getText(), view.getTextFieldClub().getText()
                ,  view.getComboBoxCountry().getSelectedItem());
        service.execute(view);
        verify(validator).validate(valueList);
    }

    @Test
    public void verifyThaInitModelIsCalled() {
        service.execute(view);
        verify(initCompetitorsModel, times(1)).init(view);
    }

    @Test
    public void verifyThatDatabaseCalledOnce() {
        service.execute(view);
        verify(database).addCompetitor(any(Competitor.class));
    }
}