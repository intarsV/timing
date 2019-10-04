package lv.initex.competitionEvent.services;

import lv.initex.competitionEvent.CompetitionEventView;
import lv.initex.database.CompetitionEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.TableModelEvent;

@Service
public class EventServiceDispatcher {

    private CompetitionEventRepository database;
    private UpdateEvent updateEvent = new UpdateEvent();
    private DeleteEvent deleteEvent = new DeleteEvent();
    private InitCBoxFormat initCBoxFormat = new InitCBoxFormat();
    private AddEvent addEvent = new AddEvent();

    @Autowired
    public EventServiceDispatcher(CompetitionEventRepository database) {
        this.database = database;
    }

    public void initModel(CompetitionEventView view) {
        InitEventModel.init(view, database);
    }

    public void addEvent(CompetitionEventView view) {
        addEvent.execute(view, database);
    }

    public void updateEvent(TableModelEvent tme, CompetitionEventView view) {
        updateEvent.execute(tme, view, database);
    }

    public void deleteEvent(CompetitionEventView view) {
        deleteEvent.execute(view, database);
    }

    public void iniCBoxFormat(CompetitionEventView view) {
        initCBoxFormat.initComboBoxFormat(view, database);
    }

}
