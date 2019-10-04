package lv.initex.competitionEvent.services;

import lv.initex.competitionEvent.CompetitionEventView;
import lv.initex.database.CompetitionEventRepository;
import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.CompetitionFormat;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class AddEvent {

    public void execute(CompetitionEventView view, CompetitionEventRepository database) {
        List<Object> valueList = Arrays.asList(view.getTextField().getText()
                , getEventObjectFromSelection(view), view.getTextFieldPlace().getText());
        CompetitionEvent competitionEvent = new CompetitionEvent(valueList);

        database.addEvent(competitionEvent);
        InitEventModel.init(view, database);
        resetTextBoxes(view);
//        initEvent.init(eventSingleRegistryView.getComboBoxEvent());
//        initEvent.init(eventTeamRegistryView.getComboBoxEvent());
    }

    private CompetitionFormat getEventObjectFromSelection(CompetitionEventView view) {
        ComboBoxItem item = (ComboBoxItem) view.getComboBoxFormat().getSelectedItem();
        return (CompetitionFormat) Objects.requireNonNull(item).getValue();
    }

    private void resetTextBoxes(CompetitionEventView view) {
        view.getTextField().setText(null);
        view.getTextFieldPlace().setText(null);
        view.getComboBoxFormat().setSelectedIndex(-1);
    }
}
