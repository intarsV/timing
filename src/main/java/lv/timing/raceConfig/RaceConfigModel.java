package lv.timing.raceConfig;


import org.springframework.stereotype.Component;

import javax.swing.table.DefaultTableModel;

@Component
public class RaceConfigModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"Id", "Event", "SingleBoatClass","Class",  "H1", "H2", "SF"};
    public static Object[][] DATA;


    public RaceConfigModel() {
        super(DATA, TABLE_HEADER);
    }


    public static Object[] getTableHeader() {
        return TABLE_HEADER;
    }

    public static Object[][] getDATA() {
        return DATA;
    }

    public static void setDATA(Object[][] DATA) {
        RaceConfigModel.DATA = DATA;
    }

}

