package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "22092004";
    private static final String URL = "jdbc:postgresql://localhost:5432/Guild_DB";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
