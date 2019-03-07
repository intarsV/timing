package lv.timing.mainWindow;

import lv.timing.login.LoginController;
import lv.timing.mainWindow.services.AddActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class MainWindowController {

    @Autowired
    private MainWindowView view;

    @Autowired
    private LoginController loginController;

    @Autowired
    private AddActions service;

    public void execute() {
        initialize();
    }

    private void initialize() {
        view.setVisible(true);
        view.createMenuBar();
        view.setJMenuBar(view.getBar());
        loginController.execute();
    }

    public void addActionListeners() {
        service.addListeners(view.menuBar);
    }
}
