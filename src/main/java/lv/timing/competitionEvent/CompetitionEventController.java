package lv.timing.competitionEvent;

import lv.timing.competitionEvent.services.*;
import lv.timing.mainWindow.MainWindowView;
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
    private AddEvent add;

    @Autowired
    private DeleteEvent delete;

    @Autowired
    private UpdateEvent update;

    @Autowired
    private InitEventModel initEventModel;

    @Autowired
    private InitCBoxFormat initCBoxFormat;

    @PostConstruct
    public void init(){
        view.formatTable();
        view.getBtnInsert().addActionListener(e -> add.execute(view));
        view.getBtnDelete().addActionListener(e -> delete.execute(view));
        view.getModel().addTableModelListener(tme -> update.execute(tme,view));
    }

    public void execute() {
        initEventView();
        try {
            view.getFrame().setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    private void initEventView() {
        initEventModel.init(view);
        initCBoxFormat.initComboBoxFormat(view);
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
