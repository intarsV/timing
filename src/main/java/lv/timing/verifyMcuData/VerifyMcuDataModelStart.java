package lv.timing.verifyMcuData;

import org.springframework.stereotype.Component;

import javax.swing.table.DefaultTableModel;

@Component
public class VerifyMcuDataModelStart extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"Id", "BIB", "Time", "Unit_Id", "Sub_event", "Done", "Accept"};

    public boolean isEditable[] = new boolean[]{false, true, false, false, false, false, true};

    public static Object[][] DATA;


    public VerifyMcuDataModelStart() {
        super(DATA, TABLE_HEADER);
    }


    public static Object[][] getDATA() {
        return DATA;
    }

    public static void setDATA(Object[][] DATA) {
        VerifyMcuDataModelStart.DATA = DATA;
    }

    public boolean isCellEditable(int row, int column) {
        return isEditable[column];
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {

            case 0:
                return Integer.class;
            case 1:
                return Integer.class;
            case 2:
                return Integer.class;
            case 3:
                return Integer.class;
            case 4:
                return Integer.class;
            case 5:
                return Integer.class;
            case 6:
                return Boolean.class;
            default:
                return Boolean.class;
        }
    }

}
