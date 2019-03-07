package lv.timing.race.teamRace.processTeamRace;

import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SubEvent;
import lv.timing.race.teamRace.abstractClass.TeamModel;
import lv.timing.race.teamRace.abstractClass.TeamView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class TeamRaceView extends TeamView {

    @Autowired
    private TeamRaceModel model;

    public TeamRaceView() {

        //Create frame
        frame = new JInternalFrame("Team race");
        frame.setResizable(false);
        frame.setBounds(100, 100, 1182, 353);
        frame.getContentPane().setLayout(null);
        frame.setClosable(true);

        //Create components
        lblEvent = new JLabel("Event");
        lblGroup = new JLabel("SubEvent");
        lblRepeatRun = new JLabel("Repeat run");
        scrollPane = new JScrollPane();
        resultTable = new JTable();
        comboBoxEvent = new JComboBox<ComboBoxItem<CompetitionEvent>>();
        comboBoxSubEvent = new JComboBox<ComboBoxItem<SubEvent>>();
        btnDeleteRow = new JButton("Delete row");
        btnDeleteDone = new JButton("Delete result");
        txtBibToDelete = new JTextField();

        //Layout components
        lblEvent.setHorizontalAlignment(SwingConstants.RIGHT);
        lblEvent.setBounds(40, 16, 62, 14);
        frame.add(lblEvent);

        lblGroup.setHorizontalAlignment(SwingConstants.RIGHT);
        lblGroup.setBounds(40, 52, 62, 14);
        frame.add(lblGroup);

        scrollPane.setBounds(10, 96, 1148, 197);
        frame.add(scrollPane);

        resultTable.setFont(new Font("Arial", Font.PLAIN, 12));
        scrollPane.setViewportView(resultTable);


        comboBoxEvent.setBounds(150, 11, 207, 25);
        frame.add(comboBoxEvent);


        comboBoxSubEvent.setBounds(150, 47, 207, 25);
        frame.add(comboBoxSubEvent);


        btnDeleteRow.setFont(new Font("Arial", Font.PLAIN, 12));
        btnDeleteRow.setBounds(417, 62, 110, 23);
        frame.add(btnDeleteRow);


        txtBibToDelete.setBounds(650, 33, 62, 25);
        frame.add(txtBibToDelete);
        txtBibToDelete.setColumns(10);

        lblRepeatRun.setBounds(650, 11, 62, 14);
        frame.add(lblRepeatRun);

        btnDeleteDone.setFont(new Font("Arial", Font.PLAIN, 12));
        btnDeleteDone.setBounds(630, 62, 110, 23);
        frame.add(btnDeleteDone);
    }

    @Override
    public TeamModel getModel() {
        return model;
    }

    @Override
    public void setModel(TeamModel model) {
        this.model = (TeamRaceModel) model;
    }

}
