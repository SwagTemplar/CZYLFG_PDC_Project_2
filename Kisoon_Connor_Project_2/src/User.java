

/**
 *
 * @author Kisoon Park 18008173 & Connor Stewart 17982915
 */
public class User {
    
    //Checks login
    boolean loginFlag = false;
    //Checks user Authority
    boolean isAdmin = false;
    //User ID
    int userID;
    
    public void setLoginFlag(boolean bool)
    {
        this.loginFlag = bool;
    }
    
    public void setUserId(int id){
        this.userID = id;
    }
    
    public void userLogout()
    {
        this.loginFlag = false;
    }
}
