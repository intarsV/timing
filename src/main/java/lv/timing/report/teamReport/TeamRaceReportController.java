package lv.timing.report.teamReport;

import lv.timing.mainWindow.MainWindowView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class TeamRaceReportController {

    @Autowired
    private TeamRaceReportView view;

    @Autowired
    private TeamRaceReportService service;

    private boolean addActionsAndRunServices = true;

    public void execute() {
        initReportView();
        if (addActionsAndRunServices = true) {
        view.getBtnStartList().addActionListener(e -> service.previewStartLis());
//        view.getBtnHeatResultsList().addActionListener(e -> previewHeatResults());
            view.getComboBoxEvent().addActionListener(e -> service.initCBoxSubEvent(view.getComboBoxEvent(), view.getComboBoxSubEvent()));
            addActionsAndRunServices = false;
        }
    }

    private void initReportView() {
        Icon icon = new ImageIcon(getClass().getResource("/images/icons_small.png"));
        view.getFrame().setFrameIcon(icon);
        view.getComboBoxSubEvent().removeAllItems();

        service.initCBoxEvent(view.getComboBoxEvent());
        service.initCBoxBoatClass(view.getComboBoxClass());

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
