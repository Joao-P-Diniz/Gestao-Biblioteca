package dao;

import model.Livro;
import java.util.List;

public interface LivroDAO {
    void save(Livro livro);
    List<Livro> findAll();
    void delete(int id);
    void update(Livro livro);
}
