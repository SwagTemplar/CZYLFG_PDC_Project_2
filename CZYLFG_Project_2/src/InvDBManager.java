
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kisoo
 */
public class InvDBManager {

    private InvDatabaseConnect invDBConnect;
    private Statement sql;
    private Connection conn;

    public InvDBManager() {
        invDBConnect = new InvDatabaseConnect();
        conn = invDBConnect.conn;
        createTables();
    }

    //Create the tables in the embedded DB
    private void createTables() {
        if (!checkTableExist("LOGINDETAILS")) {
            databaseUpdate("CREATE TABLE LOGINDETAILS(USERID INT, USERNAME VARCHAR(30), PASSWORD VARCHAR(30))");
            databaseQuery("INSERT INTO LOGINDETAILS VALUES(1, kisoon, leaf)");
            databaseQuery("INSERT INTO LOGINDETAILS VALUES(2, kisoon, general)");
            databaseQuery("INSERT INTO LOGINDETAILS VALUES(3, connor, conzey)");
            databaseQuery("INSERT INTO LOGINDETAILS VALUES(4, connor, stewart)");
                
        }
        if (!checkTableExist("INVENTORYSTOCK")) {
            databaseUpdate("CREATE TABLE INVENTORYSTOCK(FRUITID INT, FRUITNAME VARCHAR(40), FRUITQUANTITY INT)");
        }
        if (!checkTableExist("ORDERS")) {
            databaseUpdate("CREATE TABLE ORDERS(ORDERID INT, FRUITID INT, QUANTITYORDERED INT, USERID INT)");
        }
    }

    //Check if the tables exist
    private boolean checkTableExist(String name) {
        boolean exists = false;

        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, name, null);
            if (rsDBMeta != null && rsDBMeta.next()) {

                exists = true;

                rsDBMeta.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error checking for table");
        }

        return exists;
    }

    //Method that helps in creating the tables
    private void databaseUpdate(String statement) {
        try {
            sql = conn.createStatement();
            sql.addBatch(statement);
            sql.executeBatch();

        } catch (SQLException ex) {
            System.out.println("Database update failed");
        }
    }

    //Method that queries the database
    private ResultSet databaseQuery(String statement) {
        ResultSet queryResult = null;
        try {
            sql = conn.createStatement();
            queryResult = sql.executeQuery(statement);
        } catch (SQLException ex) {
            System.out.println("Invalid SQL command");
        }
        return queryResult;
    }
    
    //Checks if the login details of the user exist.
    public User checkLogin(String username, String password)
    {
        User user = new User();
        
        try{
            ResultSet loginSearch = databaseQuery("SELECT USERNAME, PASSWORD FROM LOGINDETAILS WHERE USERNAME = '"+ username +"'");
            
            if(loginSearch.next())
            {
                String pw = loginSearch.getString("PASSWORD");
                
                if(password.compareTo(pw) == 0)
                {
                    user.loginFlag = true;
                    user.userID = loginSearch.getInt("USERID");
                }
            }
        }catch(SQLException ex)
        {
            System.out.println("No such user exists");
        }
        
        return user;
    }
}
