package lv.initex.login;


import lv.initex.database.UserRepository;
import lv.initex.domain.User;
import lv.initex.mainWindow.MainWindowController;
import lv.initex.mainWindow.MainWindowView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

@Component
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginView view;

    @Autowired
    private MainWindowController mainWindowController;

    public void execute() {
        initialize();
        try {
            view.getFrame().setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
        view.getTxtUserName().addActionListener(e -> verifyCredentials());
        view.getBtnLogin().addActionListener(e -> verifyCredentials());
        view.getBtnReset().addActionListener(e -> resetFields());
        view.getBtnExit().addActionListener(e -> exitProgram());
    }

    private void initialize() {

        Icon icon = new ImageIcon(getClass().getResource("/images/icons_small.png"));
        view.getFrame().setFrameIcon(icon);

        view.getTxtUserName().setText("ini");           //Should be removed
        view.getTxtPassword().setText("xxx");           //Should be removed

        JDesktopPane desktop = MainWindowView.getDesktop();
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = view.getFrame().getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        view.getFrame().setLocation(width, height);
        desktop.add(view.getFrame());
    }

    private void verifyCredentials() {
        Optional<User> foundUser = userRepository.findByLogin(view.getTxtUserName().getText());
        if (foundUser.isPresent()) {
            if (foundUser.get().getPassword().equals(view.getTxtPassword().getText())) {
                view.getFrame().setVisible(false);
                mainWindowController.addActionListeners();
            } else {
                System.out.println("Wrong password");
            }
        } else
            System.out.println("No such user");
    }

    private void resetFields() {
        view.getTxtUserName().setText(null);
        view.getTxtPassword().setText(null);
    }

    private void exitProgram() {
        System.exit(0);
    }

}