package connor_kisoon_project_2;


import java.util.Observable;

/*
 * @author Connor Stewart 17982915
 */
public class InvModel extends Observable{

    private InvDBManager db;
    private User user;

    public InvModel(){
        db = new InvDBManager();
    }
    
    
    public void validateUser(String username, String password) {
        
        user = db.checkLogin(username, password);
        this.setChanged();
        this.notifyObservers(this.user);
    }

}
