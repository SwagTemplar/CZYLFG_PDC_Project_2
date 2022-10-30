

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kisoon Park 18008173 & Connor Stewart
 */
public class InvDBManager {

    private InvDatabaseConnect invDBConnect;
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
            initialLogins();
        }
        if (!checkTableExist("INVENTORYSTOCK")) {
            databaseUpdate("CREATE TABLE INVENTORYSTOCK(FRUITID INT, FRUITNAME VARCHAR(40), FRUITQUANTITY INT)");
        }
        if (!checkTableExist("ORDERS")) {
            databaseUpdate("CREATE TABLE ORDERS(ORDERID INT, FRUITID INT, QUANTITYORDERED INT, USERID INT)");
        }

    }

    //The initial login details
    private void initialLogins() {
        databaseUpdate("INSERT INTO LOGINDETAILS VALUES(1, 'kisoon', 'leaf')");
        databaseUpdate("INSERT INTO LOGINDETAILS VALUES(2, 'connor', 'conzey')");
        databaseUpdate("INSERT INTO LOGINDETAILS VALUES(3, 'john', '123')");
        databaseUpdate("INSERT INTO LOGINDETAILS VALUES(4, 'bob', '123')");
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

    //Method that helps in creating the tables and populate them
    private void databaseUpdate(String statement) {
        try {
            Statement sql = conn.createStatement();
            sql.executeUpdate(statement);
        } catch (SQLException ex) {
            System.out.println("Database update failed");
        }
    }

    //Method that queries the database
    private ResultSet databaseQuery(String statement) {
        ResultSet queryResult = null;
        try {
            Statement sql = conn.createStatement();
            queryResult = sql.executeQuery(statement);
        } catch (SQLException ex) {
            System.out.println("Invalid SQL command");
        }
        return queryResult;
    }

    //Checks if the login details of the user exist.
    public User checkLogin(String username, String password) {
        User user = new User();

        try {
            ResultSet loginSearch = databaseQuery("SELECT * FROM LOGINDETAILS WHERE USERNAME = '" + username + "'");

            if (loginSearch != null) {
                while (loginSearch.next()) {
                    String pw = loginSearch.getString("PASSWORD");
                    int id = loginSearch.getInt("USERID");

                    //See if it is a client or an admin when logging in.
                    if (id == 1 || id == 2) {

                        user.isAdmin = true;
                    }

                    if (password.compareTo(pw) == 0) {
                        user.loginFlag = true;
                        user.userID = loginSearch.getInt("USERID");
                        System.out.println("Login = " + user.loginFlag);
                        System.out.println("User ID: " + loginSearch.getInt("USERID"));
                    } else {
                        System.out.println("User not found");
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println("Search error");
        }

        return user;
    }

    //Updates the orders table according to the inputted order
    public void updateOrderTable(Order order) {
        databaseUpdate("INSERT INTO ORDERS VALUES(" + order.getOrderID() + ", " + order.getfruitID() + ", "
                + order.getorderQuant() + ", " + order.getuserID() + ")");
    }

    //Get the orders of a particular user
    public OrderList retrieveOrders(int userID) {
        OrderList ol = new OrderList();

        try {
            ResultSet orderSearch = databaseQuery("SELECT * FROM ORDERS WHERE USERID = '" + userID + "'");
            if (orderSearch != null) {
                while (orderSearch.next()) {
                    int orderID = orderSearch.getInt("ORDERID");
                    int fruitID = orderSearch.getInt("FRUITID");
                    int quantity = orderSearch.getInt("QUANTITYORDERED");
                    Order od = new Order(orderID, fruitID, quantity, userID);
                    ol.add(od);
                }
            } else {
                System.out.println("No orders");
            }

        } catch (SQLException ex) {
            System.out.println("Searching Error");
        }

        return ol;
    }
}
