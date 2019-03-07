package lv.timing.eventRegistry.teamRegistry.services;

import lv.timing.eventRegistry.teamRegistry.EventTeamRegistryView;

public class ResetCBoxesTeam {

    public static void resetControlBoxes(EventTeamRegistryView view) {
        view.getComboBoxClass().setSelectedIndex(-1);
        view.getComboBoxCompetitorOne().setSelectedIndex(-1);
        view.getComboBoxCompetitorTwo().setSelectedIndex(-1);
        view.getComboBoxCompetitorThree().setSelectedIndex(-1);
    }
}
