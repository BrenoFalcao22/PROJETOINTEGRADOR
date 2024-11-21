package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscolhaPedido extends JFrame {

    public EscolhaPedido() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Escolha de Pedido");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Componentes
        JLabel label = new JLabel("Escolha um Pedido", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));

        JButton btnPedido1 = new JButton("Pedido 1");
        JButton btnPedido2 = new JButton("Pedido 2");
        JButton btnVoltar = new JButton("Voltar");

        // Ações dos botões
        btnPedido1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para Pedido 1
                JOptionPane.showMessageDialog(null, "Pedido 1 selecionado!", "Pedido 1", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnPedido2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para Pedido 2
                JOptionPane.showMessageDialog(null, "Pedido 2 selecionado!", "Pedido 2", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Voltar para a tela inicial
                TelaInicial telaInicial = new TelaInicial();
                telaInicial.setVisible(true);
                dispose(); // Fecha a tela atual
            }
        });

        // Layout usando GroupLayout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Configurando o layout horizontal
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(label)
                .addComponent(btnPedido1)
                .addComponent(btnPedido2)
                .addComponent(btnVoltar)
        );

        // Configurando o layout vertical
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(label)
                .addComponent(btnPedido1)
                .addComponent(btnPedido2)
                .addComponent(btnVoltar)
        );

        pack(); // Ajusta o tamanho da janela
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new EscolhaPedido().setVisible(true));
    }
}