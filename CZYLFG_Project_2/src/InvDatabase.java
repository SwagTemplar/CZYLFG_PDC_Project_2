
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author kisoo
 */
public class InvDatabase {

    Connection conn = null;
    String url = "jdbc:derby:InvSysDB_ebd;create=true";
    String dbUserName = "inv";
    String dbPassword = "inv";

    public void dbConnect() {
        try {

            conn = DriverManager.getConnection(url, dbUserName, dbPassword);
        } catch (Throwable e) {
            System.out.println("error");
        }
    }
}
