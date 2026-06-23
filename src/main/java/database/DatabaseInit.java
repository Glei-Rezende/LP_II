package database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInit {

    public static void criarTabela() {

        String sql = "CREATE TABLE IF NOT EXISTS carro (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "modelo TEXT, " +
                "cor TEXT, " +
                "ano INTEGER" +
                ");";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}