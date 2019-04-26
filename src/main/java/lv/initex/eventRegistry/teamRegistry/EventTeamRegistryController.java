package lv.initex.eventRegistry.teamRegistry;

import lv.initex.competitionEvent.CompetitionEventController;
import lv.initex.competitors.CompetitorsController;
import lv.initex.eventRegistry.teamRegistry.services.*;
import lv.initex.genericServices.InitCBoxCompetitors;
import lv.initex.genericServices.InitCBoxEvent;
import lv.initex.genericServices.InitCBoxTeamBoatClass;
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
    private InitCBoxEvent initEvent;

    @Autowired
    private InitCBoxCompetitors initCompetitors;

    @Autowired
    private InitCBoxTeamBoatClass initBoatClass;

    @Autowired
    private AddTeamRegistry add;

    @Autowired
    private DeleteFromRegistryTeam delete;

    @Autowired
    private UpdateToRegistryTeam update;

    @Autowired
    private InitEventTeamRegistryModel initEventTeamRegistryModel;

    @Autowired
    private CompetitionEventController eventController;

    @Autowired
    private CompetitorsController competitorsController;

    @PostConstruct
    public void init() {
        view.formatTable();
        view.getComboBoxEvent().addActionListener(e -> initEventTeamRegistryModel.init());
        view.getBtnInsert().addActionListener(e -> add.execute());
        view.getBtnDelete().addActionListener(e -> delete.execute());
        view.getBtnUpdate().addActionListener(e -> update.execute());
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
        initEvent.init(view.getComboBoxEvent());
        initBoatClass.init(view.getComboBoxClass());
        initCompetitors.init(view.getComboBoxCompetitorOne());
        initCompetitors.init(view.getComboBoxCompetitorTwo());
        initCompetitors.init(view.getComboBoxCompetitorThree());

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