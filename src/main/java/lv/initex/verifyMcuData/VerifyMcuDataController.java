package lv.initex.verifyMcuData;

import lv.initex.mainWindow.MainWindowView;
import lv.initex.verifyMcuData.services.InitMcuModel;
import lv.initex.verifyMcuData.services.UpdateFinish;
import lv.initex.verifyMcuData.services.UpdateStart;
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
    private UpdateStart updateStart;

    @Autowired
    private UpdateFinish updateFinish;

    @Autowired
    private McuTimer timer;

    @Autowired
    private InitMcuModel InitMcuModel;

    @PostConstruct
    public void init() {
        view.formatTables();
        view.getModelStart().addTableModelListener(tme -> updateStart.execute(tme, view));
        view.getModelFinish().addTableModelListener(tme -> updateFinish.execute(tme, view));

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
        InitMcuModel.init(true, view);
        InitMcuModel.init(false, view);
        view.getFrame().setVisible(true);

        JDesktopPane desktop = MainWindowView.getDesktop();
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = view.getFrame().getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        view.getFrame().setLocation(width, 0);
        desktop.add(view.getFrame());
    }
}
