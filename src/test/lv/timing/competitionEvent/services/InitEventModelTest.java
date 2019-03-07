package lv.timing.competitionEvent.services;

import lv.timing.competitionEvent.CompetitionEventModel;
import lv.timing.competitionEvent.CompetitionEventView;
import lv.timing.database.CompetitionEventRepository;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.CompetitionFormat;
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
public class InitEventModelTest {

    private List<CompetitionEvent> eventList;
    private CompetitionEventView view;
    private CompetitionEventModel model;
    private CompetitionEvent event;

    @Mock
    CompetitionEventRepository database;

    @InjectMocks
    InitEventModel service;

    @Before
    public void init() {
        CompetitionFormat formatOne = new CompetitionFormat(new Long(1), "formatOne");
        event = new CompetitionEvent(new Long(1), "olympicGames", formatOne, "Track", false);
        eventList = new ArrayList<>();
        eventList.add(event);
        view = new CompetitionEventView();
        model = new CompetitionEventModel();
        view.setModel(model);
    }

    @Test
    public void verifyThatDatabaseCalledOnce() {
        Mockito.when(database.eventList()).thenReturn(eventList);
        service.init(view);
        verify(database, times(1)).eventList();
    }

    @Test
    public void verifyThatRecordAddedToModel() {
        Mockito.when(database.eventList()).thenReturn(eventList);
        service.init(view);
        assertEquals(1, view.getModel().getRowCount());
    }
}