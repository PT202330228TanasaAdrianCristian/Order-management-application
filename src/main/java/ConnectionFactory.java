import com.mysql.cj.xdevapi.Statement;

import java.sql.Connection;
import java.sql.ResultSet;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/schooldb";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static ConnectionFactory singleInstance = new ConnectionFactory();

    private ConnectionFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection()
    {
    }
    public static Connection getConnection()
    {
    }
    public static void close(Connection connection)
    {

    }
    public static void close(Statement statement)
    {

    }
    public static void close(ResultSet resultSet)
    {

    }
}

