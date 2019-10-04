package lv.initex.competitors.services;

import lv.initex.competitors.CompetitorsView;
import lv.initex.database.CompetitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.TableModelEvent;

@Service
public class CompetitorsServiceDispatcher {

    private CompetitorRepository database;
    private InitCBoxCountry initCBoxCountry = new InitCBoxCountry();
    private UpdateValuesCompetitors updateValuesCompetitors = new UpdateValuesCompetitors();
    private DeleteCompetitor deleteCompetitor = new DeleteCompetitor();
    private AddCompetitor addCompetitor = new AddCompetitor();

    @Autowired
    public CompetitorsServiceDispatcher(CompetitorRepository database) {
        this.database = database;
    }

    public void initModel(CompetitorsView view) {
        InitCompetitorsModel.init(view, database);
    }

    public void addCompetitor(CompetitorsView view) {
        addCompetitor.execute(view, database);
    }

    public void updateCompetitor(TableModelEvent tme, CompetitorsView view) {
        updateValuesCompetitors.execute(tme, view, database);
    }

    public void initInitCBoxCountry(CompetitorsView view) {
        initCBoxCountry.initComboBoxCountry(view, database);
    }

    public void deleteCompetitor(CompetitorsView view) {
        deleteCompetitor.execute(view, database);
    }
}
