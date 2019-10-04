package lv.initex.eventRegistry.teamRegistry;

import lv.initex.competitionEvent.CompetitionEventController;
import lv.initex.competitors.CompetitorsController;
import lv.initex.eventRegistry.teamRegistry.services.*;
import lv.initex.genericServices.GenericServiceDispatcher;
import lv.initex.mainWindow.MainWindowView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class EventTeamRegistryController {

    @Autowired
    private EventTeamRegistryView view;

    @Autowired
    private GenericServiceDispatcher genericService;

    @Autowired
    private TeamServiceDispatcher service;

    @Autowired
    private CompetitionEventController eventController;

    @Autowired
    private CompetitorsController competitorsController;

    @PostConstruct
    public void init() {
        view.formatTable();
        view.getComboBoxEvent().addActionListener(e -> service.initModel(view));
        view.getBtnInsert().addActionListener(e -> service.addTeamRegistry(view));
        view.getBtnDelete().addActionListener(e -> service.deleteFromRegistryTeam(view));
        view.getBtnUpdate().addActionListener(e -> service.updateToRegistryTeam(view));
        view.getResultTable().getSelectionModel().addListSelectionListener(e -> UpdateControlsTeam.update(view));
        view.getBtnAddEvent().addActionListener(e -> eventController.execute());
        view.getBtnAddCompetitor().addActionListener(e -> competitorsController.execute());
    }

    public void execute() {
        initSingleRegistryView();
        try {
            view.getFrame().setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    private void initSingleRegistryView() {
        genericService.initCBoxEvent(view.getComboBoxEvent());
        genericService.initCBoxTeamBoatClass(view.getComboBoxClass());
        genericService.initCBoxCompetitors(view.getComboBoxCompetitorOne());
        genericService.initCBoxCompetitors(view.getComboBoxCompetitorTwo());
        genericService.initCBoxCompetitors(view.getComboBoxCompetitorThree());

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
