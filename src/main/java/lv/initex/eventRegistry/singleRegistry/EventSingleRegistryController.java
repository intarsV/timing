package lv.initex.eventRegistry.singleRegistry;

import lv.initex.competitionEvent.CompetitionEventController;
import lv.initex.competitors.CompetitorsController;
import lv.initex.eventRegistry.singleRegistry.services.*;
import lv.initex.genericServices.InitCBoxCompetitors;
import lv.initex.genericServices.InitCBoxEvent;
import lv.initex.genericServices.InitCBoxGroup;
import lv.initex.genericServices.InitCBoxSingleBoatClass;
import lv.initex.mainWindow.MainWindowView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class EventSingleRegistryController {


    @Autowired
    private EventSingleRegistryView view;

    @Autowired
    private InitCBoxEvent initCBoxEvent;

    @Autowired
    private InitCBoxCompetitors initCBoxCompetitors;

    @Autowired
    private InitCBoxSingleBoatClass initCBoxBoatClass;

    @Autowired
    private InitCBoxGroup initCBoxGroup;

    @Autowired
    private AddSingleRegistry add;

    @Autowired
    private DeleteFromRegistry delete;

    @Autowired
    private UpdateToRegistry update;

    @Autowired
    private InitEventSingleRegistryModel initEventSingleRegistryModel;

    @Autowired
    private CompetitionEventController eventController;

    @Autowired
    private CompetitorsController competitorsController;

    @PostConstruct
    public void init() {
        view.formatTable();
        view.getComboBoxEvent().addActionListener(e -> initEventSingleRegistryModel.init());
        view.getBtnInsert().addActionListener(e -> add.execute());
        view.getBtnDelete().addActionListener(e -> delete.execute());
        view.getBtnUpdate().addActionListener(e -> update.execute());
        view.getTable().getSelectionModel().addListSelectionListener(e -> UpdateControls.update(view));
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

        initCBoxEvent.init(view.getComboBoxEvent());
        initCBoxGroup.init(view.getComboBoxGroup());
        initCBoxBoatClass.init(view.getComboBoxClass());
        initCBoxCompetitors.init(view.getComboBoxCompetitor());
        view.getTextFieldBIB().setText("");

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