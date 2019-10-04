package lv.initex.competitors;

import lv.initex.competitors.services.*;
import lv.initex.mainWindow.MainWindowView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class CompetitorsController {

    @Autowired
    private CompetitorsView view;

    @Autowired
    private CompetitorsServiceDispatcher service;

    @PostConstruct
    public void init() {
        view.formatTable();
        service.initModel(view);
        service.initInitCBoxCountry(view);

        view.getBtnInsert().addActionListener(e -> service.addCompetitor(view));
        view.getBtnDelete().addActionListener(e -> service.deleteCompetitor(view));
        view.getCompetitorsTable().getModel().addTableModelListener(tme -> service.updateCompetitor(tme,view));
    }

    public void execute() {
        prepareCompetitorsView();
        try {
            view.getFrame().setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    private void prepareCompetitorsView() {
        Icon icon = new ImageIcon(getClass().getResource("/images/icons_small.png"));
        view.getFrame().setFrameIcon(icon);

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
