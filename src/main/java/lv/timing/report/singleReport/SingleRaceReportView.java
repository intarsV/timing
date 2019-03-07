package lv.timing.report.singleReport;

import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SingleBoatClass;
import lv.timing.domain.SubEvent;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class SingleRaceReportView {

    private JInternalFrame frame;
    private JComboBox<ComboBoxItem<CompetitionEvent>> comboBoxEvent;
    private JComboBox<ComboBoxItem<SubEvent>> comboBoxSubEvent;
    private JComboBox<ComboBoxItem<SingleBoatClass>> comboBoxClass;
    private JButton btnHeatResultsList;
    private JButton btnGrandTotal;
    private JButton btnStartList;
    private JButton btnGrandTotalGroups;

    public SingleRaceReportView() {

        //Create frame
        frame = new JInternalFrame("Reports");
        frame.setResizable(false);
        frame.setBounds(100, 100, 413, 307);
        frame.getContentPane().setLayout(null);
        frame.setClosable(true);

        //Create components;
        comboBoxEvent = new JComboBox<ComboBoxItem<CompetitionEvent>>();
        comboBoxSubEvent = new JComboBox<ComboBoxItem<SubEvent>>();
        comboBoxClass = new JComboBox<ComboBoxItem<SingleBoatClass>>();
        btnHeatResultsList = new JButton("Preview heat results");
        btnGrandTotal = new JButton("GrandTotal");
        btnStartList = new JButton("Start List");
        btnGrandTotalGroups = new JButton("GrandTotal Groups");

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

        btnGrandTotal.setFont(new Font("Arial", Font.PLAIN, 12));
        btnGrandTotal.setBounds(10, 84, 140, 25);
        frame.add(btnGrandTotal);

        btnGrandTotalGroups.setFont(new Font("Arial", Font.PLAIN, 12));
        btnGrandTotalGroups.setBounds(10, 118, 140, 25);
        frame.add(btnGrandTotalGroups);
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

    public JComboBox<ComboBoxItem<SubEvent>> getComboBoxSubEvent() {
        return comboBoxSubEvent;
    }

    public void setComboBoxSubEvent(JComboBox<ComboBoxItem<SubEvent>> comboBoxSubEvent) {
        this.comboBoxSubEvent = comboBoxSubEvent;
    }

    public JComboBox<ComboBoxItem<SingleBoatClass>> getComboBoxClass() {
        return comboBoxClass;
    }

    public void setComboBoxClass(JComboBox<ComboBoxItem<SingleBoatClass>> comboBoxClass) {
        this.comboBoxClass = comboBoxClass;
    }

    public JButton getBtnHeatResultsList() {
        return btnHeatResultsList;
    }

    public void setBtnHeatResultsList(JButton btnHeatResultsList) {
        this.btnHeatResultsList = btnHeatResultsList;
    }

    public JButton getBtnGrandTotal() {
        return btnGrandTotal;
    }

    public void setBtnGrandTotal(JButton btnGrandTotal) {
        this.btnGrandTotal = btnGrandTotal;
    }

    public JButton getBtnStartList() {
        return btnStartList;
    }

    public void setBtnStartList(JButton btnStartList) {
        this.btnStartList = btnStartList;
    }

    public JButton getBtnGrandTotalGroups() {
        return btnGrandTotalGroups;
    }

    public void setBtnGrandTotalGroups(JButton btnGrandTotalGroups) {
        this.btnGrandTotalGroups = btnGrandTotalGroups;
    }
}
