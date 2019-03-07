package lv.timing.competitionEvent.services;

import lv.timing.competitionEvent.CompetitionEventView;
import lv.timing.database.CompetitionEventRepository;
import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.CompetitionFormat;
import lv.timing.eventRegistry.singleRegistry.EventSingleRegistryView;
import lv.timing.genericServices.InitCBoxEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InsertEvent {

    @Autowired
    private CompetitionEventRepository database;

    @Autowired
    private GetEventList getEventList;

    @Autowired
    private EventSingleRegistryView viewSingleRegistry;

    @Autowired
    private InitCBoxEvent initEvent;



    public void execute(CompetitionEventView view) {
        List<Object> valueList = Arrays.asList(view.getTextField().getText()
                , getEventObjectFromSelection(view), view.getTextFieldPlace().getText());
        CompetitionEvent competitionEvent = new CompetitionEvent(valueList);

        database.addEvent(competitionEvent);
        getEventList.getCompetitionEventList(view);
        resetTextBoxes(view);
        initEvent.init(viewSingleRegistry.getComboBoxEvent());
    }

    private CompetitionFormat getEventObjectFromSelection(CompetitionEventView view) {
        ComboBoxItem item = (ComboBoxItem) view.getComboBoxFormat().getSelectedItem();
        return (CompetitionFormat) item.getValue();
    }

    private void resetTextBoxes(CompetitionEventView view) {
        view.getTextField().setText(null);
        view.getTextFieldPlace().setText(null);
        view.getComboBoxFormat().setSelectedIndex(-1);
    }
}
