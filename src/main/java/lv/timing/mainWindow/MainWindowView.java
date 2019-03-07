package lv.timing.mainWindow;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainWindowView extends JFrame {

    public static JDesktopPane desktop;

    public JMenuBar menuBar;

    public MainWindowView() {
        super("Initex Timing System");
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);

        //Set up the GUI.
        desktop = new JDesktopPane();
        desktop.setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);
        setContentPane(desktop);
        setDefaultCloseOperation(3);
        ImageIcon img = new ImageIcon(getClass().getResource("/images/icons_small.png"));
        setIconImage(img.getImage());

    }


    protected void createMenuBar() {
        menuBar = new JMenuBar();

        JMenu menuAddEdit = new JMenu("  Add/Edit  ");
        JMenu menuRace = new JMenu("  Race  ");
        JMenu menuReport = new JMenu("  Report  ");
        menuBar.add(menuAddEdit);
        menuBar.add(menuRace);
        menuBar.add(menuReport);

        JMenuItem menuItem = new JMenuItem("Competitors");
        menuAddEdit.add(menuItem);

        menuItem = new JMenuItem("Competition");
        menuAddEdit.add(menuItem);

        menuItem = new JMenuItem("Race Configuration");
        menuAddEdit.add(menuItem);

        menuItem = new JMenuItem("Single race registry");
        menuAddEdit.add(menuItem);

        menuItem = new JMenuItem("Team race registry");
        menuAddEdit.add(menuItem);

        menuItem = new JMenuItem("Quit");
        menuAddEdit.add(menuItem);

        menuItem = new JMenuItem("Accept incoming data");
        menuRace.add(menuItem);

        menuItem = new JMenuItem("Single Race");
        menuRace.add(menuItem);

        menuItem = new JMenuItem("Team race");
        menuRace.add(menuItem);

        menuItem = new JMenuItem("Edit single Race");
        menuRace.add(menuItem);

        menuItem = new JMenuItem("Edit team Race");
        menuRace.add(menuItem);

        menuItem = new JMenuItem("Single race Reports");
        menuReport.add(menuItem);

        menuItem = new JMenuItem("Team race Reports");
        menuReport.add(menuItem);
    }


    public static JDesktopPane getDesktop() {
        return desktop;
    }

    public void setDesktop(JDesktopPane desktop) {
        this.desktop = desktop;
    }


    public JMenuBar getBar() {
        return menuBar;
    }

    public void setBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }
}
