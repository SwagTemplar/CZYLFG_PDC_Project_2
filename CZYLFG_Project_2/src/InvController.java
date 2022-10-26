
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @author Connor Stewart 17982915
 */
public class InvController implements ActionListener {

    public InvView InvView;
    public InvModel InvModel;

    public InvController(InvView InvView, InvModel InvModel) {
        this.InvView = InvView;
        this.InvModel = InvModel;
        this.InvView.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        String check = e.getActionCommand();
        switch (check) {
            case "Log in":
                String username = this.InvView.usernameInput.getText();
                String password = this.InvView.passwordInput.getText();
                this.InvModel.validateUser(username, password);
                break;
        }
    }
}
