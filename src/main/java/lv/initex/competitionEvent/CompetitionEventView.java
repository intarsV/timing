package lv.initex.competitionEvent;

import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.CompetitionFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class CompetitionEventView {

    @Autowired
    private CompetitionEventModel model;

    private JInternalFrame frame;
    private JTextField textField;
    private JTextField textFieldPlace;
    private JComboBox<ComboBoxItem<CompetitionFormat>> comboBoxFormat;
    private JButton btnInsert;
    private JButton btnDelete;
    private JScrollPane scrollPane;
    private JTable tableEvent;
    private JLabel lblFormat;
    private JLabel lblPlace;

    public CompetitionEventView() {
        //Create frame
        frame = new JInternalFrame("Competition events");
        frame.setResizable(false);
        frame.setBounds(100, 100, 820, 307);
        frame.getContentPane().setLayout(null);
        frame.setClosable(true);

        //Create components
        textField = new JTextField();
        textFieldPlace=new JTextField();
        comboBoxFormat = new JComboBox<ComboBoxItem<CompetitionFormat>>();
        btnInsert = new JButton("Insert");
        btnDelete = new JButton("Delete");
        scrollPane = new JScrollPane();
        tableEvent = new JTable();
        lblFormat = new JLabel("Format");
        lblPlace=new JLabel("Place");

        //Layout components
        textField.setBounds(76, 13, 419, 25);
        frame.getContentPane().add(textField);

        textFieldPlace.setBounds(76, 72, 419, 25);
        frame.getContentPane().add(textFieldPlace);

        comboBoxFormat.setBounds(76, 43, 185, 25);
        frame.getContentPane().add(comboBoxFormat);

        btnInsert.setBounds(530, 46, 89, 23);
        frame.getContentPane().add(btnInsert);

        btnDelete.setBounds(530, 73, 89, 23);
        frame.getContentPane().add(btnDelete);

        scrollPane.setBounds(28, 105, 750, 146);
        frame.getContentPane().add(scrollPane);
        scrollPane.setViewportView(tableEvent);

        lblFormat.setBounds(28, 45, 46, 20);
        frame.getContentPane().add(lblFormat);

        lblPlace.setBounds(28, 74, 46, 20);
        frame.getContentPane().add(lblPlace);
    }

    public void formatTable() {
        tableEvent.setModel(model);
        tableEvent.getColumnModel().getColumn(0).setPreferredWidth(20);
        tableEvent.getColumnModel().getColumn(1).setMaxWidth(300);
        tableEvent.getColumnModel().getColumn(2).setMaxWidth(150);
        tableEvent.getColumnModel().getColumn(3).setMaxWidth(300);
        tableEvent.removeColumn(tableEvent.getColumnModel().getColumn(0));
    }

    public CompetitionEventModel getModel() {
        return model;
    }

    public void setModel(CompetitionEventModel model) {
        this.model = model;
    }

    public JInternalFrame getFrame() {
        return frame;
    }

    public void setFrame(JInternalFrame frame) {
        this.frame = frame;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JComboBox getComboBoxFormat() {
        return comboBoxFormat;
    }

    public void setComboBoxFormat(JComboBox comboBoxFormat) {
        this.comboBoxFormat = comboBoxFormat;
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

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JTable getTableEvent() {
        return tableEvent;
    }

    public void setTableEvent(JTable tableEvent) {
        this.tableEvent = tableEvent;
    }

    public JLabel getLblFormat() {
        return lblFormat;
    }

    public void setLblFormat(JLabel lblFormat) {
        this.lblFormat = lblFormat;
    }

    public JTextField getTextFieldPlace() {
        return textFieldPlace;
    }

    public void setTextFieldPlace(JTextField textFieldPlace) {
        this.textFieldPlace = textFieldPlace;
    }
}

