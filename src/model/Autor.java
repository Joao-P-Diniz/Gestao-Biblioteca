package model;

import util.BusinessException;

public class Autor extends AbstractEntity {

    private String nome;

    public Autor(int id, String nome) {
        this.id = id;
        setNome(nome);
    }

    public Autor(String nome) {
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new BusinessException("Nome do autor é obrigatório.");
        }
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
