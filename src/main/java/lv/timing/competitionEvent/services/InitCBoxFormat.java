package lv.timing.competitionEvent.services;

import lv.timing.competitionEvent.CompetitionEventView;
import lv.timing.database.CompetitionEventRepository;
import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.CompetitionFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class InitCBoxFormat {

    @Autowired
    private CompetitionEventRepository database;

    public void initComboBoxFormat(CompetitionEventView view) {
        try {
            view.getComboBoxFormat().removeAllItems();
            List<CompetitionFormat> competitionFormatList = database.competitionFormat();
            view.getComboBoxFormat().addItem(new ComboBoxItem<>(new CompetitionFormat(), ""));
            for (CompetitionFormat competitionFormat : competitionFormatList) {
                view.getComboBoxFormat().addItem(new ComboBoxItem<>(competitionFormat, competitionFormat.getFormatName()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR creating event ComboBox");
        }
    }
}
