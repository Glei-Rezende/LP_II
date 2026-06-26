package repository;

import database.ConnectionFactory;
import model.Fabricante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FabricanteRepository {

    public Fabricante salvar(Fabricante fabricante) {

        String sql =
                "INSERT INTO fabricante(nome, pais_origem) VALUES (?, ?)";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(
                                sql,
                                Statement.RETURN_GENERATED_KEYS)
        ) {

            stmt.setString(1, fabricante.getNome());
            stmt.setString(2, fabricante.getPaisOrigem());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                fabricante.setId(rs.getLong(1));
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Erro ao salvar fabricante",
                    e
            );
        }

        return fabricante;
    }

    public List<Fabricante> listar() {

        String sql = "SELECT * FROM fabricante";

        List<Fabricante> lista = new ArrayList<>();

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                Fabricante f = new Fabricante();

                f.setId(rs.getLong("id"));
                f.setNome(rs.getString("nome"));
                f.setPaisOrigem(
                        rs.getString("pais_origem")
                );

                lista.add(f);
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Erro ao listar fabricantes",
                    e
            );
        }

        return lista;
    }

    public Fabricante buscarPorId(Long id) {

        String sql =
                "SELECT * FROM fabricante WHERE id = ?";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Fabricante f = new Fabricante();

                f.setId(rs.getLong("id"));
                f.setNome(rs.getString("nome"));
                f.setPaisOrigem(
                        rs.getString("pais_origem")
                );

                return f;
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Erro ao buscar fabricante",
                    e
            );
        }

        return null;
    }
}