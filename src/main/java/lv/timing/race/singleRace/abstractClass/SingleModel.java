package lv.timing.race.singleRace.abstractClass;

import lv.timing.race.singleRace.processSingleRace.SingleRaceModel;

import javax.swing.table.DefaultTableModel;

public abstract class SingleModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"ID", "BIB", "Start", "Finish", "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9",
            "G10", "G11", "G12", "G13", "G14", "G15", "G16", "G17", "G18", "G19", "G20", "G21", "G22",
            "G23", "G24", "eventSingleRegistry", "event", "subEvent", "DSQ_R", "Done"};

    boolean[] columnEditable = new boolean[]{false, true, true, true, true, true, true, true, true,
            true, true, true, true, true, true, true, true, true, true, true, true, true, true,
            true, true, true, true, true, true, true, true, true, true};

    public static Object[][] getDATA() {
        return DATA;
    }

    public static void setDATA(Object[][] DATA) {
        SingleRaceModel.DATA = DATA;
    }

    public static Object[][] DATA;


    public SingleModel() {
        super(DATA, TABLE_HEADER);
    }

    public boolean isCellEditable(int row, int column) {
        return columnEditable[column];
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
                return Integer.class;
            case 7:
                return Integer.class;
            case 8:
                return Integer.class;
            case 9:
                return Integer.class;
            case 10:
                return Integer.class;
            case 11:
                return Integer.class;
            case 12:
                return Integer.class;
            case 13:
                return Integer.class;
            case 14:
                return Integer.class;
            case 15:
                return Integer.class;
            case 16:
                return Integer.class;
            case 17:
                return Integer.class;
            case 18:
                return Integer.class;
            case 19:
                return Integer.class;
            case 20:
                return Integer.class;
            case 21:
                return Integer.class;
            case 22:
                return Integer.class;
            case 23:
                return Integer.class;
            case 24:
                return Integer.class;
            case 25:
                return Integer.class;
            case 26:
                return Integer.class;
            case 27:
                return Integer.class;
            case 28:
                return Integer.class;
            case 29:
                return Integer.class;
            case 30:
                return Integer.class;
            case 31:
                return Boolean.class;

            default:
                return Boolean.class;

        }
    }
}
