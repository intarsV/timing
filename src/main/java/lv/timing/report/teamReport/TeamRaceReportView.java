package lv.timing.report.teamReport;

import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SubEvent;
import lv.timing.domain.TeamBoatClass;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class TeamRaceReportView {


    private JInternalFrame frame;
    private JComboBox<ComboBoxItem<CompetitionEvent>> comboBoxEvent;
    private JComboBox<ComboBoxItem<SubEvent>> comboBoxSubEvent;
    private JComboBox<ComboBoxItem<TeamBoatClass>> comboBoxClass;
    private JButton btnHeatResultsList;
    private JButton btnStartList;

    public TeamRaceReportView() {

        //Create frame
        frame = new JInternalFrame("Team race reports");
        frame.setResizable(false);
        frame.setBounds(100, 100, 413, 307);
        frame.getContentPane().setLayout(null);
        frame.setClosable(true);

        //Create components;

        comboBoxEvent = new JComboBox<ComboBoxItem<CompetitionEvent>>();
        comboBoxSubEvent = new JComboBox<ComboBoxItem<SubEvent>>();
        comboBoxClass = new JComboBox<ComboBoxItem<TeamBoatClass>>();
        btnHeatResultsList = new JButton("Preview heat results");
        btnStartList = new JButton("Start List");

        //Layout components
        comboBoxEvent.setBounds(160, 12, 207, 25);
        frame.add(comboBoxEvent);

        comboBoxSubEvent.setBounds(160, 48, 207, 25);
        frame.add(comboBoxSubEvent);

        comboBoxClass.setBounds(160, 84, 207, 25);
        frame.add(comboBoxClass);

        btnStartList.setFont(new Font("Arial", Font.PLAIN, 12));
        btnStartList.setBounds(10, 12, 140, 25);
        frame.add(btnStartList);

        btnHeatResultsList.setFont(new Font("Arial", Font.PLAIN, 12));
        btnHeatResultsList.setBounds(10, 47, 140, 25);
        frame.add(btnHeatResultsList);
    }

    public JInternalFrame getFrame() {
        return frame;
    }

    public void setFrame(JInternalFrame frame) {
        this.frame = frame;
    }

    public JComboBox<ComboBoxItem<CompetitionEvent>> getComboBoxEvent() {
        return comboBoxEvent;
    }

    public void setComboBoxEvent(JComboBox<ComboBoxItem<CompetitionEvent>> comboBoxEvent) {
        this.comboBoxEvent = comboBoxEvent;
    }

    public JComboBox getComboBoxSubEvent() {
        return comboBoxSubEvent;
    }

    public void setComboBoxSubEvent(JComboBox comboBoxSubEvent) {
        this.comboBoxSubEvent = comboBoxSubEvent;
    }

    public JComboBox<ComboBoxItem<TeamBoatClass>> getComboBoxClass() {
        return comboBoxClass;
    }

    public void setComboBoxClass(JComboBox<ComboBoxItem<TeamBoatClass>> comboBoxClass) {
        this.comboBoxClass = comboBoxClass;
    }

    public JButton getBtnHeatResultsList() {
        return btnHeatResultsList;
    }

    public void setBtnHeatResultsList(JButton btnHeatResultsList) {
        this.btnHeatResultsList = btnHeatResultsList;
    }

    public JButton getBtnStartList() {
        return btnStartList;
    }

    public void setBtnStartList(JButton btnStartList) {
        this.btnStartList = btnStartList;
    }

}
