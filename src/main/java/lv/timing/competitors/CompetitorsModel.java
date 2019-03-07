package lv.timing.competitors;


import org.springframework.stereotype.Component;

import javax.swing.table.DefaultTableModel;

@Component
public class CompetitorsModel extends DefaultTableModel {

    private static final Object[] TABLE_HEADER = {"Id", "Name",
            "Year", "Club",  "Country", "Deleted"};
    public static Object[][] DATA;


    public CompetitorsModel() {
        super(DATA, TABLE_HEADER);
    }


    public static Object[] getTableHeader() {
        return TABLE_HEADER;
    }

    public static Object[][] getDATA() {
        return DATA;
    }

    public static void setDATA(Object[][] DATA) {
        CompetitorsModel.DATA = DATA;
    }



}



