package lv.timing.race.teamRace.editTeamRace;


import lv.timing.genericServices.InitCBoxEvent;
import lv.timing.genericServices.InitCBoxSubEvent;
import lv.timing.mainWindow.MainWindowView;
import lv.timing.race.teamRace.services.DeleteTeamRaceRow;
import lv.timing.race.teamRace.services.InitTeamRaceModel;
import lv.timing.race.teamRace.services.UpdateValuesTeamRace;
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
    private InitCBoxEvent initCBoxEvent;

    @Autowired
    private InitCBoxSubEvent initComboBoxSubEvent;

    @Autowired
    private InitTeamRaceModel initTeamRaceModel;

    @Autowired
    private UpdateValuesTeamRace update;

    @Autowired
    private DeleteTeamRaceRow delete;

    @PostConstruct
    public void init() {
        view.formatTable(view.getModel());
        view.getComboBoxEvent().addActionListener(e -> initComboBoxSubEvent.init(view.getComboBoxEvent(), view.getComboBoxSubEvent()));
        view.getComboBoxSubEvent().addActionListener(e -> initTeamRaceModel.init(true, view));
        view.getBtnDeleteRow().addActionListener(e -> delete.execute(view));
        view.getModel().addTableModelListener(tme -> update.execute(tme, view));
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

        initCBoxEvent.init(view.getComboBoxEvent());

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

