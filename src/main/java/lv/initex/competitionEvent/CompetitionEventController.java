package lv.initex.competitionEvent;

import lv.initex.competitionEvent.services.EventServiceDispatcher;
import lv.initex.mainWindow.MainWindowView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class CompetitionEventController {

    @Autowired
    private CompetitionEventView view;

    @Autowired
    private EventServiceDispatcher service;

    @PostConstruct
    public void init() {
        view.formatTable();
        view.getBtnInsert().addActionListener(e -> service.addEvent(view));
        view.getBtnDelete().addActionListener(e -> service.deleteEvent(view));
        view.getModel().addTableModelListener(tme -> service.updateEvent(tme, view));
    }

    public void execute() {
        initEventView();
        try {
            view.getFrame().setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    private void initEventView() {
        service.initModel(view);
        service.iniCBoxFormat(view);
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
