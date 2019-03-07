package lv.timing.eventRegistry.teamRegistry.services;

import lv.timing.eventRegistry.teamRegistry.EventTeamRegistryView;

public class GenerateNextBibTeam {

    public static void generateNextBib(EventTeamRegistryView view) {
        boolean reverse = view.getCheckboxReverseBibOrder().isSelected();
        int currentBIB = Integer.parseInt(view.getTextFieldBIB().getText());
        if (reverse == false) {
            view.getTextFieldBIB().setText(Integer.toString(currentBIB + 1));
        } else {
            view.getTextFieldBIB().setText(Integer.toString(currentBIB - 1));
        }
    }
}
