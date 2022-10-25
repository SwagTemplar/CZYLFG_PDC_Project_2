
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * @author Connor Stewart 17982915
 */
public class InvView extends JFrame {

    private JPanel viewerPanel = new JPanel(new GridBagLayout());
    private JPanel loginPanel = new JPanel(new GridBagLayout());
    private JButton vCuInv = new JButton("View current inventory");
    private JButton crOrd = new JButton("Create new order");
    private JButton vCuOrd = new JButton("View current orders");
    private JButton logOut = new JButton("Logout");
    private JTextArea fileView = new JTextArea();
    private JButton logIn = new JButton("Login");
    public JTextField usernameInput = new JTextField(20);
    public JTextField passwordInput = new JTextField(20);
    private JLabel username = new JLabel("Username: ");
    private JLabel password = new JLabel("Password: ");

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public InvView() {
        int userScreenWidth = screenSize.width / 2;
        int userScreenHeight = screenSize.height / 2;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(userScreenWidth, userScreenHeight);
        this.setLocationRelativeTo(null);

        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(10, 10, 10, 10);

        gBC.anchor = GridBagConstraints.CENTER;
        gBC.gridx = 0;
        gBC.gridy = 0;
        this.loginPanel.add(username, gBC);

        gBC.anchor = GridBagConstraints.CENTER;
        gBC.gridx = 1;
        gBC.gridy = 0;
        this.loginPanel.add(usernameInput, gBC);

        gBC.anchor = GridBagConstraints.CENTER;
        gBC.gridx = 2;
        gBC.gridy = 0;
        this.loginPanel.add(password, gBC);

        gBC.anchor = GridBagConstraints.CENTER;
        gBC.gridx = 3;
        gBC.gridy = 0;
        this.loginPanel.add(passwordInput, gBC);

        gBC.anchor = GridBagConstraints.CENTER;
        gBC.gridx = 4;
        gBC.gridy = 0;
        this.loginPanel.add(logIn, gBC);

        this.add(loginPanel);
        this.setVisible(true);
    }

    public void Viewer() {

        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(10, 10, 10, 10);
        gBC.gridx = 0;
        gBC.gridy = 1;
        this.viewerPanel.add(vCuInv, gBC);
        gBC.gridx = 0;
        gBC.gridy = 2;
        this.viewerPanel.add(vCuOrd, gBC);
        gBC.gridx = 0;
        gBC.gridy = 3;
        this.viewerPanel.add(crOrd, gBC);
        gBC.gridx = 0;
        gBC.gridy = 4;
        this.viewerPanel.add(logOut, gBC);

        this.getContentPane().removeAll();
        this.add(new JScrollPane(fileView));
        this.add(viewerPanel, BorderLayout.EAST);
        viewerPanel.setVisible(true);
        this.add(viewerPanel);
        this.revalidate();
        this.repaint();
    }

    public static void main(String[] args) {
        InvView view = new InvView();

    }

    void addActionListener(ActionListener listener) {
        this.logIn.addActionListener(listener);
    }
}
