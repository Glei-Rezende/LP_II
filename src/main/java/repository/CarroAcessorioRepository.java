package repository;

import database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarroAcessorioRepository {

    // =========================
    // CREATE
    // =========================
    public void associar(Long carroId, Long acessorioId) {

        String sql =
                "INSERT INTO carro_acessorio " +
                        "(carro_id, acessorio_id) " +
                        "VALUES (?, ?)";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setLong(1, carroId);
            stmt.setLong(2, acessorioId);

            stmt.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao associar acessório ao carro",
                    e
            );
        }
    }

    // =========================
    // READ
    // =========================
    public List<Long> buscarAcessoriosPorCarro(Long carroId) {

        String sql =
                "SELECT acessorio_id " +
                        "FROM carro_acessorio " +
                        "WHERE carro_id = ?";

        List<Long> acessorios = new ArrayList<>();

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setLong(1, carroId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                acessorios.add(
                        rs.getLong("acessorio_id")
                );
            }

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao buscar acessórios do carro",
                    e
            );
        }

        return acessorios;
    }

    // =========================
    // DELETE
    // =========================
    public void removerAssociacao(
            Long carroId,
            Long acessorioId
    ) {

        String sql =
                "DELETE FROM carro_acessorio " +
                        "WHERE carro_id = ? " +
                        "AND acessorio_id = ?";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setLong(1, carroId);
            stmt.setLong(2, acessorioId);

            stmt.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao remover associação",
                    e
            );
        }
    }
}