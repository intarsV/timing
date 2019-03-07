package lv.timing.verifyMcuData;

import lv.timing.mainWindow.MainWindowView;
import lv.timing.verifyMcuData.services.GetTMPList;
import lv.timing.verifyMcuData.services.UpdateFinish;
import lv.timing.verifyMcuData.services.UpdateStart;
import lv.timing.verifyMcuData.services.timer.McuTimer;
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
    private GetTMPList getTMPList;

    @PostConstruct
    public void init() {
        view.formatTables();
        view.getModelStart().addTableModelListener(tme -> updateStart.execute(tme, view));
        view.getModelFinish().addTableModelListener(tme -> updateFinish.execute(tme, view));
        timer.timer(view);
    }

    public void execute() {
        initAcceptIncomingView();
        try {
            view.getFrame().setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    private void initAcceptIncomingView() {
        getTMPList.getTmpList(true, view);
        getTMPList.getTmpList(false, view);
        view.getFrame().setVisible(true);

        JDesktopPane desktop = MainWindowView.getDesktop();
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = view.getFrame().getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        view.getFrame().setLocation(width, 0);
        desktop.add(view.getFrame());
    }
}
