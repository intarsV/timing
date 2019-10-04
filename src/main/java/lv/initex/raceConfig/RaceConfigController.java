package lv.initex.raceConfig;

import lv.initex.genericServices.GenericServiceDispatcher;
import lv.initex.mainWindow.MainWindowView;
import lv.initex.raceConfig.services.InitRaceConfigModel;
import lv.initex.raceConfig.services.RaceConfigServiceDispatcher;
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
    private GenericServiceDispatcher genericService;

    @Autowired
    private RaceConfigServiceDispatcher service;

    @PostConstruct
    public void init() {
        view.formatTable();
        view.getComboBoxEvent().addActionListener(e -> service.initRaceConfigModel(view));
        view.getBtnInsert().addActionListener(e -> service.addRaceConfig(view));
        view.getBtnDelete().addActionListener(e -> service.deleteRaceConfig(view));
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

        genericService.initCBoxEvent(view.getComboBoxEvent());
        genericService.initCBoxSingleBoatClass(view.getComboBoxClass());

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
