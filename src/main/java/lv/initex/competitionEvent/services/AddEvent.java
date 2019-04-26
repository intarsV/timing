package lv.initex.competitionEvent.services;

import lv.initex.competitionEvent.CompetitionEventView;
import lv.initex.database.CompetitionEventRepository;
import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.CompetitionFormat;
import lv.initex.eventRegistry.singleRegistry.EventSingleRegistryView;
import lv.initex.eventRegistry.teamRegistry.EventTeamRegistryView;
import lv.initex.genericServices.InitCBoxEvent;
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
