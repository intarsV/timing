package lv.timing.competitors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CompetitorsView {

    @Autowired
    private CompetitorsModel model;

    public static JInternalFrame frame;
    private JTextField textFieldName;
    private JTextField textFieldClub;
    private JTextField textField_Year;
    private JComboBox comboBoxCountry;
    private JTable competitorsTable;
    private JButton btnInsert;
    private JButton btnDelete;
    private JScrollPane scrollPane;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblAge;
    private JLabel lblCountry;


    public CompetitorsView() {

        //Create frame
        frame = new JInternalFrame("Competitors");
        frame.setResizable(false);
        frame.setBounds(100, 100, 646, 417);
        frame.getContentPane().setLayout(null);
        frame.setClosable(true);

        //Create components
        scrollPane = new JScrollPane();
        lblFirstName = new JLabel("Name");
        lblLastName = new JLabel("Club");
        lblAge = new JLabel("Year");
        lblCountry = new JLabel("Country");
        textFieldName = new JTextField();
        textFieldClub = new JTextField();
        textField_Year = new JTextField();
        competitorsTable = new JTable();
        comboBoxCountry = new JComboBox();
        btnInsert = new JButton("Insert");
        btnDelete = new JButton("Delete");

        //Layout components
        lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblFirstName.setBounds(10, 65, 62, 14);
        frame.add(lblFirstName);

        lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblLastName.setBounds(10, 121, 62, 14);
        frame.add(lblLastName);

        lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAge.setBounds(26, 93, 46, 14);
        frame.add(lblAge);

        lblCountry.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCountry.setBounds(10, 152, 62, 14);
        frame.add(lblCountry);

        textFieldName.setFont(new Font("Arial", Font.PLAIN, 11));
        textFieldName.setBounds(82, 60, 86, 25);
        frame.add(textFieldName);

        textFieldClub.setColumns(10);
        textFieldClub.setBounds(82, 116, 86, 25);
        frame.add(textFieldClub);

        textField_Year.setColumns(10);
        textField_Year.setBounds(82, 88, 86, 25);
        frame.add(textField_Year);

        scrollPane.setBounds(196, 26, 407, 273);
        frame.add(scrollPane);

        scrollPane.setViewportView(competitorsTable);


        comboBoxCountry.setBounds(82, 147, 86, 25);
        frame.add(comboBoxCountry);

        btnInsert.setBounds(82, 205, 89, 23);
        frame.add(btnInsert);

        btnDelete.setBounds(82, 236, 89, 23);
        frame.add(btnDelete);
    }

    public void formatTable() {
        competitorsTable.setModel(model);
        competitorsTable.removeColumn(competitorsTable.getColumnModel().getColumn(0));

        competitorsTable.getColumnModel().getColumn(0).setPreferredWidth(160);
        competitorsTable.getColumnModel().getColumn(0).setMaxWidth(160);
        competitorsTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        competitorsTable.getColumnModel().getColumn(1).setMaxWidth(50);
        competitorsTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        competitorsTable.getColumnModel().getColumn(2).setMaxWidth(120);
        competitorsTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        competitorsTable.getColumnModel().getColumn(3).setMaxWidth(60);
        competitorsTable.removeColumn(competitorsTable.getColumnModel().getColumn(4));


    }

    public CompetitorsModel getModel() {
        return model;
    }

    public void setModel(CompetitorsModel model) {
        this.model = model;
    }

    public JInternalFrame getFrame() {
        return frame;
    }

    public void setFrame(JInternalFrame frame) {
        CompetitorsView.frame = frame;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public void setTextFieldName(JTextField textFieldName) {
        this.textFieldName = textFieldName;
    }

    public JTextField getTextFieldClub() {
        return textFieldClub;
    }

    public void setTextFieldClub(JTextField textFieldClub) {
        this.textFieldClub = textFieldClub;
    }

    public JTextField getTextField_Year() {
        return textField_Year;
    }

    public void setTextField_Year(JTextField textField_Year) {
        this.textField_Year = textField_Year;
    }

    public JComboBox getComboBoxCountry() {
        return comboBoxCountry;
    }

    public void setComboBoxCountry(JComboBox comboBoxCountry) {
        this.comboBoxCountry = comboBoxCountry;
    }

    public JTable getCompetitorsTable() {
        return competitorsTable;
    }

    public void setCompetitorsTable(JTable competitorsTable) {
        this.competitorsTable = competitorsTable;
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
}


