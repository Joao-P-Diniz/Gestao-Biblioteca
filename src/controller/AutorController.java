package controller;

import dao.AutorDAO;
import dao.AutorDAOImpl;
import model.Autor;

import java.util.List;

public class AutorController {

    private AutorDAO dao = new AutorDAOImpl();

    public void cadastrar(String nome) {
        if (nome == null || nome.isBlank())
            throw new RuntimeException("Nome obrigatório");

        dao.save(new Autor(nome));
    }

    public List<Autor> listar() {
        return dao.findAll();
    }

    public void atualizar(int id, String nome) {
        dao.update(new Autor(id, nome));
    }

    public void excluir(int id) {
        dao.delete(id);
    }
    public Autor buscarPorId(int id) {
    return dao.findAll()
              .stream()
              .filter(a -> a.getId() == id)
              .findFirst()
              .orElse(null);
}

}
