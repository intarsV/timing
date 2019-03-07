package lv.timing.competitionEvent;


import org.springframework.stereotype.Component;

import javax.swing.table.DefaultTableModel;

@Component
public class CompetitionEventModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"Id", "EVENT", "FORMAT", "PLACE"};
    public static Object[][] DATA;


    public CompetitionEventModel() {
        super(DATA, TABLE_HEADER);
    }


    public static Object[] getTableHeader() {
        return TABLE_HEADER;
    }

    public static Object[][] getDATA() {
        return DATA;
    }

    public static void setDATA(Object[][] DATA) {
        CompetitionEventModel.DATA = DATA;
    }


}

