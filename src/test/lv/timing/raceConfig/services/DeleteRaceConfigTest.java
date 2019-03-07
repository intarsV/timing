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

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DeleteRaceConfigTest {

    private CompetitionEvent event;
    private RaceConfig raceConfig;
    private RaceConfigView view;
    private RaceConfigModel model;

    @Mock
    RaceConfigRepository database;

    @InjectMocks
    DeleteRaceConfig service;

    @Before
    public void init() {
        CompetitionFormat formatOne = new CompetitionFormat(new Long(1), "formatOne");
        SingleBoatClass boatClass = new SingleBoatClass(new Long(1), "C1Woman", false);
        event = new CompetitionEvent(new Long(1), "olympicGames", formatOne, "Track", false);
        raceConfig = new RaceConfig(new Long(1), event, boatClass, 1, 1, 1);
        view = new RaceConfigView();
        model = new RaceConfigModel();
        Object[] o = {1, event, boatClass, boatClass.getBoatClass(), 1, 1, 1};
        model.addRow(o);
        view.setModel(model);
        view.formatTable();
        view.getRaceConfigTable().setRowSelectionInterval(0, 0);
    }

    @Test
    public void verifyThatDatabaseFindCalledOnce() {
        Mockito.when(database.findRaceConfigById(new Long(1))).thenReturn(Optional.ofNullable(raceConfig));
        Mockito.when(database.deleteRaceConfig(raceConfig)).thenReturn(true);
        service.execute(view);
        verify(database, times(1)).findRaceConfigById(new Long(1));
    }

    @Test
    public void verifyThatDatabaseDeleteCalledOnce() {
        Mockito.when(database.findRaceConfigById(new Long(1))).thenReturn(Optional.ofNullable(raceConfig));
        Mockito.when(database.deleteRaceConfig(raceConfig)).thenReturn(true);
        service.execute(view);
        verify(database,times(1)).deleteRaceConfig(raceConfig);
    }

    @Test
    public void verifyRecordRemovedFromModel() {
        Mockito.when(database.findRaceConfigById(new Long(1))).thenReturn(Optional.ofNullable(raceConfig));
        Mockito.when(database.deleteRaceConfig(raceConfig)).thenReturn(true);
        service.execute(view);
        assertEquals(0, view.getModel().getRowCount());
    }
}