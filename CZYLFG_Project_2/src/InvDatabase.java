
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author kisoo
 */
public class InvDatabase {

    private Connection conn = null;
    private static final String url = "jdbc:derby:InvSysDB_ebd;create=true";
    private static final String dbUserName = "inv";
    private static final String dbPassword = "inv";

    public InvDatabase()
    {
        dbConnect();
    }
    
    
    private void dbConnect() {
        try {
            conn = DriverManager.getConnection(url, dbUserName, dbPassword);
            System.out.println("Database Connected");
        } catch (Throwable e) {
            System.out.println("error");
        }
    }
}
