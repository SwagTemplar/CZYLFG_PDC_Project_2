
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

    private void createTables() {
        if (!checkTableExist("LOGINDETAILS")) {
            databaseUpdate("CREATE TABLE LOGINDETAILS(USERID INT, USERNAME VARCHAR(30), PASSWORD VARCHAR(30))");
        }
        if (!checkTableExist("INVENTORYSTOCK")) {
            databaseUpdate("CREATE TABLE INVENTORYSTOCK(FRUITID INT, FRUITNAME VARCHAR(40), FRUITQUANTITY INT)");
        }
        if (!checkTableExist("ORDERS")) {
            databaseUpdate("CREATE TABLE ORDERS(ORDERID INT, FRUITID INT, QUANTITYORDERED INT, USERID INT)");
        }
    }

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

    private void databaseUpdate(String statement) {
        try {
            sql = conn.createStatement();
            sql.addBatch(statement);
            sql.executeBatch();

        } catch (SQLException ex) {
            System.out.println("Database update failed");
        }
    }

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
}
