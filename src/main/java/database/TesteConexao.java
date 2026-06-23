import database.ConnectionFactory;

import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {

        System.out.println("Iniciando teste de conexão...");

        Connection conn = ConnectionFactory.getConnection();

        if (conn != null) {
            System.out.println("Conexão com SQLite realizada com sucesso!");
        } else {
            System.out.println("Falha na conexão.");
        }
    }
}