package lv.timing.eventRegistry.teamRegistry;

import org.springframework.stereotype.Component;

import javax.swing.table.DefaultTableModel;

@Component
public class EventTeamRegistryModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"ID", "Event"
            ,  "SingleBoatClass", "CompetitorOne", "CompetitorTwo", "CompetitorThree", "competitor1", "competitor2", "competitor3"
            , "boat class", "bib"};


    public static Object[][] DATA;

    public EventTeamRegistryModel() {
        super(DATA, TABLE_HEADER);
    }

    public static Object[][] getDATA() {
        return DATA;
    }

    public static void setDATA(Object[][] DATA) {
        EventTeamRegistryModel.DATA = DATA;
    }
}
