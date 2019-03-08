package lv.timing.raceConfig.services;

import lv.timing.database.RaceConfigRepository;
import lv.timing.domain.*;
import lv.timing.raceConfig.RaceConfigModel;
import lv.timing.raceConfig.RaceConfigView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddRaceConfigTest {

    private CompetitionEvent event;
    private RaceConfigView view;
    private RaceConfigModel model;

    @Mock
    RaceConfigRepository database;

    @Mock
    RefreshRaceConfigModel refresh;

    @InjectMocks
    AddRaceConfig service;

    @Before
    public void init() {
        CompetitionFormat formatOne = new CompetitionFormat(new Long(1), "formatOne");
        SingleBoatClass boatClass = new SingleBoatClass(new Long(1), "C1Woman", false);
        event = new CompetitionEvent(new Long(1), "olympicGames", formatOne, "Track", false);
        view = new RaceConfigView();
        model = new RaceConfigModel();
        view.setModel(model);
        view.getComboBoxEvent().addItem(new ComboBoxItem<CompetitionEvent>(new CompetitionEvent(), ""));
        view.getComboBoxEvent().addItem(new ComboBoxItem<CompetitionEvent>(event, event.getEventName()));
        view.getComboBoxEvent().setSelectedIndex(1);
        view.getComboBoxClass().addItem(new ComboBoxItem<SingleBoatClass>(new SingleBoatClass(), ""));
        view.getComboBoxClass().addItem(new ComboBoxItem<SingleBoatClass>(boatClass, boatClass.getBoatClass()));
        view.getComboBoxClass().setSelectedIndex(1);
        view.getTextFieldH1().setText("1");
        view.getTextFieldH2().setText("1");
        view.getTextFieldSf().setText("1");
    }

    @Test
    public void verifyThatRefreshIsCalled() {
        service.execute(view);
        verify(refresh, times(1)).refresh();
    }

    @Test
    public void verifyThatDatabaseCalledOnce() {
        service.execute(view);
        verify(database).addRaceConfig(any(RaceConfig.class));
    }
}