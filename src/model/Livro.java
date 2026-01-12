package model;

public class Livro {

    private int id;
    private String titulo;
    private int ano;
    private int autorId;
    private String autor; // nome do autor (JOIN)

    // Construtor vazio
    public Livro() {}

    // Construtor para cadastro
    public Livro(String titulo, int ano, int autorId) {
        this.titulo = titulo;
        this.ano = ano;
        this.autorId = autorId;
    }

    // Construtor para listagem (JOIN)
    public Livro(int id, String titulo, int ano, int autorId, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.autorId = autorId;
        this.autor = autor;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public int getAutorId() {
        return autorId;
    }

    public String getAutor() {
        return autor;
    }
}
