
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * @author Kisoon Park 18008173 & Connor Stewart 17982915
 */
class ClientMenuPanel extends JPanel {
    // Variables
    private InvView invview;
    // Components that will be used in the panel
    private JButton viewCurrentInventory;
    private JButton createOrder;
    private JButton viewCurrentOrder;
    private JButton logOut;
    private GridBagConstraints gBC;
    private JLabel message;
    // Constructor setting size to invview
    public ClientMenuPanel(InvView invview) {
        this.invview = invview;
        this.setSize(invview.getWidth(), invview.getHeight());
        components();
    }
    // adding all the components into the panel
    private void components() {

        gBC = new GridBagConstraints();
        // sets bounds for components using GridBagConstraints and insets
        gBC.insets = new Insets(10, 10, 10, 10);
        // adds button
        viewCurrentInventory = new JButton();
        viewCurrentInventory.setText("View current inventory");
        viewCurrentInventory.setVisible(true);
        gBC.anchor = GridBagConstraints.CENTER;
        gBC.gridx = 0;
        gBC.gridy = 1;
        this.add(viewCurrentInventory, gBC);
        // adds button
        createOrder = new JButton();
        createOrder.setText("Create order");
        createOrder.setVisible(true);
        gBC.anchor = GridBagConstraints.CENTER;
        gBC.gridx = 0;
        gBC.gridy = 2;
        this.add(createOrder, gBC);
        // adds button
        viewCurrentOrder = new JButton();
        viewCurrentOrder.setText("view current orders");
        viewCurrentOrder.setVisible(true);
        gBC.anchor = GridBagConstraints.CENTER;
        gBC.gridx = 0;
        gBC.gridy = 3;
        this.add(viewCurrentOrder, gBC);
        // adds button
        logOut = new JButton();
        logOut.setText("Logout");
        logOut.setVisible(true);
        gBC.anchor = GridBagConstraints.CENTER;
        gBC.gridx = 0;
        gBC.gridy = 4;
        this.add(logOut, gBC);
        // adds label to let user know they logged in on client side
        message = new JLabel();
        this.add(this.message, BorderLayout.SOUTH);
        message.setText("Client login successful");
    }

    /**
     * @return the vCuInv
     */
    public JButton getViewCurrentInventory() {
        return viewCurrentInventory;
    }

    /**
     * @return the crOrd
     */
    public JButton getCreateOrder() {
        return createOrder;
    }

    /**
     * @return the vCuOrd
     */
    public JButton getViewCurrentOrder() {
        return viewCurrentOrder;
    }

    /**
     * @return the logOut
     */
    public JButton getLogOut() {
        return logOut;
    }

}
