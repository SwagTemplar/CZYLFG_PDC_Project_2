
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * @author Connor Stewart 17982915
 */
public class LoginPanel extends JPanel {

    private InvView invview;

    private JButton logIn;
    private JTextField usernameInput;
    private JTextField passwordInput;
    private JLabel username;
    private JLabel password;
    public JLabel message;
    private JLabel userLoginDetails;
    private JLabel passLoginDetails;
    private GridBagConstraints gBC;

    public LoginPanel(InvView invview) {
        this.invview = invview;
        this.setSize(invview.getWidth(), invview.getHeight());
        components();
    }

    private void components() {

        gBC = new GridBagConstraints();
        // Login Button

        gBC.insets = new Insets(10, 10, 10, 10);

        username = new JLabel("Username");
        gBC.gridx = 0;
        gBC.gridy = 0;
        this.add(username, gBC);
        username.setVisible(true);

        usernameInput = new JTextField(30);
        gBC.gridx = 1;
        gBC.gridy = 0;
        this.add(usernameInput, gBC);
        usernameInput.setVisible(true);

        password = new JLabel("Password");
        gBC.gridx = 2;
        gBC.gridy = 0;
        this.add(password, gBC);
        password.setVisible(true);

        passwordInput = new JTextField(30);
        gBC.gridx = 3;
        gBC.gridy = 0;
        this.add(passwordInput, gBC);
        passwordInput.setVisible(true);

        logIn = new JButton();
        gBC.anchor = GridBagConstraints.CENTER;
        gBC.gridx = 1;
        gBC.gridy = 1;
        this.add(logIn, gBC);
        getLogIn().setText("Login");
        getLogIn().setVisible(true);

        message = new JLabel();
        message.setText("Please Login to continue");
        this.add(this.message, BorderLayout.SOUTH);
        
        userLoginDetails = new JLabel();
        userLoginDetails.setText("Client login: Username = bob");
        this.add(this.userLoginDetails, BorderLayout.SOUTH);
        
        passLoginDetails = new JLabel();
        passLoginDetails.setText("Client login: Password = 123");
        this.add(this.passLoginDetails, BorderLayout.SOUTH);
        
    }

    /**
     * @return the logIn
     */
    public JButton getLogIn() {
        return logIn;
    }

    /**
     * @return the usernameInput
     */
    public String getUsernameInput() {
        return usernameInput.getText();
    }

    /**
     * @return the passwordInput
     */
    public String getPasswordInput() {
        return passwordInput.getText();
    }

    /**
     * @param usernameInput the usernameInput to set
     */
    public void setUsernameInput(String usernameInput) {
        this.usernameInput.setText(usernameInput);
    }

    /**
     * @param passwordInput the passwordInput to set
     */
    public void setPasswordInput(String passwordInput) {
        this.passwordInput.setText(passwordInput);
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message.setText(message);
    }

}
