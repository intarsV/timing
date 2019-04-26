package lv.initex.race.teamRace.abstractClass;

import lv.initex.domain.ComboBoxItem;
import lv.initex.domain.CompetitionEvent;
import lv.initex.domain.SubEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public abstract class TeamView {

    protected JInternalFrame frame;
    protected JScrollPane scrollPane;
    protected JTable resultTable;
    protected JComboBox<ComboBoxItem<CompetitionEvent>> comboBoxEvent;
    protected JComboBox<ComboBoxItem<SubEvent>> comboBoxSubEvent;
    protected JButton btnDeleteRow;
    protected JLabel lblEvent;
    protected JLabel lblGroup;
    protected JLabel lblRepeatRun;
   // protected JTable dataTable;
    protected JButton btnDeleteDone;
    protected JTextField txtBibToDelete;





    public void formatTable(TeamModel model) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        resultTable.setModel(model);

        resultTable.getColumnModel().getColumn(0).setPreferredWidth(35);
        resultTable.getColumnModel().getColumn(0).setMaxWidth(35);
        resultTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        resultTable.getColumnModel().getColumn(1).setPreferredWidth(35);
        resultTable.getColumnModel().getColumn(1).setMaxWidth(35);
        resultTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        resultTable.getColumnModel().getColumn(2).setPreferredWidth(80);
        resultTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        resultTable.getColumnModel().getColumn(2).setMinWidth(30);
        resultTable.getColumnModel().getColumn(2).setMaxWidth(80);
        resultTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        resultTable.getColumnModel().getColumn(3).setMinWidth(30);
        resultTable.getColumnModel().getColumn(3).setMaxWidth(80);
        resultTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        for (int i = 4; i < 29; i++) {
            resultTable.getColumnModel().getColumn(i).setPreferredWidth(35);
            resultTable.getColumnModel().getColumn(i).setMaxWidth(35);
            resultTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        resultTable.getColumnModel().getColumn(27).setPreferredWidth(50);
        resultTable.getColumnModel().getColumn(27).setMaxWidth(50);
        resultTable.getColumnModel().getColumn(28).setPreferredWidth(45);
        resultTable.getColumnModel().getColumn(28).setMaxWidth(45);

        resultTable.removeColumn(resultTable.getColumnModel().getColumn(0));
        resultTable.removeColumn(resultTable.getColumnModel().getColumn(28));
        resultTable.removeColumn(resultTable.getColumnModel().getColumn(28));
        resultTable.removeColumn(resultTable.getColumnModel().getColumn(28));
    }

public abstract TeamModel getModel();

    public abstract void setModel(TeamModel model);

    public JInternalFrame getFrame() {
        return frame;
    }

    public void setFrame(JInternalFrame frame) {
        this.frame = frame;
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



//    public JTable getDataTable() {
//        return dataTable;
//    }
//
//    public void setDataTable(JTable dataTable) {
//        this.dataTable = dataTable;
//    }

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
