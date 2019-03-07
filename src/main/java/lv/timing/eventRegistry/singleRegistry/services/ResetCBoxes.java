package lv.timing.eventRegistry.singleRegistry.services;

import lv.timing.eventRegistry.singleRegistry.EventSingleRegistryView;


public class ResetCBoxes {

    public static void resetControlBoxes(EventSingleRegistryView view) {
        view.getComboBoxGroup().setSelectedIndex(-1);
        view.getComboBoxClass().setSelectedIndex(-1);
        view.getComboBoxCompetitor().setSelectedIndex(-1);
    }
}
