package lv.timing.raceConfig;

import lv.timing.genericServices.InitCBoxEvent;
import lv.timing.genericServices.InitCBoxSingleBoatClass;
import lv.timing.mainWindow.MainWindowView;
import lv.timing.raceConfig.services.AddRaceConfig;
import lv.timing.raceConfig.services.DeleteRaceConfig;
import lv.timing.raceConfig.services.InitRaceConfigModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class RaceConfigController {

    @Autowired
    private RaceConfigView view;

    @Autowired
    private InitCBoxEvent initCBoxEvent;

    @Autowired
    private InitCBoxSingleBoatClass initCBoxSingleBoatClass;

    @Autowired
    private AddRaceConfig add;

    @Autowired
    private DeleteRaceConfig delete;

    @Autowired
    private InitRaceConfigModel getList;

    @PostConstruct
    public void init() {
        view.formatTable();
        view.getComboBoxEvent().addActionListener(e -> getList.init(view));
        view.getBtnInsert().addActionListener(e -> add.execute(view));
        view.getBtnDelete().addActionListener(e -> delete.execute(view));
    }

    public void execute() {
        prepareEventView();
        try {
            view.getFrame().setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    private void prepareEventView() {
        Icon icon = new ImageIcon(getClass().getResource("/images/icons_small.png"));
        view.getFrame().setFrameIcon(icon);

        initCBoxEvent.init(view.getComboBoxEvent());
        initCBoxSingleBoatClass.init(view.getComboBoxClass());

        view.getFrame().setVisible(true);

        JDesktopPane desktop = MainWindowView.getDesktop();
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = view.getFrame().getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        view.getFrame().setLocation(width, height);
        desktop.add(view.getFrame());
    }
}
