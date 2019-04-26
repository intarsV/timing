package lv.initex.login;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class LoginView extends JInternalFrame {

    private JInternalFrame frame;
    private JTextField txtUserName;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnReset;
    private JButton btnExit;

    public LoginView() {

        //Create frame
        frame = new JInternalFrame();
        frame.setTitle("Log to the system");
        frame.setSize(351, 183);
        frame.setVisible(true);

        //Create components
        JLabel lblUsername = new JLabel("Username");
        JLabel lblPassword = new JLabel("Password");
        txtUserName = new JTextField();
        txtUserName.setText("ini");
        txtPassword = new JPasswordField();
        btnLogin = new JButton("Login");
        btnReset = new JButton("Reset");
        btnExit = new JButton("Exit");

        //Layout components
        JComponent c = (JComponent) frame.getContentPane();
        frame.getContentPane().setLayout(null);
        txtUserName.setBounds(103, 30, 165, 25);
        c.add(txtUserName);
        txtUserName.setColumns(10);

        //  lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblUsername.setBounds(35, 35, 58, 14);
        c.add(lblUsername);

        txtPassword.setBounds(103, 61, 165, 25);
        c.add(txtPassword);

        // lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPassword.setBounds(35, 66, 58, 14);
        c.add(lblPassword);

        btnLogin.setBounds(17, 111, 89, 23);
        c.add(btnLogin);

        btnReset.setBounds(123, 111, 89, 23);
        c.add(btnReset);

        btnExit.setBounds(229, 111, 89, 23);
        c.add(btnExit);
  //      System.out.println(mainView.getDesktop().getSize());
       // System.out.println(v.getDesktop());

//        Dimension desktopSize = mainView.getDesktop().getSize();
//        Dimension jInternalFrameSize = frame.getSize();
//        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
//        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
//        frame.setLocation(width, height);
//       mainView.getDesktop().add(frame);

    }



    public JInternalFrame getFrame() {
        return frame;
    }

    public void setFrame(JInternalFrame frame) {
        this.frame = frame;
    }

    public JTextField getTxtUserName() {

        return txtUserName;
    }

    public void setTxtUserName(JTextField txtUserName) {
        this.txtUserName = txtUserName;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(JPasswordField txtPassword) {
        this.txtPassword = txtPassword;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(JButton btnLogin) {
        this.btnLogin = btnLogin;
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(JButton btnReset) {
        this.btnReset = btnReset;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public void setBtnExit(JButton btnExit) {
        this.btnExit = btnExit;
    }
}
