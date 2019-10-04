package lv.initex.race.singleRace.processSingleRace;

import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.SubEvent;
import lv.initex.race.singleRace.abstractClass.SingleModel;
import lv.initex.race.singleRace.abstractClass.SingleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;

@Component
public class SingleRaceView extends SingleView {

    @Autowired
    private SingleRaceModel model;


    public SingleRaceView() {

        //Create frame
        frame = new JInternalFrame("Single race");
        frame.setResizable(false);
        frame.setBounds(100, 100, 1182, 353);
        frame.getContentPane().setLayout(null);
        frame.setClosable(true);

        //Create components
        lblEvent = new JLabel("Event");
        lblGroup = new JLabel("SubEvent");
        lblRepeatRun = new JLabel("Repeat run");
        scrollPane = new JScrollPane();
        dataTable = new JTable();
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

        dataTable.setFont(new Font("Arial", Font.PLAIN, 12));
        scrollPane.setViewportView(dataTable);

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
    public SingleModel getModel() {
        return model;
    }

    @Override
    public void setModel(SingleModel model) {
        this.model= (SingleRaceModel) model;
    }
}
