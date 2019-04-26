package lv.initex.competitionEvent.services;

import lv.initex.competitionEvent.CompetitionEventView;
import lv.initex.database.CompetitionEventRepository;
import lv.initex.domain.CompetitionEvent;
import lv.initex.eventRegistry.singleRegistry.EventSingleRegistryView;
import lv.initex.genericServices.InitCBoxEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteEvent {

    @Autowired
    private CompetitionEventRepository database;

    @Autowired
    private EventSingleRegistryView viewSingleRegistry;

    @Autowired
    private InitCBoxEvent initEvent;

    public void execute(CompetitionEventView view) {
        int i = view.getTableEvent().getSelectedRow();
        if (i != -1) {
            String deleteEventName = view.getModel().getValueAt(view.getTableEvent().getSelectedRow(), 1).toString();
            CompetitionEvent competitionEvent = database.findEventByName(deleteEventName).get();
            competitionEvent.setDeleted(true);
            database.updateEvent(competitionEvent);
            initEvent.init(viewSingleRegistry.getComboBoxEvent());
            view.getModel().removeRow(i);
        }
    }
}
