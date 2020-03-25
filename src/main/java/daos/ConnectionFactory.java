

package daos;

//import com.mysql.jdbc.Driver;
        import com.mysql.cj.jdbc.Driver;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
/**
 * Connect to Database
 */
public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/myNewDB?serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASS = "phil2020";
    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
    /**
     * Test Connection
     */
    /*public static void main(String[] args) {
        DriverManager connectionFactory = null;
        Connection connection = connectionFactory.getConnection();
    }*/
}


