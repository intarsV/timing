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
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class InitRaceConfigModelTest {

    private CompetitionEvent event;
    private RaceConfig raceConfig;
    private List<RaceConfig> list;
    private RaceConfigView view;
    private RaceConfigModel model;

    @Mock
    RaceConfigRepository database;

    @InjectMocks
    InitRaceConfigModel service;

    @Before
    public void init() {
        CompetitionFormat formatOne = new CompetitionFormat(new Long(1), "formatOne");
        SingleBoatClass boatClass = new SingleBoatClass(new Long(1), "C1Woman", false);
        event = new CompetitionEvent(new Long(1), "olympicGames", formatOne, "Track", false);
        raceConfig = new RaceConfig(new Long(1), event, boatClass, 1, 1, 1);
        view = new RaceConfigView();
        model = new RaceConfigModel();
        view.setModel(model);
        view.getComboBoxEvent().addItem(new ComboBoxItem<CompetitionEvent>(new CompetitionEvent(), ""));
        view.getComboBoxEvent().addItem(new ComboBoxItem<CompetitionEvent>(event, event.getEventName()));
        view.getComboBoxEvent().setSelectedIndex(1);
        list = new ArrayList<>();
        list.add(raceConfig);
    }

    @Test
    public void verifyThatRecordAddedToModel() {
        Mockito.when(database.raceConfigList(event)).thenReturn(list);
        service.init(view);
        assertEquals(1, view.getModel().getRowCount());
    }

    @Test
    public void verifyThatDatabaseCalledOnce() {
        Mockito.when(database.raceConfigList(event)).thenReturn(list);
        service.init(view);
        verify(database, times(1)).raceConfigList(event);
    }
}