import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:gcash.db";

    public static Connection connect () {
        try {
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Connected successfully.");
            return conn;
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
            return null;
        }
    }

}
