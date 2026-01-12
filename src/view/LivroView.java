package view;

import controller.AutorController;
import controller.LivroController;
import model.Autor;
import model.Livro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class LivroView extends JFrame {

    private JButton btnSalvar;
    private JButton btnEditar;
    private JButton btnExcluir;

    private JComboBox<Autor> cbAutor;
    private JTextField txtTitulo;
    private JTextField txtAno;
    private JTable table;
    private DefaultTableModel model;

    private Integer livroIdSelecionado = null;

    private LivroController livroController = new LivroController();
    private AutorController autorController = new AutorController();

    public LivroView() {

        setTitle("Cadastro de Livros");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cbAutor = new JComboBox<>();
        carregarAutores();

        txtTitulo = new JTextField(15);
        txtAno = new JTextField(4);

        model = new DefaultTableModel(
                new Object[]{"ID", "Título", "Ano", "Autor"}, 0
        );
        table = new JTable(model);

        carregarLivros();

        // 🔹 Seleção da tabela (ESSENCIAL)
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {

                int row = table.getSelectedRow();

                livroIdSelecionado = (int) model.getValueAt(row, 0);
                txtTitulo.setText(model.getValueAt(row, 1).toString());
                txtAno.setText(model.getValueAt(row, 2).toString());

                String autorNome = model.getValueAt(row, 3).toString();
                for (int i = 0; i < cbAutor.getItemCount(); i++) {
                    if (cbAutor.getItemAt(i).getNome().equals(autorNome)) {
                        cbAutor.setSelectedIndex(i);
                        break;
                    }
                }

                // ✅ ATIVA BOTÕES
                btnEditar.setEnabled(true);
                btnExcluir.setEnabled(true);
            }
        });

        btnSalvar = new JButton("Salvar");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");

        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);

        btnSalvar.addActionListener(e -> salvarLivro());
        btnEditar.addActionListener(e -> editarLivro());
        btnExcluir.addActionListener(e -> excluirLivro());

        JPanel form = new JPanel();
        form.add(new JLabel("Título:"));
        form.add(txtTitulo);
        form.add(new JLabel("Ano:"));
        form.add(txtAno);
        form.add(new JLabel("Autor:"));
        form.add(cbAutor);

        JPanel botoes = new JPanel();
        botoes.add(btnSalvar);
        botoes.add(btnEditar);
        botoes.add(btnExcluir);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void carregarAutores() {
        cbAutor.removeAllItems();
        for (Autor a : autorController.listar()) {
            cbAutor.addItem(a);
        }
    }

    private void carregarLivros() {
        model.setRowCount(0);
        List<Livro> livros = livroController.listar();

        for (Livro l : livros) {
            model.addRow(new Object[]{
                    l.getId(),
                    l.getTitulo(),
                    l.getAno(),
                    l.getAutor()
            });
        }
    }

    private void salvarLivro() {
        Autor autor = (Autor) cbAutor.getSelectedItem();
        if (autor == null) {
            JOptionPane.showMessageDialog(this, "Selecione um autor");
            return;
        }

        try {
            livroController.cadastrar(
                    txtTitulo.getText(),
                    txtAno.getText(),
                    autor.getId()
            );
            carregarLivros();
            limparCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void editarLivro() {

        if (livroIdSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um livro para editar");
            return;
        }

        Autor autor = (Autor) cbAutor.getSelectedItem();
        if (autor == null) {
            JOptionPane.showMessageDialog(this, "Selecione um autor");
            return;
        }

        try {
            livroController.atualizar(
                    livroIdSelecionado,
                    txtTitulo.getText(),
                    txtAno.getText(),
                    autor.getId()
            );

            JOptionPane.showMessageDialog(this, "Livro atualizado com sucesso!");
            carregarLivros();
            limparCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void excluirLivro() {

        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um livro");
            return;
        }

        int opcao = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja excluir este livro?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (opcao != JOptionPane.YES_OPTION) return;

        int id = (int) model.getValueAt(row, 0);
        livroController.excluir(id);
        carregarLivros();
        limparCampos();
    }

    private void limparCampos() {
        txtTitulo.setText("");
        txtAno.setText("");
        cbAutor.setSelectedIndex(0);
        livroIdSelecionado = null;
        table.clearSelection();

        // 🔒 DESATIVA BOTÕES
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
    }
}
