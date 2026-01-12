package dao;

import model.Livro;
import util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImpl implements LivroDAO {

    @Override
    public void save(Livro livro) {
        String sql = "INSERT INTO livro (titulo, ano, autor_id) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, livro.getTitulo());
            ps.setInt(2, livro.getAno());
            ps.setInt(3, livro.getAutorId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar livro", e);
        }
    }

    @Override
    public List<Livro> findAll() {
        List<Livro> livros = new ArrayList<>();

        String sql = """
            SELECT l.id, l.titulo, l.ano, l.autor_id, a.nome AS autor
            FROM livro l
            JOIN autor a ON a.id = l.autor_id
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                livros.add(new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getInt("ano"),
                        rs.getInt("autor_id"),
                        rs.getString("autor")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar livros", e);
        }
        return livros;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM livro WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir livro", e);
        }
    }
    @Override
    public void update(Livro livro) {
        String sql = """
            UPDATE livro
            SET titulo = ?, ano = ?, autor_id = ?
            WHERE id = ?
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, livro.getTitulo());
            ps.setInt(2, livro.getAno());
            ps.setInt(3, livro.getAutorId());
            ps.setInt(4, livro.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar livro", e);
        }
    }

}
