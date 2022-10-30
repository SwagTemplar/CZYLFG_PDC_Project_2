
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @author Kisoon Park 18008173 & Connor Stewart 17982915
 */
public class InvController implements ActionListener {

    public InvView InvView;
    public InvModel InvModel;

    public InvController(InvView InvView, InvModel InvModel) {
        this.InvView = InvView;
        this.InvModel = InvModel;
        this.InvView.createControllers(this);

    }

    public void actionPerformed(ActionEvent e) {
        String check = e.getActionCommand();
        switch (check) {
            case "Login":
                String username = this.InvView.getLoginPanel().getUsernameInput();
                String password = this.InvView.getLoginPanel().getPasswordInput();
                this.InvModel.validateUser(username, password);
                if(InvModel.user.loginFlag == true && InvModel.user.isAdmin == false){
                    InvView.getClientMenuPanel().setVisible(true);
                    InvView.getLoginPanel().setVisible(false);
                }
                break;
            case "View current inventory":
                HandleViewCurrentInventoryButton();
                break;
            case "Back":
                HandleBackButton();
                break;
            case "Logout":
                HandleLogoutButton();
                break;
            case"Place order":
                HandlePlaceOrder();
                break;
            case "Create order":
                HandleCreateOrder();
                
        }
    }

    private void HandleViewCurrentInventoryButton() {
        this.InvView.getClientMenuPanel().setVisible(false);
        this.InvView.getInventoryPanel().setVisible(true);
        InvModel.updateObs();
    }

    private void HandleBackButton() {
        this.InvView.getClientMenuPanel().setVisible(true);
        this.InvView.getInventoryPanel().setVisible(false);
        this.InvView.getCreateOrderPanel().setVisible(false);
        InvModel.updateObs();
    }

    private void HandleLogoutButton() {
        this.InvView.getClientMenuPanel().setVisible(false);
        this.InvView.getLoginPanel().setVisible(true);
        InvModel.updateObs();
    }
    
    private void HandleCreateOrder(){
        this.InvView.getClientMenuPanel().setVisible(false);
        this.InvView.getCreateOrderPanel().setVisible(true);
        InvModel.updateObs();
    }
    
    private void HandlePlaceOrder(){
        InvModel.updateObs();
    }
}
