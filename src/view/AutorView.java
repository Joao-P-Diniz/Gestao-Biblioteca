package view;

import controller.AutorController;

import javax.swing.*;

public class AutorView extends JFrame {

    public AutorView() {

        setTitle("Cadastro de Autor");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextField txtNome = new JTextField(20);

        JButton btnSalvar = new JButton("Cadastrar");
        JButton btnListar = new JButton("Listar Autores");
        JButton btnFechar = new JButton("Fechar");

        btnSalvar.addActionListener(e -> {
            try {
                new AutorController().cadastrar(txtNome.getText());
                JOptionPane.showMessageDialog(this, "Autor cadastrado!");
                txtNome.setText("");
                txtNome.requestFocus();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnListar.addActionListener(e -> new AutorListView());
        btnFechar.addActionListener(e -> dispose());

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nome do Autor:"));
        panel.add(txtNome);
        panel.add(btnSalvar);
        panel.add(btnListar);
        panel.add(btnFechar);

        add(panel);
        setVisible(true);
    }
}
