
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * @author Kisoon Park 18008173 & Connor Stewart 17982915
 */
public class LoginPanel extends JPanel {
    // Variable
    private InvView invview;
    // Components that will be used in the panel
    private JButton logIn;
    private JButton quit;
    private JTextField usernameInput;
    private JTextField passwordInput;
    private JLabel username;
    private JLabel password;
    public JLabel message;
    private JLabel userLoginDetails;
    private JLabel passLoginDetails;
    private GridBagConstraints gBC;
// Constructor setting size to invview
    public LoginPanel(InvView invview) {
        this.invview = invview;
        this.setSize(invview.getWidth(), invview.getHeight());
        components();
    }
// adding all the components into the panel
    private void components() {

        gBC = new GridBagConstraints();
        // sets bounds for components using GridBagConstraints and insets
        gBC.insets = new Insets(10, 10, 10, 10);
        
        // adds label to inform user what textfield they are typing in
        username = new JLabel("Username");
        gBC.gridx = 0;
        gBC.gridy = 0;
        this.add(username, gBC);
        username.setVisible(true);

        // adds textfeild for user to type username
        usernameInput = new JTextField(30);
        gBC.gridx = 1;
        gBC.gridy = 0;
        this.add(usernameInput, gBC);
        usernameInput.setVisible(true);

        // adds label to inform user what textfield they are typing in
        password = new JLabel("Password");
        gBC.gridx = 2;
        gBC.gridy = 0;
        this.add(password, gBC);
        password.setVisible(true);

        // adds textfeild for user to type password
        passwordInput = new JTextField(30);
        gBC.gridx = 3;
        gBC.gridy = 0;
        this.add(passwordInput, gBC);
        passwordInput.setVisible(true);

        // adds button to login with
        logIn = new JButton();
        gBC.anchor = GridBagConstraints.CENTER;
        gBC.gridx = 1;
        gBC.gridy = 1;
        this.add(logIn, gBC);
        getLogIn().setText("Login");
        getLogIn().setVisible(true);

        // adds label to prompt user to input login information
        message = new JLabel();
        message.setText("Please Login to continue");
        this.add(this.message, BorderLayout.SOUTH);
        
        // adds label so marker can login
        userLoginDetails = new JLabel();
        userLoginDetails.setText("Client login: Username = bob");
        this.add(this.userLoginDetails, BorderLayout.SOUTH);
        
        // adds label so marker can login
        passLoginDetails = new JLabel();
        passLoginDetails.setText("Client login: Password = 123");
        this.add(this.passLoginDetails, BorderLayout.SOUTH);
        
        // adds a quit button so user may exit the application without pressing X button on window,
        // however user must logout to quit
        quit = new JButton();
        gBC.anchor = GridBagConstraints.CENTER;
        gBC.gridx = 1;
        gBC.gridy = 1;
        this.add(quit, gBC);
        getQuit().setText("Quit");
        getQuit().setVisible(true);
        
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

    /**
     * @return the quit
     */
    public JButton getQuit() {
        return quit;
    }

}
