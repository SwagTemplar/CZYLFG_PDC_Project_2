
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kisoo
 */
public class InvDatabaseConnect {

    public Connection conn = null;
    private static final String url = "jdbc:derby:InvSysDB_ebd;create=true";
    private static final String dbUserName = "inv";
    private static final String dbPassword = "inv";

    public InvDatabaseConnect() {
        dbConnect();
    }

    private void dbConnect() {
        try {
            conn = DriverManager.getConnection(url, dbUserName, dbPassword);
            System.out.println("Database Connected");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
