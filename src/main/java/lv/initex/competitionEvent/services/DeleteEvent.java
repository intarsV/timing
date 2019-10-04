package lv.initex.competitionEvent.services;

import lv.initex.competitionEvent.CompetitionEventView;
import lv.initex.database.CompetitionEventRepository;
import lv.initex.domain.CompetitionEvent;

public class DeleteEvent {

    public void execute(CompetitionEventView view,CompetitionEventRepository database) {
        int i = view.getTableEvent().getSelectedRow();
        if (i != -1) {
            String deleteEventName = view.getModel().getValueAt(view.getTableEvent().getSelectedRow(), 1).toString();
            CompetitionEvent competitionEvent = database.findEventByName(deleteEventName).get();
            competitionEvent.setDeleted(true);
            database.updateEvent(competitionEvent);
          //  initEvent.init(viewSingleRegistry.getComboBoxEvent());
            view.getModel().removeRow(i);
        }
    }
}
