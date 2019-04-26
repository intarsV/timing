package lv.initex.raceConfig;

import lv.initex.domain.SingleBoatClass;
import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.CompetitionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class RaceConfigView {

    @Autowired
    private RaceConfigModel model;

    private JInternalFrame frame;
    private JLabel lblEvent;
    private JLabel lblClass;
    private JLabel lblH;
    private JLabel lblH_1;
    private JLabel lblSf;
    private JComboBox<ComboBoxItem<CompetitionEvent>> comboBoxEvent;
    private JComboBox<ComboBoxItem<SingleBoatClass>> comboBoxClass;
    private JButton btnInsert;
    private JButton btnDelete;
    private JTextField textFieldH1;
    private JTextField textFieldH2;
    private JTextField textFieldSf;
    private JTable raceConfigTable;
    private JScrollPane scrollPane;


    public RaceConfigView() {
        //Create frame
        frame = new JInternalFrame("Race configuration");
        frame.setResizable(false);
        frame.setBounds(100, 100, 592, 300);
        frame.getContentPane().setLayout(null);
        frame.setClosable(true);

        //Create components
        lblEvent = new JLabel("Event");
        lblClass = new JLabel("Class");
        lblH = new JLabel("H1");
        lblH_1 = new JLabel("H2");
        lblSf = new JLabel("SF");
        textFieldH1 = new JTextField();
        textFieldH2 = new JTextField();
        textFieldSf = new JTextField();
        scrollPane = new JScrollPane();
        comboBoxEvent = new JComboBox<ComboBoxItem<CompetitionEvent>>();
        comboBoxClass = new JComboBox<ComboBoxItem<SingleBoatClass>>();
        btnInsert = new JButton("Insert");
        btnDelete = new JButton("Delete");
        raceConfigTable = new JTable();

        //Layout components

        lblEvent.setBounds(10, 26, 46, 14);
        frame.add(lblEvent);

        lblClass.setBounds(10, 57, 46, 14);
        frame.add(lblClass);

        textFieldH1.setBounds(105, 88, 86, 25);
        frame.add(textFieldH1);

        textFieldH2.setBounds(105, 124, 86, 25);
        frame.add(textFieldH2);

        textFieldSf.setBounds(105, 163, 86, 25);
        frame.add(textFieldSf);

        lblH.setBounds(50, 93, 46, 14);
        frame.add(lblH);

        lblH_1.setBounds(50, 129, 46, 14);
        frame.add(lblH_1);

        lblSf.setBounds(50, 168, 46, 14);
        frame.add(lblSf);


        scrollPane.setBounds(283, 50, 253, 180);
        frame.add(scrollPane);
        scrollPane.setViewportView(raceConfigTable);

        comboBoxEvent.setBounds(66, 21, 196, 25);
        frame.add(comboBoxEvent);

        comboBoxClass.setBounds(66, 52, 196, 25);
        frame.add(comboBoxClass);

        btnInsert.setBounds(102, 199, 89, 23);
        frame.add(btnInsert);

        btnDelete.setBounds(102, 228, 89, 23);
        frame.add(btnDelete);
    }

    public void formatTable() {
        raceConfigTable.setModel(model);

        //Remove unnecessary columns
        raceConfigTable.removeColumn(raceConfigTable.getColumnModel().getColumn(0));
        raceConfigTable.removeColumn(raceConfigTable.getColumnModel().getColumn(0));
        raceConfigTable.removeColumn(raceConfigTable.getColumnModel().getColumn(0));

        raceConfigTable.getColumnModel().getColumn(0).setPreferredWidth(130);
        raceConfigTable.getColumnModel().getColumn(0).setMaxWidth(130);
        raceConfigTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        raceConfigTable.getColumnModel().getColumn(1).setMaxWidth(40);
        raceConfigTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        raceConfigTable.getColumnModel().getColumn(2).setMaxWidth(40);
        raceConfigTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        raceConfigTable.getColumnModel().getColumn(3).setMaxWidth(40);
    }


    public RaceConfigModel getModel() {
        return model;
    }

    public void setModel(RaceConfigModel model) {
        this.model = model;
    }

    public JInternalFrame getFrame() {
        return frame;
    }

    public void setFrame(JInternalFrame frame) {
        this.frame = frame;
    }

    public JLabel getLblEvent() {
        return lblEvent;
    }

    public void setLblEvent(JLabel lblEvent) {
        this.lblEvent = lblEvent;
    }

    public JLabel getLblClass() {
        return lblClass;
    }

    public void setLblClass(JLabel lblClass) {
        this.lblClass = lblClass;
    }

    public JLabel getLblH() {
        return lblH;
    }

    public void setLblH(JLabel lblH) {
        this.lblH = lblH;
    }

    public JLabel getLblH_1() {
        return lblH_1;
    }

    public void setLblH_1(JLabel lblH_1) {
        this.lblH_1 = lblH_1;
    }

    public JLabel getLblSf() {
        return lblSf;
    }

    public void setLblSf(JLabel lblSf) {
        this.lblSf = lblSf;
    }

    public JComboBox getComboBoxEvent() {
        return comboBoxEvent;
    }

    public void setComboBoxEvent(JComboBox comboBoxEvent) {
        this.comboBoxEvent = comboBoxEvent;
    }

    public JComboBox getComboBoxClass() {
        return comboBoxClass;
    }

    public void setComboBoxClass(JComboBox comboBoxClass) {
        this.comboBoxClass = comboBoxClass;
    }

    public JButton getBtnInsert() {
        return btnInsert;
    }

    public void setBtnInsert(JButton btnInsert) {
        this.btnInsert = btnInsert;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JTextField getTextFieldH1() {
        return textFieldH1;
    }

    public void setTextFieldH1(JTextField textFieldH1) {
        this.textFieldH1 = textFieldH1;
    }

    public JTextField getTextFieldH2() {
        return textFieldH2;
    }

    public void setTextFieldH2(JTextField textFieldH2) {
        this.textFieldH2 = textFieldH2;
    }

    public JTextField getTextFieldSf() {
        return textFieldSf;
    }

    public void setTextFieldSf(JTextField textFieldSf) {
        this.textFieldSf = textFieldSf;
    }

    public JTable getRaceConfigTable() {
        return raceConfigTable;
    }

    public void setRaceConfigTable(JTable raceConfigTable) {
        this.raceConfigTable = raceConfigTable;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
}



