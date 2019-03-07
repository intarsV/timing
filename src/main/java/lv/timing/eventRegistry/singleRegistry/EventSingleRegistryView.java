package lv.timing.eventRegistry.singleRegistry;

import lv.timing.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class EventSingleRegistryView {

    @Autowired
    private EventSingleRegistryModel model;

    private static JInternalFrame frame;
    private JLabel lblEvent;
    private JLabel lblGroup;
    private JLabel lblClass;
    private JScrollPane scrollPane;
    private JTable table;
    private JComboBox<ComboBoxItem<CompetitionEvent>> comboBoxEvent;
    private JComboBox<ComboBoxItem<Competitor>> comboBoxCompetitor;
    private JComboBox<ComboBoxItem<Group>> comboBoxGroup;
    private JComboBox<ComboBoxItem<SingleBoatClass>> comboBoxClass;
    private JTextField textFieldBIB;
    private JLabel lblCompetitor;
    private JLabel lblBIB;
    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnAddCompetitor;
    private JButton btnAddEvent;
    private JCheckBox checkboxReverseBibOrder;

    public EventSingleRegistryView() {

        //Create frame
        frame = new JInternalFrame("Single race event registry");
        frame.setResizable(false);
        frame.setBounds(100, 100, 552, 435);
        frame.getContentPane().setLayout(null);
        frame.setClosable(true);

        //Create components
        lblEvent = new JLabel("Event");
        lblGroup = new JLabel("Group");
        lblClass = new JLabel("Class");
        scrollPane = new JScrollPane();
        table = new JTable();
        comboBoxEvent = new JComboBox<ComboBoxItem<CompetitionEvent>>();
        comboBoxGroup = new JComboBox<ComboBoxItem<Group>>();
        comboBoxClass = new JComboBox<ComboBoxItem<SingleBoatClass>>();
        comboBoxCompetitor = new JComboBox<ComboBoxItem<Competitor>>();
        lblCompetitor = new JLabel("Competitor");
        lblBIB = new JLabel("BIB");
        textFieldBIB = new JTextField();
        btnInsert = new JButton("Insert");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnAddCompetitor = new JButton("+");
        btnAddEvent = new JButton("+");
        checkboxReverseBibOrder = new JCheckBox("Reverse BIB count");

        //Layout components
        lblEvent.setHorizontalAlignment(SwingConstants.RIGHT);
        lblEvent.setBounds(40, 16, 62, 14);
        frame.add(lblEvent);

        lblGroup.setHorizontalAlignment(SwingConstants.RIGHT);
        lblGroup.setBounds(40, 52, 62, 14);
        frame.add(lblGroup);

        lblClass.setHorizontalAlignment(SwingConstants.RIGHT);
        lblClass.setBounds(56, 88, 46, 14);
        frame.add(lblClass);

        scrollPane.setBounds(26, 186, 490, 197);
        frame.add(scrollPane);

        scrollPane.setViewportView(table);


        comboBoxEvent.setBounds(150, 11, 207, 25);
        frame.add(comboBoxEvent);

        comboBoxGroup.setBounds(150, 47, 207, 25);
        frame.add(comboBoxGroup);

        comboBoxClass.setBounds(150, 83, 207, 25);
        frame.add(comboBoxClass);

        comboBoxCompetitor.setBounds(150, 119, 207, 25);
        frame.add(comboBoxCompetitor);

        lblCompetitor.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCompetitor.setBounds(30, 124, 72, 14);
        frame.add(lblCompetitor);

        textFieldBIB.setBounds(150, 155, 46, 25);
        frame.add(textFieldBIB);
        textFieldBIB.setColumns(10);

        lblBIB.setHorizontalAlignment(SwingConstants.RIGHT);
        lblBIB.setBounds(30, 158, 72, 14);
        frame.add(lblBIB);

        btnInsert.setBounds(437, 52, 89, 23);
        frame.add(btnInsert);

        btnUpdate.setBounds(437, 86, 89, 23);
        frame.add(btnUpdate);

        btnDelete.setBounds(437, 120, 89, 23);
        frame.add(btnDelete);

        btnAddCompetitor.setBounds(358, 121, 41, 23);
        frame.add(btnAddCompetitor);

        btnAddEvent.setBounds(358, 13, 41, 23);
        frame.add(btnAddEvent);

        checkboxReverseBibOrder.setBounds(202, 156, 155, 23);
        frame.add(checkboxReverseBibOrder);
    }

    public void formatTable() {
        table.setModel(model);
        table.removeColumn(table.getColumnModel().getColumn(0));
        table.removeColumn(table.getColumnModel().getColumn(0));
        table.removeColumn(table.getColumnModel().getColumn(0));
        table.removeColumn(table.getColumnModel().getColumn(0));
        table.removeColumn(table.getColumnModel().getColumn(0));

        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        table.getColumnModel().getColumn(0).setMaxWidth(280);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(1).setMinWidth(60);
        table.getColumnModel().getColumn(1).setMaxWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.getColumnModel().getColumn(2).setMinWidth(90);
        table.getColumnModel().getColumn(2).setMaxWidth(90);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setMinWidth(60);
        table.getColumnModel().getColumn(3).setMaxWidth(60);
    }

    public EventSingleRegistryModel getModel() {
        return model;
    }

    public void setModel(EventSingleRegistryModel model) {
        this.model = model;
    }

    public static JInternalFrame getFrame() {
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

    public JLabel getLblGroup() {
        return lblGroup;
    }

    public void setLblGroup(JLabel lblGroup) {
        this.lblGroup = lblGroup;
    }

    public JLabel getLblClass() {
        return lblClass;
    }

    public void setLblClass(JLabel lblClass) {
        this.lblClass = lblClass;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JComboBox getComboBoxEvent() {
        return comboBoxEvent;
    }

    public void setComboBoxEvent(JComboBox comboBoxEvent) {
        this.comboBoxEvent = comboBoxEvent;
    }

    public JComboBox getComboBoxCompetitor() {
        return comboBoxCompetitor;
    }

    public void setComboBoxCompetitor(JComboBox comboBoxCompetitor) {
        this.comboBoxCompetitor = comboBoxCompetitor;
    }

    public JComboBox getComboBoxGroup() {
        return comboBoxGroup;
    }

    public void setComboBoxGroup(JComboBox comboBoxGroup) {
        this.comboBoxGroup = comboBoxGroup;
    }

    public JComboBox getComboBoxClass() {
        return comboBoxClass;
    }

    public void setComboBoxClass(JComboBox comboBoxClass) {
        this.comboBoxClass = comboBoxClass;
    }

    public JTextField getTextFieldBIB() {
        return textFieldBIB;
    }

    public void setTextFieldBIB(JTextField textFieldBIB) {
        this.textFieldBIB = textFieldBIB;
    }

    public JLabel getLblCompetitor() {
        return lblCompetitor;
    }

    public void setLblCompetitor(JLabel lblCompetitor) {
        this.lblCompetitor = lblCompetitor;
    }

    public JLabel getLblBIB() {
        return lblBIB;
    }

    public void setLblBIB(JLabel lblBIB) {
        this.lblBIB = lblBIB;
    }

    public JButton getBtnInsert() {
        return btnInsert;
    }

    public void setBtnInsert(JButton btnInsert) {
        this.btnInsert = btnInsert;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JButton getBtnAddCompetitor() {
        return btnAddCompetitor;
    }

    public void setBtnAddCompetitor(JButton btnAddCompetitor) {
        this.btnAddCompetitor = btnAddCompetitor;
    }

    public JButton getBtnAddEvent() {
        return btnAddEvent;
    }

    public void setBtnAddEvent(JButton btnAddEvent) {
        this.btnAddEvent = btnAddEvent;
    }

    public JCheckBox getCheckboxReverseBibOrder() {
        return checkboxReverseBibOrder;
    }

    public void setCheckboxReverseBibOrder(JCheckBox checkboxReverseBibOrder) {
        this.checkboxReverseBibOrder = checkboxReverseBibOrder;
    }
}
