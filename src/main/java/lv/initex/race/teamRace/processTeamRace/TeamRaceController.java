package lv.initex.race.teamRace.processTeamRace;

import lv.initex.genericServices.GenericServiceDispatcher;
import lv.initex.mainWindow.MainWindowView;
import lv.initex.race.Observer;
import lv.initex.race.ViewListener;
import lv.initex.race.teamRace.services.DeleteTeamRaceRow;
import lv.initex.race.teamRace.services.InitTeamRaceModel;
import lv.initex.race.teamRace.services.TeamRaceServiceDispatcher;
import lv.initex.race.teamRace.services.UpdateValuesTeamRace;
import lv.initex.verifyMcuData.Observable;
import lv.initex.verifyMcuData.VerifyMcuDataModelFinish;
import lv.initex.verifyMcuData.VerifyMcuDataModelStart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TeamRaceController implements Observer {

    private List<Observable> observableList = new ArrayList<>();

    @Autowired
    private TeamRaceView view;

    @Autowired
    private GenericServiceDispatcher genericService;

    @Autowired
    private TeamRaceServiceDispatcher service;

    @Autowired
    private VerifyMcuDataModelStart startModel;

    @Autowired
    private VerifyMcuDataModelFinish finishModel;

    @PostConstruct
    public void init() {
        view.formatTable(view.getModel());
        view.getModel().addTableModelListener(tme -> service.updateValuesTeamRace(tme, view));
        view.getComboBoxEvent().addActionListener(e -> genericService.initCBoxSubEvent(view.getComboBoxEvent(), view.getComboBoxSubEvent()));
        view.getComboBoxSubEvent().addActionListener(e -> startModel.registerObserver(this));
        view.getComboBoxSubEvent().addActionListener(e -> finishModel.registerObserver(this));
        view.getComboBoxSubEvent().addActionListener(e -> service.initTeamRaceModel(false, view));
        observableList.add(startModel);
        observableList.add(finishModel);
        view.getBtnDeleteRow().addActionListener(e -> service.deleteTeamRaceRow(view));
        view.getFrame().addInternalFrameListener(new ViewListener(observableList, this));
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

        genericService.initCBoxEvent(view.getComboBoxEvent());

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

    @Override
    public void update() {
        service.teamProcessMCUData(view);
    }
}

