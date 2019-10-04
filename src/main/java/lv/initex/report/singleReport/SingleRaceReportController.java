package lv.initex.report.singleReport;

import lv.initex.genericServices.GenericServiceDispatcher;
import lv.initex.mainWindow.MainWindowView;
import lv.initex.report.singleReport.services.GrandTotalGroupService;
import lv.initex.report.singleReport.services.GrandTotalListService;
import lv.initex.report.singleReport.services.PreviewStageResultsService;
import lv.initex.report.singleReport.services.PreviewStartListService;
import lv.initex.report.singleReport.services.jasperFrame.TestFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class SingleRaceReportController {

    @Autowired
    private SingleRaceReportView view;

    @Autowired
    private GenericServiceDispatcher genericService;

    @Autowired
    private PreviewStartListService startList;

    @Autowired
    private PreviewStageResultsService stageResults;

    @Autowired
    private GrandTotalListService grandTotalList;

    @Autowired
    private GrandTotalGroupService grandTotalByGroup;

    @Autowired
    private TestFrame testFrame;

    @PostConstruct
    public void init() {
        view.getBtnStartList().addActionListener(e -> startList.execute());
        view.getBtnHeatResultsList().addActionListener(e -> stageResults.execute());
        view.getComboBoxEvent().addActionListener(e -> genericService.initCBoxSubEvent(view.getComboBoxEvent(), view.getComboBoxSubEvent()));
        view.getBtnGrandTotal().addActionListener(e -> grandTotalList.execute());
        view.getBtnGrandTotalGroups().addActionListener(e -> grandTotalByGroup.execute());
        //testFrame.previewList();
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
        genericService.initCBoxSingleBoatClass(view.getComboBoxClass());

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
