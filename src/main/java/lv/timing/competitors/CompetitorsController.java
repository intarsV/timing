package lv.timing.competitors;

import lv.timing.competitors.services.*;
import lv.timing.mainWindow.MainWindowView;
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
    private AddCompetitor add;

    @Autowired
    private DeleteCompetitor delete;

    @Autowired
    private UpdateValuesCompetitors update;

    @Autowired
    private InitCBoxCountry initCBoxCountry;

    @Autowired
    private InitCompetitorsModel getCompetitorList;

    @PostConstruct
    public void init() {
        view.formatTable();
        getCompetitorList.init(view);
        initCBoxCountry.initComboBoxCountry(view);

        view.getBtnInsert().addActionListener(e -> add.execute(view));
        view.getBtnDelete().addActionListener(e -> delete.execute(view));
        view.getCompetitorsTable().getModel().addTableModelListener(tme -> update.execute(tme,view));
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
