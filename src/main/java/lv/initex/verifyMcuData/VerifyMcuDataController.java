package lv.initex.verifyMcuData;

import lv.initex.mainWindow.MainWindowView;
import lv.initex.verifyMcuData.services.VerifyMCuServiceDispatcher;
import lv.initex.verifyMcuData.services.timer.McuTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class VerifyMcuDataController {

    @Autowired
    private VerifyMcuDataView view;

    @Autowired
    private VerifyMCuServiceDispatcher service;

    @Autowired
    private McuTimer timer;

    @PostConstruct
    public void init() {
        view.formatTables();
        view.getModelStart().addTableModelListener(tme -> service.updateStart(tme, view));
        view.getModelFinish().addTableModelListener(tme -> service.updateFinish(tme, view));
    }

    public void execute() {
        initAcceptIncomingView();
        timer.timer(view);
        try {
            view.getFrame().setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    private void initAcceptIncomingView() {
        service.initMcuModel(true, view);
        service.initMcuModel(false, view);
        view.getFrame().setVisible(true);

        JDesktopPane desktop = MainWindowView.getDesktop();
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = view.getFrame().getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        view.getFrame().setLocation(width, 0);
        desktop.add(view.getFrame());
    }
}
