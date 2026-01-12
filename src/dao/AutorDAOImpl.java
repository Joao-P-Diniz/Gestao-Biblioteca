package dao;

import model.Autor;
import util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAOImpl implements AutorDAO {

    @Override
    public void save(Autor autor) {
        String sql = "INSERT INTO autor (nome) VALUES (?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, autor.getNome());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar autor", e);
        }
    }

    @Override
    public List<Autor> findAll() {
        List<Autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM autor";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                autores.add(new Autor(
                        rs.getInt("id"),
                        rs.getString("nome")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar autores", e);
        }
        return autores;
    }

    @Override
    public void update(Autor autor) {
        String sql = "UPDATE autor SET nome = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, autor.getNome());
            ps.setInt(2, autor.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar autor", e);
        }
    }
    private boolean autorTemLivros(int autorId) {

        String sql = "SELECT COUNT(*) FROM livro WHERE autor_id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, autorId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar livros do autor", e);
        }

        return false;
    }

    @Override
    public void delete(int id) {

        if (autorTemLivros(id)) {
            throw new RuntimeException(
                "Não é possível excluir autor com livros cadastrados"
            );
        }

        String sql = "DELETE FROM autor WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir autor", e);
        }
    }

}
