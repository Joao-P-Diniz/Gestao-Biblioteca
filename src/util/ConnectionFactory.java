package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection;

    private ConnectionFactory() {}

    public static Connection getConnection() {

        try {
            // FORÇA o carregamento do driver SQLite
            Class.forName("org.sqlite.JDBC");

            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:sqlite:biblioteca.db");
            }

            return connection;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver SQLite não encontrado.", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco.", e);
        }
    }
}
