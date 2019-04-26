package lv.initex.eventRegistry.singleRegistry.services;

import lv.initex.eventRegistry.singleRegistry.EventSingleRegistryView;

public class GenerateNextBib {

    public static void generateNextBib(EventSingleRegistryView view) {
        boolean reverse = view.getCheckboxReverseBibOrder().isSelected();
        int currentBIB = Integer.parseInt(view.getTextFieldBIB().getText());
        if (reverse == false) {
            view.getTextFieldBIB().setText(Integer.toString(currentBIB + 1));
        } else {
            view.getTextFieldBIB().setText(Integer.toString(currentBIB - 1));
        }
    }
}
