package view;

import javax.swing.*;

public class BibliotecaView extends JFrame {

    public BibliotecaView() {

        setTitle("Sistema de Biblioteca");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton btnAutor = new JButton("Gerenciar Autores");
        JButton btnLivro = new JButton("Gerenciar Livros");
        JButton btnSair = new JButton("Sair");

        btnAutor.addActionListener(e -> new AutorView());
        btnLivro.addActionListener(e -> new LivroView());
        btnSair.addActionListener(e -> System.exit(0));

        JPanel panel = new JPanel();
        panel.add(btnAutor);
        panel.add(btnLivro);
        panel.add(btnSair);

        add(panel);
        setVisible(true);
    }
}
