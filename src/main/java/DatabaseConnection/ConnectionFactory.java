package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/schooldb";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static Connection dbConnection;

    private static ConnectionFactory singleInstance = new ConnectionFactory();

    public static ConnectionFactory getInstance() {
        return singleInstance;
    }

    private ConnectionFactory() {
        try {
            Class.forName(DRIVER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    Connection createConnection() {
        try {
            dbConnection =  DriverManager.getConnection(DBURL, USER, PASS);
            return dbConnection;
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getConnection() {
        return dbConnection;
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close() throws SQLException
    {
        dbConnection.close();
    }

    public static void close(Statement statement) {
        try {
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
