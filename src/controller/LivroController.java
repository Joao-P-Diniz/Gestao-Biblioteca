package controller;

import dao.LivroDAO;
import dao.LivroDAOImpl;
import model.Livro;

import java.util.List;

public class LivroController {

    private LivroDAO dao = new LivroDAOImpl();

    public void cadastrar(String titulo, String anoStr, int autorId) {

        if (titulo == null || titulo.trim().isEmpty()) {
            throw new RuntimeException("Título é obrigatório");
        }

        if (anoStr == null || anoStr.trim().isEmpty()) {
            throw new RuntimeException("Ano é obrigatório");
        }

        int ano;
        try {
            ano = Integer.parseInt(anoStr);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Ano deve ser um número");
        }

        int anoAtual = java.time.Year.now().getValue();
        if (ano < 1500 || ano > anoAtual) {
            throw new RuntimeException("Ano inválido");
        }

        dao.save(new Livro(titulo, ano, autorId));
    }


    public List<Livro> listar() {
        return dao.findAll();
    }

    public void excluir(int id) {
        dao.delete(id);
    }
    public void atualizar(int id, String titulo, String anoStr, int autorId) {

        if (titulo == null || titulo.trim().isEmpty()) {
            throw new RuntimeException("Título é obrigatório");
        }

        if (anoStr == null || anoStr.trim().isEmpty()) {
            throw new RuntimeException("Ano é obrigatório");
        }

        int ano;
        try {
            ano = Integer.parseInt(anoStr);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Ano deve ser um número");
        }

        int anoAtual = java.time.Year.now().getValue();
        if (ano < 1500 || ano > anoAtual) {
            throw new RuntimeException("Ano inválido");
        }

        dao.update(new Livro(id, titulo, ano, autorId, anoStr));
    }


}
