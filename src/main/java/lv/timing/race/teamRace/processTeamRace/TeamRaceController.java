package lv.timing.race.teamRace.processTeamRace;

import lv.timing.genericServices.InitCBoxEvent;
import lv.timing.genericServices.InitCBoxSubEvent;
import lv.timing.mainWindow.MainWindowView;
import lv.timing.race.teamRace.services.DeleteTeamRaceRow;
import lv.timing.race.teamRace.services.InitTeamRaceModel;
import lv.timing.race.teamRace.services.UpdateValuesTeamRace;
import lv.timing.race.teamRace.services.timer.TeamTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class TeamRaceController {

    @Autowired
    private TeamRaceView view;

    @Autowired
    private InitCBoxEvent initCBoxEvent;

    @Autowired
    private InitCBoxSubEvent initCBoxSubEvent;

    @Autowired
    private InitTeamRaceModel initTeamRaceModel;

    @Autowired
    private UpdateValuesTeamRace update;

    @Autowired
    private DeleteTeamRaceRow deleteRow;

    @Autowired
    private TeamTimer teamTimer;

    @PostConstruct
    public void init() {
        view.formatTable(view.getModel());
        view.getModel().addTableModelListener(tme -> update.execute(tme, view));
        view.getComboBoxEvent().addActionListener(e -> initCBoxSubEvent.init(view.getComboBoxEvent(), view.getComboBoxSubEvent()));
        view.getComboBoxSubEvent().addActionListener(e -> teamTimer.timer(view));
        view.getBtnDeleteRow().addActionListener(e -> deleteRow.execute(view));
        view.getModel().addTableModelListener(tme -> update.execute(tme, view));
    }

    public void execute() {
        initSingleRaceView();
        try {
            view.getFrame().setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    private void initSingleRaceView() {
        view.getComboBoxSubEvent().removeAllItems();
        view.getComboBoxSubEvent().removeAllItems();
        view.getModel().setRowCount(0);

        initCBoxEvent.init(view.getComboBoxEvent());

        Icon icon = new ImageIcon(getClass().getResource("/images/icons_small.png"));
        view.getFrame().setFrameIcon(icon);

        view.getFrame().setVisible(true);

        //Center and add JInternalFrame
        JDesktopPane desktop = MainWindowView.getDesktop();
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = view.getFrame().getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        view.getFrame().setLocation(width, 300);
        desktop.add(view.getFrame());
    }
}

