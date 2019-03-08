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

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DeleteCompetitorTest {

    private Competitor competitor;
    private CompetitorsView view;
    private CompetitorsModel model;

    @Mock
    CompetitorRepository database;

    @InjectMocks
    DeleteCompetitor service;

    @Before
    public void init() {
        competitor = new Competitor(new Long(1), "Initex", 2001, "VSA", "LVA", false);
        view = new CompetitorsView();
        model = new CompetitorsModel();
        Object[] o = {1, "Initex", 2001, "VSA", "LVA", false};
        model.addRow(o);
        view.setModel(model);
        view.formatTable();
        view.getCompetitorsTable().setRowSelectionInterval(0, 0);
    }

    @Test
    public void verifyThatDatabaseUpdateCalledOne() {
        Mockito.when(database.findCompetitorByName("Initex")).thenReturn(Optional.ofNullable(competitor));
        Mockito.when(database.updateCompetitor(competitor)).thenReturn(true);
        service.execute(view);
        verify(database,times(1)).updateCompetitor(competitor);
    }

    @Test
    public void verifyThatDatabaseFindCalledOne() {
        Mockito.when(database.findCompetitorByName("Initex")).thenReturn(Optional.ofNullable(competitor));
        Mockito.when(database.updateCompetitor(competitor)).thenReturn(true);
        service.execute(view);
        verify(database, times(1)).findCompetitorByName("Initex");
    }

    @Test
    public void verifyRecordRemovedFromModel() {
        Mockito.when(database.findCompetitorByName("Initex")).thenReturn(Optional.ofNullable(competitor));
        Mockito.when(database.updateCompetitor(competitor)).thenReturn(true);
        service.execute(view);
        assertEquals(0, view.getModel().getRowCount());
    }

}