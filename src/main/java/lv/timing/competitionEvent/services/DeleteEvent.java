package lv.timing.competitionEvent.services;

import lv.timing.competitionEvent.CompetitionEventView;
import lv.timing.database.CompetitionEventRepository;
import lv.timing.domain.CompetitionEvent;
import lv.timing.eventRegistry.singleRegistry.EventSingleRegistryView;
import lv.timing.genericServices.InitCBoxEvent;
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
