
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

/*
 * @author Kisoon Park 18008173 & Connor Stewart 17982915
 */
public class InvView extends JFrame implements Observer {

    // Panels
    private LoginPanel loginPanel;
    private ClientMenuPanel clientMenuPanel;
    private InventoryPanel inventoryPanel;
    private CreateOrderPanel createOrderPanel;
    
    // Getting user screen size
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    // Constructor
    public InvView() {
        int userScreenWidth = screenSize.width / 2;
        int userScreenHeight = screenSize.height / 2;
        this.setSize(userScreenWidth, userScreenHeight);
        this.setLocationRelativeTo(null);
        components();
        visiblePanels();
    }
    // Setting the frames up
    private void components() {
        this.loginPanel = new LoginPanel(this);
        this.clientMenuPanel = new ClientMenuPanel(this);
        this.inventoryPanel = new InventoryPanel(this);
        this.createOrderPanel = new CreateOrderPanel(this);
        this.add(getLoginPanel());
        this.add(getClientMenuPanel());
        this.add(getInventoryPanel());
        this.add(getCreateOrderPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    // Making loginPanel default visible and hiding others
    private void visiblePanels() {
        this.getLoginPanel().setVisible(true);
        this.getClientMenuPanel().setVisible(false);
        this.getInventoryPanel().setVisible(false);
        this.getCreateOrderPanel().setVisible(false);
    }
    // Creation of controllers
    public void createControllers(InvController controller) {
        getLoginPanel().getLogIn().addActionListener(controller);
        getClientMenuPanel().getViewCurrentInventory().addActionListener(controller);
        getClientMenuPanel().getViewCurrentOrder().addActionListener(controller);
        getClientMenuPanel().getCreateOrder().addActionListener(controller);
        getClientMenuPanel().getLogOut().addActionListener(controller);
        getInventoryPanel().getBackButton().addActionListener(controller);
        getCreateOrderPanel().getBackButton().addActionListener(controller);
        getCreateOrderPanel().getPlaceOrder().addActionListener(controller);
    }
    // Updates Observer checks if user login is correct
    @Override
    public void update(Observable o, Object arg) {

        InvModel model = (InvModel) arg;

        if (!model.user.loginFlag) {
            getLoginPanel().setUsernameInput("");
            getLoginPanel().setPasswordInput("");
            getLoginPanel().setMessage("Invalid username or password.");
        } else if (model.user.loginFlag) {
            if (!model.user.isAdmin) {
                model.getClient().setOrderList(model.clientOrders());
            }
        }
    }

    /**
     * @return the loginPanel
     */
    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    /**
     * @return the clientMenuPanel
     */
    public ClientMenuPanel getClientMenuPanel() {
        return clientMenuPanel;
    }

    /**
     * @return the inventoryPanel
     */
    public InventoryPanel getInventoryPanel() {
        return inventoryPanel;
    }

    /**
     * @return the createOrderPanel
     */
    public CreateOrderPanel getCreateOrderPanel() {
        return createOrderPanel;
    }
}
