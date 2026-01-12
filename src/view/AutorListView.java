package view;

import controller.AutorController;
import model.Autor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AutorListView extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private AutorController controller = new AutorController();

    public AutorListView() {
        setTitle("Autores Cadastrados");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        model = new DefaultTableModel(new Object[]{"ID", "Nome"}, 0);
        table = new JTable(model);

        carregarAutores();

        JButton btnExcluir = new JButton("Excluir");
        JButton btnEditar = new JButton("Editar");

        btnExcluir.addActionListener(e -> excluirAutor());
        btnEditar.addActionListener(e -> editarAutor());

        JPanel panelButtons = new JPanel();
        panelButtons.add(btnEditar);
        panelButtons.add(btnExcluir);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void carregarAutores() {
        model.setRowCount(0);
        List<Autor> autores = controller.listar();

        for (Autor a : autores) {
            model.addRow(new Object[]{a.getId(), a.getNome()});
        }
    }

    private void excluirAutor() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um autor.");
            return;
        }

        int id = (int) model.getValueAt(row, 0);
        controller.excluir(id);
        carregarAutores();
    }

    private void editarAutor() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um autor.");
            return;
        }

        int id = (int) model.getValueAt(row, 0);
        String nomeAtual = (String) model.getValueAt(row, 1);

        String novoNome = JOptionPane.showInputDialog(this, "Novo nome:", nomeAtual);

        if (novoNome != null && !novoNome.isBlank()) {
            controller.atualizar(id, novoNome);
            carregarAutores();
        }
    }
}
