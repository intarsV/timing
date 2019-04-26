package lv.initex.verifyMcuData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.Arrays;
import java.util.List;

@Component
public class VerifyMcuDataView  {

    @Autowired
    private VerifyMcuDataModelStart mStart;

    @Autowired
    private VerifyMcuDataModelFinish mFinish;


    public static JInternalFrame frame;
    private JScrollPane scrollPaneStart;
    private JScrollPane scrollPaneFinish;
    private JTable tableStart;
    private JTable tableFinish;
    private JLabel lblIncomingStartLine;
    private JLabel lblIncomingFinishLine;

    public VerifyMcuDataView() {

        //Create frame
        frame = new JInternalFrame("Verify incoming MCU data");
        frame.setResizable(false);
        frame.setBounds(100, 100, 450, 300);
        frame.getContentPane().setLayout(null);
        frame.setClosable(true);

        //Create components
        scrollPaneStart = new JScrollPane();
        tableStart = new JTable();
        scrollPaneFinish = new JScrollPane();
        tableFinish = new JTable();
        lblIncomingStartLine = new JLabel("Incoming StartLine");
        lblIncomingFinishLine = new JLabel("Incoming FinishLine");

        //Layout components
        scrollPaneStart.setBounds(22, 62, 189, 189);
        frame.add(scrollPaneStart);

        scrollPaneStart.setViewportView(tableStart);

        scrollPaneFinish.setBounds(230, 62, 189, 189);
        frame.add(scrollPaneFinish);

        scrollPaneFinish.setViewportView(tableFinish);

        lblIncomingStartLine.setBounds(22, 37, 125, 14);
        frame.add(lblIncomingStartLine);

        lblIncomingFinishLine.setBounds(230, 37, 134, 14);
        frame.add(lblIncomingFinishLine);
    }

    public  void formatTables() {
        //add model
        tableStart.setModel(mStart);
        tableFinish.setModel(mFinish);

        List<JTable> tableList = Arrays.asList(tableStart, tableFinish);

        for (JTable table : tableList) {
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            //format cells
            table.getColumnModel().getColumn(0).setPreferredWidth(25);
            table.getColumnModel().getColumn(0).setMaxWidth(30);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            table.getColumnModel().getColumn(1).setPreferredWidth(40);
            table.getColumnModel().getColumn(1).setMaxWidth(40);
            table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            table.getColumnModel().getColumn(2).setPreferredWidth(150);
            table.getColumnModel().getColumn(2).setMaxWidth(150);
            //remove unnecessary columns
            table.removeColumn(table.getColumnModel().getColumn(0));
            table.removeColumn(table.getColumnModel().getColumn(2));
            table.removeColumn(table.getColumnModel().getColumn(3));
            table.removeColumn(table.getColumnModel().getColumn(2));
        }
    }

    public VerifyMcuDataModelStart getModelStart() {
        return mStart;
    }

    public void setmStart(VerifyMcuDataModelStart mStart) {
        this.mStart = mStart;
    }

    public VerifyMcuDataModelFinish getModelFinish() {
        return mFinish;
    }

    public void setmFinish(VerifyMcuDataModelFinish mFinish) {
        this.mFinish = mFinish;
    }

    public JInternalFrame getFrame() {
        return frame;
    }

    public void setFrame(JInternalFrame frame) {
        VerifyMcuDataView.frame = frame;
    }

    public JScrollPane getScrollPaneStart() {
        return scrollPaneStart;
    }

    public void setScrollPaneStart(JScrollPane scrollPaneStart) {
        this.scrollPaneStart = scrollPaneStart;
    }

    public JScrollPane getScrollPaneFinish() {
        return scrollPaneFinish;
    }

    public void setScrollPaneFinish(JScrollPane scrollPaneFinish) {
        this.scrollPaneFinish = scrollPaneFinish;
    }

    public JTable getTableStart() {
        return tableStart;
    }

    public void setTableStart(JTable tableStart) {
        this.tableStart = tableStart;
    }

    public JTable getTableFinish() {
        return tableFinish;
    }

    public void setTableFinish(JTable tableFinish) {
        this.tableFinish = tableFinish;
    }

    public JLabel getLblIncomingStartLine() {
        return lblIncomingStartLine;
    }

    public void setLblIncomingStartLine(JLabel lblIncomingStartLine) {
        this.lblIncomingStartLine = lblIncomingStartLine;
    }

    public JLabel getLblIncomingFinishLine() {
        return lblIncomingFinishLine;
    }

    public void setLblIncomingFinishLine(JLabel lblIncomingFinishLine) {
        this.lblIncomingFinishLine = lblIncomingFinishLine;
    }

}
