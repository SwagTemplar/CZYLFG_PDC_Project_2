
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

class CreateOrderPanel extends JPanel{


    private InvView invview;

    private JTextField orderAmount;
    private JTextField orderItem;
    private JButton placeOrder;
    private JButton backButton;
    private GridBagConstraints gBC;
    private JLabel message;
    private JLabel itemLabel;
    private JLabel amountLabel;

    public CreateOrderPanel(InvView invview) {
        this.invview = invview;
        this.setSize(invview.getWidth(), invview.getHeight());
        components();
    }

    private void components() {

        gBC = new GridBagConstraints();

        gBC.insets = new Insets(10, 10, 10, 10);


        placeOrder = new JButton();
        getPlaceOrder().setText("Place order");
        getPlaceOrder().setVisible(true);
        gBC.anchor = GridBagConstraints.CENTER;
        gBC.gridx = 0;
        gBC.gridy = 2;
        this.add(getPlaceOrder(), gBC);
        
        orderItem = new JTextField(30);
        gBC.gridx = 1;
        gBC.gridy = 0;
        this.add(orderItem, gBC);
        orderItem.setVisible(true);
        
        itemLabel = new JLabel("Type and item you want");
        gBC.gridx = 2;
        gBC.gridy = 0;
        this.add(itemLabel, gBC);
        itemLabel.setVisible(true);
        
        orderAmount = new JTextField(5);
        gBC.gridx = 1;
        gBC.gridy = 0;
        this.add(orderAmount, gBC);
        orderAmount.setVisible(true);
        
        amountLabel = new JLabel("Type the amount (Integer only)");
        gBC.gridx = 2;
        gBC.gridy = 0;
        this.add(amountLabel, gBC);
        amountLabel.setVisible(true);

        backButton = new JButton();
        getBackButton().setText("Back");
        gBC.anchor = GridBagConstraints.NORTH;
        getBackButton().setVisible(true);

        this.add(getBackButton(), gBC);
        message = new JLabel();
        this.add(this.message, BorderLayout.SOUTH);
        message.setText("Order Items here");
    }

    /**
     * @return the placeOrder
     */
    public JButton getPlaceOrder() {
        return placeOrder;
    }

    /**
     * @return the backButton
     */
    public JButton getBackButton() {
        return backButton;
    }

}
