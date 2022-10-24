
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * @author Connor Stewart 17982915
 */
public class InvView extends JFrame {

    private JPanel userPanel = new JPanel(new GridBagLayout());
    private JButton vCuInv = new JButton("View current inventory");
    private JButton crOrd = new JButton("Create new order");
    private JButton vCuOrd = new JButton("View current orders");
    private JButton logOut = new JButton("Logout");
    private JTextArea fileView = new JTextArea();

    GridBagConstraints gBC = new GridBagConstraints();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public InvView() {
        int userScreenWidth = screenSize.width / 2;
        int userScreenHeight = screenSize.height / 2;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(userScreenWidth, userScreenHeight);
        this.setLocationRelativeTo(null);

        gBC.insets = new Insets(10, 10, 10, 10);
        gBC.gridx = 0;
        gBC.gridy = 1;
        this.userPanel.add(vCuInv, gBC);
        gBC.gridx = 0;
        gBC.gridy = 2;
        this.userPanel.add(vCuOrd, gBC);
        gBC.gridx = 0;
        gBC.gridy = 3;
        this.userPanel.add(crOrd, gBC);
        gBC.gridx = 0;
        gBC.gridy = 4;
        this.userPanel.add(logOut, gBC);

        this.add(new JScrollPane(fileView));
        this.add(userPanel, BorderLayout.EAST);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        InvView view = new InvView();
    }
}
