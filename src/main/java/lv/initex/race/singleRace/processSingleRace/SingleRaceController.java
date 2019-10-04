package lv.initex.race.singleRace.processSingleRace;

import lv.initex.genericServices.GenericServiceDispatcher;
import lv.initex.mainWindow.MainWindowView;
import lv.initex.race.Observer;
import lv.initex.race.ViewListener;
import lv.initex.race.singleRace.services.AddListener;
import lv.initex.race.singleRace.services.SingleRaceServiceDispatcher;
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
public class SingleRaceController implements Observer {
    private List<Observable> observableList = new ArrayList<>();

    @Autowired
    private SingleRaceView view;

    @Autowired
    private SingleRaceServiceDispatcher service;

    @Autowired
    private GenericServiceDispatcher genericService;

    @Autowired
    private VerifyMcuDataModelStart startModel;

    @Autowired
    private VerifyMcuDataModelFinish finishModel;

    @PostConstruct
    public void init() {
        view.formatTable(view.getModel());
        view.getModel().addTableModelListener(tme -> service.updateValuesSingleRace(tme, view));
        view.getComboBoxEvent().addActionListener(e -> genericService.initCBoxSubEvent(view.getComboBoxEvent(), view.getComboBoxSubEvent()));
        view.getComboBoxSubEvent().addActionListener(e -> startModel.registerObserver(this));
        view.getComboBoxSubEvent().addActionListener(e -> finishModel.registerObserver(this));
        view.getComboBoxSubEvent().addActionListener(e -> service.initSingleRaceModel(false, view));
        view.getBtnDeleteRow().addActionListener(e -> service.deleteSingleRaceRow(view));
        observableList.add(startModel);
        observableList.add(finishModel);
        view.getFrame().addInternalFrameListener(new ViewListener(observableList, this));
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
        service.singleProcessMCUData(view);
    }
}

