package lv.initex.report.teamReport;

import lv.initex.genericServices.GenericServiceDispatcher;
import lv.initex.mainWindow.MainWindowView;
import lv.initex.report.teamReport.services.PreviewTeamStageResultsService;
import lv.initex.report.teamReport.services.PreviewTeamStartListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class TeamRaceReportController {

    @Autowired
    private TeamRaceReportView view;

    @Autowired
    private GenericServiceDispatcher genericService;

    @Autowired
    private PreviewTeamStartListService startList;

    @Autowired
    private PreviewTeamStageResultsService stageResults;


    @PostConstruct
    public void init() {
        view.getBtnStartList().addActionListener(e -> startList.execute());
        view.getBtnHeatResultsList().addActionListener(e -> stageResults.execute());
        view.getComboBoxEvent().addActionListener(e -> genericService.initCBoxSubEvent(view.getComboBoxEvent(), view.getComboBoxSubEvent()));
    }

    public void execute() {
        initReportView();
        try {
            view.getFrame().setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    private void initReportView() {
        Icon icon = new ImageIcon(getClass().getResource("/images/icons_small.png"));
        view.getFrame().setFrameIcon(icon);
        view.getComboBoxSubEvent().removeAllItems();

        genericService.initCBoxEvent(view.getComboBoxEvent());
        genericService.initCBoxTeamBoatClass(view.getComboBoxClass());

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
