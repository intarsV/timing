package lv.initex.race.teamRace.editTeamRace;


import lv.initex.eventRegistry.teamRegistry.services.TeamServiceDispatcher;
import lv.initex.genericServices.GenericServiceDispatcher;
import lv.initex.mainWindow.MainWindowView;
import lv.initex.race.teamRace.services.TeamRaceServiceDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class EditTeamRaceController {

    @Autowired
    private EditTeamRaceView view;

    @Autowired
    private GenericServiceDispatcher genericService;

    @Autowired
    private TeamRaceServiceDispatcher service;

    @PostConstruct
    public void init() {
        view.formatTable(view.getModel());
        view.getComboBoxEvent().addActionListener(e -> genericService.initCBoxSubEvent(view.getComboBoxEvent(), view.getComboBoxSubEvent()));
        view.getComboBoxSubEvent().addActionListener(e -> service.initTeamRaceModel(true, view));
        view.getBtnDeleteRow().addActionListener(e -> service.deleteTeamRaceRow(view));
        view.getModel().addTableModelListener(tme -> service.updateValuesTeamRace(tme, view));
    }

    public void execute() {
        initEditTeamRaceView();
        try {
            view.getFrame().setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    private void initEditTeamRaceView() {
        view.getComboBoxSubEvent().removeAllItems();

        Icon icon = new ImageIcon(getClass().getResource("/images/icons_small.png"));
        view.getFrame().setFrameIcon(icon);

        genericService.initCBoxEvent(view.getComboBoxEvent());

        view.getFrame().setVisible(true);

        //Center and add JInternalFrame
        JDesktopPane desktop = MainWindowView.getDesktop();
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = view.getFrame().getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        //int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        view.getFrame().setLocation(width, 300);
        desktop.add(view.getFrame());
    }
}

