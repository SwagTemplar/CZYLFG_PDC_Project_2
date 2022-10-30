


import java.util.Observable;

/*
 * @author Connor Stewart 17982915
 */
public class InvModel extends Observable{

    private InvDBManager db;
    public User user;
    private ClientUser cUser;
    private AdminUser adUser;

    public InvModel(){
        db = new InvDBManager();
    }
    
    public ClientUser getClient()
    {
        return this.cUser;
    }
    
    public AdminUser getAdmin()    
    {
        return this.adUser;
    }
    
    
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
    
    public OrderList clientOrders()
    {
        return db.retrieveOrders(cUser.userID);
    }
    
    public void updateObs(){        
        this.setChanged();
        this.notifyObservers(this);
    }

}
