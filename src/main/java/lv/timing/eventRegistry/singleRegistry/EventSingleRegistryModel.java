package lv.timing.eventRegistry.singleRegistry;

import org.springframework.stereotype.Component;

import javax.swing.table.DefaultTableModel;

@Component
public class EventSingleRegistryModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"ID", "Event"
            , "Group", "SingleBoatClass", "Competitor", "competitor"
            , "group", "boat class", "bib"};


    public static Object[][] DATA;

    public EventSingleRegistryModel() {
        super(DATA, TABLE_HEADER);
    }

    public static Object[][] getDATA() {
        return DATA;
    }

    public static void setDATA(Object[][] DATA) {
        EventSingleRegistryModel.DATA = DATA;
    }
}
