package lv.timing.competitors.services;

import lv.timing.competitors.CompetitorsModel;
import lv.timing.competitors.CompetitorsView;
import lv.timing.database.CompetitorRepository;
import lv.timing.domain.Competitor;
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
public class InitCompetitorsModelTest {

    private List<Competitor> list;
    private Competitor competitor;
    private CompetitorsView view;
    private CompetitorsModel model;

    @Mock
    CompetitorRepository database;

    @InjectMocks
    InitCompetitorsModel service;

    @Before
    public void init() {
        competitor = new Competitor(new Long(1), "Initex", 2001, "VSA", "LVA", false);
        list = new ArrayList<>();
        list.add(competitor);
        view = new CompetitorsView();
        model = new CompetitorsModel();
        view.setModel(model);
    }

    @Test
    public void verifyThatDatabaseCalledOnce() {
        Mockito.when(database.competitorList()).thenReturn(list);
        service.init(view);
        verify(database, times(1)).competitorList();
    }

    @Test
    public void verifyThatRecordAddedToModel() {
        Mockito.when(database.competitorList()).thenReturn(list);
        service.init(view);
        assertEquals(1, model.getRowCount());
    }
}