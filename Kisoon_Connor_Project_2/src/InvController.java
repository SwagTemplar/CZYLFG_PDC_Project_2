
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @author Kisoon Park 18008173 & Connor Stewart 17982915
 */
public class InvController implements ActionListener {

    // Variables
    public InvView InvView;
    public InvModel InvModel;

    // Constructor
    public InvController(InvView InvView, InvModel InvModel) {
        this.InvView = InvView;
        this.InvModel = InvModel;
        this.InvView.createControllers(this);
    }

    // Handles ActionEvents through switch case
    public void actionPerformed(ActionEvent e) {
        String check = e.getActionCommand();
        switch (check) {
            case "Login":// checks for login button
                String username = this.InvView.getLoginPanel().getUsernameInput();
                String password = this.InvView.getLoginPanel().getPasswordInput();
                this.InvModel.validateUser(username, password);
                if (InvModel.user.loginFlag == true && InvModel.user.isAdmin == false) {
                    InvView.getClientMenuPanel().setVisible(true);
                    InvView.getLoginPanel().setVisible(false);
                }
                break;
            case "View current inventory": // checks for View current inventory button
                HandleViewCurrentInventoryButton();
                break;
            case "Back": // checks for Back button
                HandleBackButton();
                break;
            case "Logout": // checks for logout button
                HandleLogoutButton();
                break;
            case "Place order": // checks for Place order button
                HandlePlaceOrder();
                break;
            case "Create order": // checks for Create order button
                HandleCreateOrder();
                break;
            case "View current orders":
                HandleViewOrders();
                break;
            case "Quit":
                HandleQuit();
                break;

        }
    }

    // Button events - False hides the page and True makes the page visible then 
    // when updateObs is called it updated the page.
    private void HandleViewCurrentInventoryButton() {
        this.InvView.getClientMenuPanel().setVisible(false);
        this.InvView.getInventoryPanel().setVisible(true);
        InvModel.updateObs();
    }

    private void HandleBackButton() {
        this.InvView.getClientMenuPanel().setVisible(true);
        this.InvView.getInventoryPanel().setVisible(false);
        this.InvView.getCreateOrderPanel().setVisible(false);
        this.InvView.getViewOrdersPanel().setVisible(false);
        InvModel.updateObs();
    }

    private void HandleLogoutButton() {
        this.InvView.getClientMenuPanel().setVisible(false);
        this.InvView.getLoginPanel().setVisible(true);
        InvModel.updateObs();
    }

    private void HandleCreateOrder() {
        this.InvView.getClientMenuPanel().setVisible(false);
        this.InvView.getCreateOrderPanel().setVisible(true);
        InvModel.updateObs();
    }

    private void HandlePlaceOrder() {
        InvModel.updateObs();
    }

    private void HandleViewOrders() {
        this.InvView.getClientMenuPanel().setVisible(false);
        this.InvView.getViewOrdersPanel().setVisible(true);
        InvModel.updateObs();
    }

    private void HandleQuit() {
        System.exit(0);
    }
}
