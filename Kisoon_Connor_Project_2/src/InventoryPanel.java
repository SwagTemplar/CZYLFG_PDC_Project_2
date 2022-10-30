
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/*
 * @author Connor Stewart 17982915
 */
class InventoryPanel extends JPanel {

    private InvView invview;

    private JLabel message;
    private JTextArea fileView;
    private JButton backButton;
    private GridBagConstraints gBC;
    private JScrollPane scrollPane;

    public InventoryPanel(InvView invview) {
        this.invview = invview;
        this.setSize(invview.getWidth(), invview.getHeight());
        components();
    }

    private void components() {
        gBC = new GridBagConstraints();

        gBC.insets = new Insets(10, 10, 10, 10);

        backButton = new JButton();
        backButton.setText("Back");
        gBC.anchor = GridBagConstraints.NORTH;
        backButton.setVisible(true);
        
        message = new JLabel();
        this.add(this.message, BorderLayout.SOUTH);
        message.setText("Viewing Inventory");
        
        this.add(backButton, gBC);
        this.add(scrollPane = new JScrollPane(new JTextArea(30,20)), BorderLayout.PAGE_START);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(30, 40, 100, 100);
    }

    /**
     * @return the fileView
     */
    public JTextArea getFileView() {
        return fileView;
    }

    /**
     * @return the backButton
     */
    public JButton getBackButton() {
        return backButton;
    }

}
