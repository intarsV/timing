package lv.initex.race.singleRace.abstractClass;

import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.SubEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public abstract class SingleView {

    protected JInternalFrame frame;
    protected JLabel lblEvent;
    protected JLabel lblGroup;
    protected JLabel lblRepeatRun;
    protected JScrollPane scrollPane;
    protected JTable dataTable;
    protected JComboBox<ComboBoxItem<CompetitionEvent>> comboBoxEvent;
    protected JComboBox<ComboBoxItem<SubEvent>> comboBoxSubEvent;
    protected JButton btnDeleteRow;
    protected JButton btnDeleteDone;
    protected JTextField txtBibToDelete;

    public void formatTable(SingleModel model) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        dataTable.setModel(model);

        dataTable.getColumnModel().getColumn(0).setPreferredWidth(35);
        dataTable.getColumnModel().getColumn(0).setMaxWidth(35);
        dataTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        dataTable.getColumnModel().getColumn(1).setPreferredWidth(35);
        dataTable.getColumnModel().getColumn(1).setMaxWidth(35);
        dataTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        dataTable.getColumnModel().getColumn(2).setPreferredWidth(80);
        dataTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        dataTable.getColumnModel().getColumn(2).setMinWidth(30);
        dataTable.getColumnModel().getColumn(2).setMaxWidth(80);
        dataTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        dataTable.getColumnModel().getColumn(3).setMinWidth(30);
        dataTable.getColumnModel().getColumn(3).setMaxWidth(80);
        dataTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        for (int i = 4; i < 28; i++) {
            dataTable.getColumnModel().getColumn(i).setPreferredWidth(35);
            dataTable.getColumnModel().getColumn(i).setMaxWidth(35);
            dataTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        dataTable.getColumnModel().getColumn(27).setPreferredWidth(50);
        dataTable.getColumnModel().getColumn(27).setMaxWidth(50);
        dataTable.getColumnModel().getColumn(28).setPreferredWidth(45);
        dataTable.getColumnModel().getColumn(28).setMaxWidth(45);

        dataTable.removeColumn(dataTable.getColumnModel().getColumn(0));
        dataTable.removeColumn(dataTable.getColumnModel().getColumn(28));
        dataTable.removeColumn(dataTable.getColumnModel().getColumn(27));
        dataTable.removeColumn(dataTable.getColumnModel().getColumn(27));
    }

    public abstract SingleModel getModel();

    public abstract void setModel(SingleModel model);

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

    public JLabel getLblGroup() {
        return lblGroup;
    }

    public void setLblGroup(JLabel lblGroup) {
        this.lblGroup = lblGroup;
    }

    public JLabel getLblRepeatRun() {
        return lblRepeatRun;
    }

    public void setLblRepeatRun(JLabel lblRepeatRun) {
        this.lblRepeatRun = lblRepeatRun;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(JTable dataTable) {
        this.dataTable = dataTable;
    }

    public JComboBox getComboBoxEvent() {
        return comboBoxEvent;
    }

    public void setComboBoxEvent(JComboBox comboBoxEvent) {
        this.comboBoxEvent = comboBoxEvent;
    }

    public JComboBox getComboBoxSubEvent() {
        return comboBoxSubEvent;
    }

    public void setComboBoxSubEvent(JComboBox comboBoxSubEvent) {
        this.comboBoxSubEvent = comboBoxSubEvent;
    }

    public JButton getBtnDeleteRow() {
        return btnDeleteRow;
    }

    public void setBtnDeleteRow(JButton btnDeleteRow) {
        this.btnDeleteRow = btnDeleteRow;
    }

    public JButton getBtnDeleteDone() {
        return btnDeleteDone;
    }

    public void setBtnDeleteDone(JButton btnDeleteDone) {
        this.btnDeleteDone = btnDeleteDone;
    }

    public JTextField getTxtBibToDelete() {
        return txtBibToDelete;
    }

    public void setTxtBibToDelete(JTextField txtBibToDelete) {
        this.txtBibToDelete = txtBibToDelete;
    }

}
