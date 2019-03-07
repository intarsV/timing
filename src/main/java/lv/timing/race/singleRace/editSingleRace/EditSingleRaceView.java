package lv.timing.race.singleRace.editSingleRace;

import lv.timing.domain.ComboBoxItem;
import lv.timing.domain.CompetitionEvent;
import lv.timing.domain.SubEvent;
import lv.timing.race.singleRace.abstractClass.SingleModel;
import lv.timing.race.singleRace.abstractClass.SingleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

@Component
public class EditSingleRaceView extends SingleView {

    @Autowired
    private EditSingleRaceModel model;

    public EditSingleRaceView() {
        //Create frame
        frame = new JInternalFrame("Edit single race data");
        frame.setResizable(false);
        frame.setBounds(100, 100, 1182, 587);
        frame.getContentPane().setLayout(null);
       // frame.setVisible(true);
        frame.setClosable(true);

        //Create components
        scrollPane = new JScrollPane();
        dataTable = new JTable();
        comboBoxEvent = new JComboBox<ComboBoxItem<CompetitionEvent>>();
        comboBoxSubEvent = new JComboBox<ComboBoxItem<SubEvent>>();
        btnDeleteRow = new JButton("Delete row");

        //Layout components
        JComponent c = (JComponent) frame.getContentPane();
        scrollPane.setBounds(10, 96, 1148, 442);
        c.add(scrollPane);

        dataTable.setFont(new Font("Arial", Font.PLAIN, 12));
        scrollPane.setViewportView(dataTable);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        comboBoxEvent.setBounds(76, 11, 276, 25);
        c.add(comboBoxEvent);

        comboBoxSubEvent.setBounds(76, 42, 276, 25);
        c.add(comboBoxSubEvent);

        btnDeleteRow.setBounds(433, 12, 100, 23);
        c.add(btnDeleteRow);
    }

    @Override
    public SingleModel getModel() {
        return model;
    }

    @Override
    public void setModel(SingleModel model) {
        this.model = (EditSingleRaceModel) model;
    }
}