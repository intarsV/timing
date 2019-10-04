package lv.initex.race.singleRace.editSingleRace;

import lv.initex.genericServices.GenericServiceDispatcher;
import lv.initex.mainWindow.MainWindowView;
import lv.initex.race.singleRace.services.SingleRaceServiceDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class EditSingleRaceController {

    @Autowired
    private EditSingleRaceView view;

    @Autowired
    private GenericServiceDispatcher genericService;

    @Autowired
    private SingleRaceServiceDispatcher service;

    @PostConstruct
    public void init() {
        view.formatTable(view.getModel());
        view.getModel().addTableModelListener(tme -> service.updateValuesSingleRace(tme, view));
        view.getComboBoxEvent().addActionListener(e -> genericService.initCBoxSubEvent(view.getComboBoxEvent(), view.getComboBoxSubEvent()));
        view.getComboBoxSubEvent().addActionListener(e -> service.initSingleRaceModel(true, view));
        view.getBtnDeleteRow().addActionListener(e -> service.deleteSingleRaceRow(view));
    }

    public void execute() {
        initEditSingleRaceView();
        try {
            view.getFrame().setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    private void initEditSingleRaceView() {
        Icon icon = new ImageIcon(getClass().getResource("/images/icons_small.png"));
        view.getFrame().setFrameIcon(icon);
        view.getModel().setRowCount(0);
        view.getComboBoxEvent().removeAllItems();
        view.getComboBoxSubEvent().removeAllItems();
        view.getFrame().setVisible(true);
        genericService.initCBoxEvent(view.getComboBoxEvent());

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

