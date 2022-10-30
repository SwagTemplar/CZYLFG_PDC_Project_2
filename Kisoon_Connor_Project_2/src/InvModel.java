


import java.util.Observable;

/*
 * @author Kisoon Park 18008173 & Connor Stewart 17982915
 */
public class InvModel extends Observable{
    // Creation of Variables
    private InvDBManager db;
    public User user;
    private ClientUser cUser;
    private AdminUser adUser;
    // Constructor
    public InvModel(){
        db = new InvDBManager();
    }
    
    /**
     * @return the ClientUser
     */
    public ClientUser getClient()
    {
        return this.cUser;
    }
    /**
     * @return the AdminUser
     */
    public AdminUser getAdmin()    
    {
        return this.adUser;
    }
    
    // Checks username and password to database
    public void validateUser(String username, String password) {
        
        user = db.checkLogin(username, password);
        if(user.isAdmin)
            {
                adUser = new AdminUser();
                adUser.loginFlag = user.loginFlag;
                adUser.userID = user.userID; 
                adUser.isAdmin = user.isAdmin;
            }else{
                cUser = new ClientUser();
                cUser.loginFlag = user.loginFlag;
                cUser.userID = user.userID;    
            }
    }
    // retrieves client orders from database
    public OrderList clientOrders()
    {
        return db.retrieveOrders(cUser.userID);
    }
    // updates the observer when called
    public void updateObs(){        
        this.setChanged();
        this.notifyObservers(this);
    }

}
