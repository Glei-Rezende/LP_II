package repository;

import database.ConnectionFactory;
import model.Carro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroRepository {

    // =========================
    // CREATE
    // =========================
    public Carro salvar(Carro carro) {

        String sql = "INSERT INTO carro(modelo, cor, ano) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, carro.getModelo());
            stmt.setString(2, carro.getCor());
            stmt.setInt(3, carro.getAno());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                carro.setId(rs.getLong(1));
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar carro", e);
        }

        return carro;
    }

    // =========================
    // READ ALL
    // =========================
    public List<Carro> listar() {

        String sql = "SELECT * FROM carro";

        List<Carro> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Carro c = new Carro();

                c.setId(rs.getLong("id"));
                c.setModelo(rs.getString("modelo"));
                c.setCor(rs.getString("cor"));
                c.setAno(rs.getInt("ano"));

                lista.add(c);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar carros", e);
        }

        return lista;
    }

    // =========================
    // READ BY ID
    // =========================
    public Carro buscarPorId(Long id) {

        String sql = "SELECT * FROM carro WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Carro c = new Carro();

                c.setId(rs.getLong("id"));
                c.setModelo(rs.getString("modelo"));
                c.setCor(rs.getString("cor"));
                c.setAno(rs.getInt("ano"));

                return c;
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar carro", e);
        }

        return null;
    }

    // =========================
    // UPDATE
    // =========================
    public Carro atualizar(Long id, Carro carro) {

        String sql = "UPDATE carro SET modelo = ?, cor = ?, ano = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carro.getModelo());
            stmt.setString(2, carro.getCor());
            stmt.setInt(3, carro.getAno());
            stmt.setLong(4, id);

            stmt.executeUpdate();

            carro.setId(id);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar carro", e);
        }

        return carro;
    }

    // =========================
    // DELETE
    // =========================
    public void deletar(Long id) {

        String sql = "DELETE FROM carro WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar carro", e);
        }
    }
}