package lv.timing.race.singleRace.editSingleRace;

import lv.timing.genericServices.InitCBoxEvent;
import lv.timing.genericServices.InitCBoxSubEvent;
import lv.timing.mainWindow.MainWindowView;
import lv.timing.race.singleRace.services.DeleteSingleRaceRow;
import lv.timing.race.singleRace.services.GetSingleRaceList;
import lv.timing.race.singleRace.services.UpdateValuesSingleRace;
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
    private InitCBoxEvent initCBoxEvent;

    @Autowired
    private InitCBoxSubEvent initCBoxSubEvent;

    @Autowired
    private GetSingleRaceList getSingleRaceList;

    @Autowired
    private UpdateValuesSingleRace update;

    @Autowired
    private DeleteSingleRaceRow delete;

    @PostConstruct
    public void init() {
        view.formatTable(view.getModel());
        view.getModel().addTableModelListener(tme -> update.execute(tme, view));
        view.getComboBoxEvent().addActionListener(e -> initCBoxSubEvent.init(view.getComboBoxEvent(), view.getComboBoxSubEvent()));
        view.getComboBoxSubEvent().addActionListener(e -> getSingleRaceList.getSingleRaceList(true, view));
        view.getBtnDeleteRow().addActionListener(e -> delete.execute(view));
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
        initCBoxEvent.init(view.getComboBoxEvent());

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

