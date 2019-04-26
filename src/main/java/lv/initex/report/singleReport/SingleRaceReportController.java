package lv.initex.report.singleReport;

import lv.initex.genericServices.InitCBoxEvent;
import lv.initex.genericServices.InitCBoxSingleBoatClass;
import lv.initex.genericServices.InitCBoxSubEvent;
import lv.initex.mainWindow.MainWindowView;
import lv.initex.report.singleReport.services.GrandTotalGroupService;
import lv.initex.report.singleReport.services.GrandTotalListService;
import lv.initex.report.singleReport.services.PreviewStageResultsService;
import lv.initex.report.singleReport.services.PreviewStartListService;
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
    private InitCBoxEvent initCBoxEvent;

    @Autowired
    private InitCBoxSubEvent initCBoxSubEvent;

    @Autowired
    private InitCBoxSingleBoatClass initCBoxBoatClass;

    @Autowired
    private PreviewStartListService startList;

    @Autowired
    private PreviewStageResultsService stageResults;

    @Autowired
    private GrandTotalListService grandTotalList;

    @Autowired
    private GrandTotalGroupService grandTotalByGroup;

    @PostConstruct
    public void init() {
        view.getBtnStartList().addActionListener(e -> startList.execute());
        view.getBtnHeatResultsList().addActionListener(e -> stageResults.execute());
        view.getComboBoxEvent().addActionListener(e -> initCBoxSubEvent.init(view.getComboBoxEvent(), view.getComboBoxSubEvent()));
        view.getBtnGrandTotal().addActionListener(e -> grandTotalList.execute());
        view.getBtnGrandTotalGroups().addActionListener(e -> grandTotalByGroup.execute());
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

        initCBoxEvent.init(view.getComboBoxEvent());
        initCBoxBoatClass.init(view.getComboBoxClass());

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
