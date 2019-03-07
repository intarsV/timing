package lv.timing.race.singleRace.processSingleRace;

import lv.timing.genericServices.InitCBoxEvent;
import lv.timing.genericServices.InitCBoxSubEvent;
import lv.timing.mainWindow.MainWindowView;
import lv.timing.race.singleRace.services.AddListener;
import lv.timing.race.singleRace.services.DeleteSingleRaceRow;
import lv.timing.race.singleRace.services.InitSingleRaceModel;
import lv.timing.race.singleRace.services.UpdateValuesSingleRace;
import lv.timing.race.singleRace.services.timer.SingleTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class SingleRaceController {

    @Autowired
    private SingleRaceView view;

    @Autowired
    private InitCBoxEvent initCBoxEvent;

    @Autowired
    private InitCBoxSubEvent initCBoxSubEvent;

    @Autowired
    private InitSingleRaceModel initSingleRaceModel;

    @Autowired
    private UpdateValuesSingleRace update;

    @Autowired
    private DeleteSingleRaceRow deleteRow;

    @Autowired
    private SingleTimer singleTimer;

    @PostConstruct
    public void init() {
        view.formatTable(view.getModel());
        view.getModel().addTableModelListener(tme -> update.execute(tme, view));
        view.getComboBoxEvent().addActionListener(e -> initCBoxSubEvent.init(view.getComboBoxEvent(), view.getComboBoxSubEvent()));
        view.getComboBoxSubEvent().addActionListener(e -> singleTimer.timer(view));
        view.getBtnDeleteRow().addActionListener(e -> deleteRow.execute(view));
        AddListener.addListener(view.getDataTable());
    }

    public void execute() {
        initSingleRaceView();
        try {
            view.getFrame().setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    private void initSingleRaceView() {
        view.getComboBoxEvent().removeAllItems();
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

