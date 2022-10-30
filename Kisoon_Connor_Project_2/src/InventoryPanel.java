
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
 * @author Kisoon Park 18008173 & Connor Stewart 17982915
 */
class InventoryPanel extends JPanel {
// Variable
    private InvView invview;
// Components that will be used in the panel
    private JLabel message;
    private JTextArea fileView;
    private JButton backButton;
    private GridBagConstraints gBC;
    private JScrollPane scrollPane;
// Constructor setting size to invview
    public InventoryPanel(InvView invview) {
        this.invview = invview;
        this.setSize(invview.getWidth(), invview.getHeight());
        components();
    }
// adding all the components into the panel
    private void components() {
        
        gBC = new GridBagConstraints();
        // sets bounds for components using GridBagConstraints and insets
        gBC.insets = new Insets(10, 10, 10, 10);
        
        // adds button to go back
        backButton = new JButton();
        backButton.setText("Back");
        gBC.anchor = GridBagConstraints.NORTH;
        backButton.setVisible(true);
        
        // adds label to notify user what they are viewing
        message = new JLabel();
        this.add(this.message, BorderLayout.SOUTH);
        message.setText("Viewing Inventory");
        
        // adds scrollpane and textarea to display database content of inventory
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
