package repository;

import database.ConnectionFactory;
import model.Acessorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcessorioRepository {

    // =========================
    // CREATE
    // =========================
    public Acessorio salvar(Acessorio acessorio) {

        String sql =
                "INSERT INTO acessorio(nome) VALUES (?)";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(
                                sql,
                                Statement.RETURN_GENERATED_KEYS)
        ) {

            stmt.setString(1, acessorio.getNome());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                acessorio.setId(rs.getLong(1));
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Erro ao salvar acessório",
                    e
            );
        }

        return acessorio;
    }

    // =========================
    // READ ALL
    // =========================
    public List<Acessorio> listar() {

        String sql = "SELECT * FROM acessorio";

        List<Acessorio> lista = new ArrayList<>();

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                Acessorio a = new Acessorio();

                a.setId(rs.getLong("id"));
                a.setNome(rs.getString("nome"));

                lista.add(a);
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Erro ao listar acessórios",
                    e
            );
        }

        return lista;
    }

    // =========================
    // READ BY ID
    // =========================
    public Acessorio buscarPorId(Long id) {

        String sql =
                "SELECT * FROM acessorio WHERE id = ?";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Acessorio a = new Acessorio();

                a.setId(rs.getLong("id"));
                a.setNome(rs.getString("nome"));

                return a;
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Erro ao buscar acessório",
                    e
            );
        }

        return null;
    }
}