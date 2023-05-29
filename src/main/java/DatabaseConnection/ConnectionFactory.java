package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clasa ConnectionFactory este o clasă singleton responsabilă de crearea și gestionarea conexiunii la baza de date.
 * Atributele private DRIVER, DBURL, USER și PASS reprezintă informațiile necesare pentru stabilirea conexiunii cu baza de date MySQL. Acestea sunt valorile specifice pentru configurarea conexiunii la baza de date locală MySQL cu numele de bază "schooldb", utilizatorul "root" și parola "root". Aceste valori pot fi modificate în funcție de configurația specifică a bazei de date.
 * Atributul static dbConnection este utilizat pentru a reține conexiunea activă la baza de date și este accesibil prin intermediul metodei statice getConnection().
 * Constructorul clasei este privat și este apelat o singură dată la inițializarea clasei pentru a încărca driverul MySQL prin apelul metodei Class.forName(DRIVER). Acest pas este necesar pentru a asigura încărcarea corectă a driverului înainte de crearea conexiunii.
 * Metoda createConnection() este responsabilă pentru crearea conexiunii la baza de date utilizând informațiile de configurare. Aceasta returnează obiectul Connection pentru utilizare ulterioară.
 */
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
