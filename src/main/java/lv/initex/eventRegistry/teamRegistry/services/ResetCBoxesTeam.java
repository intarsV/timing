package lv.initex.eventRegistry.teamRegistry.services;

import lv.initex.eventRegistry.teamRegistry.EventTeamRegistryView;

public class ResetCBoxesTeam {

    public static void resetControlBoxes(EventTeamRegistryView view) {
        view.getComboBoxClass().setSelectedIndex(-1);
        view.getComboBoxCompetitorOne().setSelectedIndex(-1);
        view.getComboBoxCompetitorTwo().setSelectedIndex(-1);
        view.getComboBoxCompetitorThree().setSelectedIndex(-1);
    }
}
