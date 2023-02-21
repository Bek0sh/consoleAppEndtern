package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB implements IDB {

    @Override
    public Connection getConnection() {
        String connection = "jdbc:postgresql://localhost:5432/demo";
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(connection, "postgres", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
