package lv.timing.eventRegistry.teamRegistry;

import lv.timing.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class EventTeamRegistryView {

    @Autowired
    private EventTeamRegistryModel model;

    private static JInternalFrame frame;
    private JLabel lblEvent;
    private JLabel lblGroup;
    private JLabel lblClass;
    private JScrollPane scrollPane;
    private JTable resultTable;
    private JComboBox<ComboBoxItem<CompetitionEvent>> comboBoxEvent;
    private JComboBox<ComboBoxItem<Competitor>> comboBoxCompetitorOne;
    private JComboBox<ComboBoxItem<Competitor>> comboBoxCompetitorTwo;
    private JComboBox<ComboBoxItem<Competitor>> comboBoxCompetitorThree;
    private JComboBox<ComboBoxItem<TeamBoatClass>> comboBoxClass;
    private JTextField textFieldBIB;
    private JLabel lblCompetitorOne;
    private JLabel lblCompetitorTwo;
    private JLabel lblCompetitorThree;
    private JLabel lblBIB;
    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnAddCompetitor;
    private JButton btnAddEvent;
    private JCheckBox checkboxReverseBibOrder;

    public EventTeamRegistryView() {

        //Create frame
        frame = new JInternalFrame("Team race event registry");
        frame.setResizable(false);
        frame.setBounds(100, 100, 647, 553);

        frame.getContentPane().setLayout(null);
        frame.setClosable(true);

        //Create components
        lblEvent = new JLabel("Event");
        lblClass = new JLabel("Class");
        scrollPane = new JScrollPane();
        resultTable = new JTable();
        comboBoxEvent = new JComboBox<ComboBoxItem<CompetitionEvent>>();
        comboBoxClass = new JComboBox<ComboBoxItem<TeamBoatClass>>();
        comboBoxCompetitorOne = new JComboBox<ComboBoxItem<Competitor>>();
        comboBoxCompetitorTwo = new JComboBox<ComboBoxItem<Competitor>>();
        comboBoxCompetitorThree = new JComboBox<ComboBoxItem<Competitor>>();
        lblCompetitorOne = new JLabel("Competitor 1");
        lblCompetitorTwo = new JLabel("Competitor 2");
        lblCompetitorThree = new JLabel("Competitor 3");
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
        frame.getContentPane().add(lblEvent);

        lblClass.setHorizontalAlignment(SwingConstants.RIGHT);
        lblClass.setBounds(56, 54, 46, 14);
        frame.getContentPane().add(lblClass);

        scrollPane.setBounds(30, 236, 586, 255);
        frame.getContentPane().add(scrollPane);

        scrollPane.setViewportView(resultTable);

        comboBoxEvent.setBounds(150, 11, 265, 25);
        frame.getContentPane().add(comboBoxEvent);

        comboBoxClass.setBounds(150, 49, 265, 25);
        frame.getContentPane().add(comboBoxClass);

        comboBoxCompetitorOne.setBounds(150, 85, 265, 25);
        frame.getContentPane().add(comboBoxCompetitorOne);

        comboBoxCompetitorTwo.setBounds(150, 122, 265, 25);
        frame.getContentPane().add(comboBoxCompetitorTwo);

        comboBoxCompetitorThree.setBounds(150, 160, 265, 25);
        frame.getContentPane().add(comboBoxCompetitorThree);

        lblCompetitorOne.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCompetitorOne.setBounds(30, 90, 108, 14);
        frame.add(lblCompetitorOne);

        lblCompetitorTwo.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCompetitorTwo.setBounds(30, 127, 108, 14);
        frame.add(lblCompetitorTwo);

        lblCompetitorThree.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCompetitorThree.setBounds(30, 165, 108, 14);
        frame.add(lblCompetitorThree);

        textFieldBIB.setBounds(150, 198, 46, 25);
        frame.add(textFieldBIB);
        textFieldBIB.setColumns(10);

        lblBIB.setHorizontalAlignment(SwingConstants.RIGHT);
        lblBIB.setBounds(30, 201, 72, 14);
        frame.add(lblBIB);

        btnInsert.setBounds(527, 52, 89, 23);
        frame.add(btnInsert);

        btnUpdate.setBounds(527, 86, 89, 23);
        frame.add(btnUpdate);

        btnDelete.setBounds(527, 120, 89, 23);
        frame.add(btnDelete);

        btnAddCompetitor.setBounds(427, 85, 41, 100);
        frame.add(btnAddCompetitor);

        btnAddEvent.setBounds(427, 13, 41, 23);
        frame.add(btnAddEvent);

        checkboxReverseBibOrder.setBounds(202, 199, 155, 23);
        frame.add(checkboxReverseBibOrder);
    }

    public void formatTable() {
        resultTable.setModel(model);

        resultTable.removeColumn(resultTable.getColumnModel().getColumn(0));
        resultTable.removeColumn(resultTable.getColumnModel().getColumn(0));
        resultTable.removeColumn(resultTable.getColumnModel().getColumn(0));
        resultTable.removeColumn(resultTable.getColumnModel().getColumn(0));
        resultTable.removeColumn(resultTable.getColumnModel().getColumn(0));
        resultTable.removeColumn(resultTable.getColumnModel().getColumn(0));

        resultTable.getColumnModel().getColumn(0).setPreferredWidth(147);
        resultTable.getColumnModel().getColumn(0).setMinWidth(147);
        resultTable.getColumnModel().getColumn(0).setMaxWidth(147);
        resultTable.getColumnModel().getColumn(1).setPreferredWidth(147);
        resultTable.getColumnModel().getColumn(1).setMinWidth(147);
        resultTable.getColumnModel().getColumn(1).setMaxWidth(147);
        resultTable.getColumnModel().getColumn(2).setPreferredWidth(147);
        resultTable.getColumnModel().getColumn(2).setMinWidth(147);
        resultTable.getColumnModel().getColumn(2).setMaxWidth(147);
        resultTable.getColumnModel().getColumn(3).setPreferredWidth(105);
        resultTable.getColumnModel().getColumn(3).setMinWidth(105);
        resultTable.getColumnModel().getColumn(3).setMaxWidth(105);

        resultTable.getColumnModel().getColumn(4).setPreferredWidth(35);
        resultTable.getColumnModel().getColumn(4).setMinWidth(35);
        resultTable.getColumnModel().getColumn(4).setMaxWidth(35);
    }

    public EventTeamRegistryModel getModel() {
        return model;
    }

    public void setModel(EventTeamRegistryModel model) {
        this.model = model;
    }

    public static JInternalFrame getFrame() {
        return frame;
    }

    public static void setFrame(JInternalFrame frame) {
        EventTeamRegistryView.frame = frame;
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

    public JTable getResultTable() {
        return resultTable;
    }

    public void setResultTable(JTable resultTable) {
        this.resultTable = resultTable;
    }

    public JComboBox<ComboBoxItem<CompetitionEvent>> getComboBoxEvent() {
        return comboBoxEvent;
    }

    public void setComboBoxEvent(JComboBox<ComboBoxItem<CompetitionEvent>> comboBoxEvent) {
        this.comboBoxEvent = comboBoxEvent;
    }

    public JComboBox<ComboBoxItem<Competitor>> getComboBoxCompetitorOne() {
        return comboBoxCompetitorOne;
    }

    public void setComboBoxCompetitorOne(JComboBox<ComboBoxItem<Competitor>> comboBoxCompetitorOne) {
        this.comboBoxCompetitorOne = comboBoxCompetitorOne;
    }

    public JComboBox<ComboBoxItem<Competitor>> getComboBoxCompetitorTwo() {
        return comboBoxCompetitorTwo;
    }

    public void setComboBoxCompetitorTwo(JComboBox<ComboBoxItem<Competitor>> comboBoxCompetitorTwo) {
        this.comboBoxCompetitorTwo = comboBoxCompetitorTwo;
    }

    public JComboBox<ComboBoxItem<Competitor>> getComboBoxCompetitorThree() {
        return comboBoxCompetitorThree;
    }

    public void setComboBoxCompetitorThree(JComboBox<ComboBoxItem<Competitor>> comboBoxCompetitorThree) {
        this.comboBoxCompetitorThree = comboBoxCompetitorThree;
    }

    public JComboBox<ComboBoxItem<TeamBoatClass>> getComboBoxClass() {
        return comboBoxClass;
    }

    public void setComboBoxClass(JComboBox<ComboBoxItem<TeamBoatClass>> comboBoxClass) {
        this.comboBoxClass = comboBoxClass;
    }

    public JTextField getTextFieldBIB() {
        return textFieldBIB;
    }

    public void setTextFieldBIB(JTextField textFieldBIB) {
        this.textFieldBIB = textFieldBIB;
    }

    public JLabel getLblCompetitorOne() {
        return lblCompetitorOne;
    }

    public void setLblCompetitorOne(JLabel lblCompetitorOne) {
        this.lblCompetitorOne = lblCompetitorOne;
    }

    public JLabel getLblCompetitorTwo() {
        return lblCompetitorTwo;
    }

    public void setLblCompetitorTwo(JLabel lblCompetitorTwo) {
        this.lblCompetitorTwo = lblCompetitorTwo;
    }

    public JLabel getLblCompetitorThree() {
        return lblCompetitorThree;
    }

    public void setLblCompetitorThree(JLabel lblCompetitorThree) {
        this.lblCompetitorThree = lblCompetitorThree;
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
