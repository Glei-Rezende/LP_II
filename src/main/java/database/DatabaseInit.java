package database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInit {

    public static void criarTabela() {

        String sqlFabricante =
                "CREATE TABLE IF NOT EXISTS fabricante (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nome TEXT NOT NULL, " +
                        "pais_origem TEXT" +
                        ");";

        String sqlAcessorio =
                "CREATE TABLE IF NOT EXISTS acessorio (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nome TEXT NOT NULL" +
                        ");";

        String sqlCarro =
                "CREATE TABLE IF NOT EXISTS carro (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "modelo TEXT NOT NULL, " +
                        "cor TEXT, " +
                        "ano INTEGER, " +
                        "fabricante_id INTEGER, " +
                        "FOREIGN KEY (fabricante_id) REFERENCES fabricante(id)" +
                        ");";

        String sqlCarroAcessorio =
                "CREATE TABLE IF NOT EXISTS carro_acessorio (" +
                        "carro_id INTEGER NOT NULL, " +
                        "acessorio_id INTEGER NOT NULL, " +
                        "PRIMARY KEY (carro_id, acessorio_id), " +
                        "FOREIGN KEY (carro_id) REFERENCES carro(id), " +
                        "FOREIGN KEY (acessorio_id) REFERENCES acessorio(id)" +
                        ");";

        try (
                Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement()
        ) {

            stmt.execute(sqlFabricante);
            stmt.execute(sqlAcessorio);
            stmt.execute(sqlCarro);
            stmt.execute(sqlCarroAcessorio);

            System.out.println("Tabelas criadas com sucesso!");

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao criar tabelas do banco.",
                    e
            );

        }
    }
}