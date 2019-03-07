package lv.timing.race.teamRace.editTeamRace;

import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SubEvent;
import lv.timing.race.teamRace.abstractClass.TeamModel;
import lv.timing.race.teamRace.abstractClass.TeamView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

@Component
public class EditTeamRaceView extends TeamView {

    @Autowired
    private EditTeamRaceModel model;

    public EditTeamRaceView() {
        //Create frame
        frame = new JInternalFrame("Edit team race data");
        frame.setResizable(false);
        frame.setBounds(100, 100, 1182, 587);
        frame.getContentPane().setLayout(null);
        frame.setClosable(true);

        //Create components
        scrollPane = new JScrollPane();
        resultTable = new JTable();
        comboBoxEvent = new JComboBox<ComboBoxItem<CompetitionEvent>>();
        comboBoxSubEvent = new JComboBox<ComboBoxItem<SubEvent>>();
        btnDeleteRow = new JButton("Delete row");

        //Layout components

        scrollPane.setBounds(10, 96, 1148, 442);
        frame.add(scrollPane);

        resultTable.setFont(new Font("Arial", Font.PLAIN, 12));
        scrollPane.setViewportView(resultTable);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        comboBoxEvent.setBounds(76, 11, 276, 25);
        frame.add(comboBoxEvent);

        comboBoxSubEvent.setBounds(76, 42, 276, 25);
        frame.add(comboBoxSubEvent);

        btnDeleteRow.setBounds(433, 12, 100, 23);
        frame.add(btnDeleteRow);
    }

    @Override
    public TeamModel getModel() {
        return model;
    }

    @Override
    public void setModel(TeamModel model) {
        this.model = (EditTeamRaceModel) model;
    }
}