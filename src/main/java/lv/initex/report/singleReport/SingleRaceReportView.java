package lv.initex.report.singleReport;

import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.SingleBoatClass;
import lv.initex.domain.SubEvent;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
    private JLabel lblStartListTime;
    private JSeparator separator;
    private JLabel lblStartTime;
    private JLabel lblSplit;
    private JFormattedTextField startTime;
    private JFormattedTextField splitTime;
    private DateFormat startFormat;
    private DateFormat splitFormat;

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
        lblStartListTime = new JLabel("Start list time");
        separator = new JSeparator();
        lblSplit = new JLabel("split(min:sec)");
        lblStartTime = new JLabel("time(hours:min)");
        startFormat = new SimpleDateFormat("HH:mm");
        splitFormat = new SimpleDateFormat("mm:ss");
        startTime = new JFormattedTextField(startFormat);
        splitTime = new JFormattedTextField(splitFormat);

        //Layout components
        comboBoxEvent.setBounds(170, 12, 207, 25);
        frame.add(comboBoxEvent);

        comboBoxSubEvent.setBounds(170, 48, 207, 25);
        frame.add(comboBoxSubEvent);

        comboBoxClass.setBounds(170, 84, 207, 25);
        frame.add(comboBoxClass);

        btnStartList.setFont(new Font("Arial", Font.PLAIN, 12));
        btnStartList.setBounds(10, 12, 150, 25);
        frame.add(btnStartList);

        btnHeatResultsList.setFont(new Font("Arial", Font.PLAIN, 12));
        btnHeatResultsList.setBounds(10, 47, 150, 25);
        frame.add(btnHeatResultsList);

        btnGrandTotal.setFont(new Font("Arial", Font.PLAIN, 12));
        btnGrandTotal.setBounds(10, 84, 150, 25);
        frame.add(btnGrandTotal);

        btnGrandTotalGroups.setFont(new Font("Arial", Font.PLAIN, 12));
        btnGrandTotalGroups.setBounds(10, 118, 150, 25);
        frame.add(btnGrandTotalGroups);

        lblStartListTime.setBounds(10, 200, 107, 16);
        frame.add(lblStartListTime);

        separator.setBounds(10, 218, 180, 2);
        frame.add(separator);

        lblStartTime.setBounds(10, 218, 90, 16);
        frame.add(lblStartTime);

        lblSplit.setBounds(110, 218, 90, 16);
        frame.add(lblSplit);

        startTime.setBounds(10, 237, 90, 22);
        frame.add(startTime);

        splitTime.setBounds(110, 237, 90, 22);
        frame.add(splitTime);
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

    public JFormattedTextField getStartTime() {
        return startTime;
    }

    public void setStartTime(JFormattedTextField startTime) {
        this.startTime = startTime;
    }

    public JFormattedTextField getSplitTime() {
        return splitTime;
    }

    public void setSplitTime(JFormattedTextField splitTime) {
        this.splitTime = splitTime;
    }
}
