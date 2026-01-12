package util;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            String autorTable = """
                CREATE TABLE IF NOT EXISTS autor (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL
                );
            """;

            String livroTable = """
                CREATE TABLE IF NOT EXISTS livro (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    titulo TEXT NOT NULL,
                    ano INTEGER NOT NULL,
                    autor_id INTEGER NOT NULL,
                    FOREIGN KEY (autor_id) REFERENCES autor(id)
                );
            """;

            stmt.execute(autorTable);
            stmt.execute(livroTable);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar tabelas", e);
        }
    }
}
