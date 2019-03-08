package lv.timing.competitionEvent.services;

import lv.timing.competitionEvent.CompetitionEventView;
import lv.timing.database.CompetitionEventRepository;
import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.CompetitionFormat;
import lv.timing.eventRegistry.singleRegistry.EventSingleRegistryView;
import lv.timing.eventRegistry.teamRegistry.EventTeamRegistryView;
import lv.timing.genericServices.InitCBoxEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AddEvent {

    @Autowired
    private CompetitionEventRepository database;

    @Autowired
    private InitEventModel InitEventModel;

    @Autowired
    private EventSingleRegistryView eventSingleRegistryView;

    @Autowired
    private EventTeamRegistryView eventTeamRegistryView;

    @Autowired
    private InitCBoxEvent initEvent;


    public void execute(CompetitionEventView view) {
        List<Object> valueList = Arrays.asList(view.getTextField().getText()
                , getEventObjectFromSelection(view), view.getTextFieldPlace().getText());
        CompetitionEvent competitionEvent = new CompetitionEvent(valueList);

        database.addEvent(competitionEvent);
        InitEventModel.init(view);
        resetTextBoxes(view);
        initEvent.init(eventSingleRegistryView.getComboBoxEvent());
        initEvent.init(eventTeamRegistryView.getComboBoxEvent());
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
