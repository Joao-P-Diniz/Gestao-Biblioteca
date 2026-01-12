package dao;

import model.Autor;
import java.util.List;

public interface AutorDAO {
    void save(Autor autor);
    List<Autor> findAll();
    void update(Autor autor);
    void delete(int id);
}
