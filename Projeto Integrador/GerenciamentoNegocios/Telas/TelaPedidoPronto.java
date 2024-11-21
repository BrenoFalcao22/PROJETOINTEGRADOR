package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPedidoPronto extends JFrame {

    public TelaPedidoPronto() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pedido Pronto");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Componentes
        JLabel label = new JLabel("Seu pedido está pronto!", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));

        JButton btnFechar = new JButton("Fechar");
        JButton btnVoltarMenu = new JButton("Voltar ao Menu");

        // Ações dos botões
        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Finalizar aplicação
                JOptionPane.showMessageDialog(null, "Obrigado por usar o Açaí dos Manos!", "Fechar", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });

        btnVoltarMenu.addActionListener(new ActionListener() {
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
                .addComponent(btnFechar)
                .addComponent(btnVoltarMenu)
        );

        // Configurando o layout vertical
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(label)
                .addComponent(btnFechar)
                .addComponent(btnVoltarMenu)
        );

        pack(); // Ajusta o tamanho da janela
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new TelaPedidoPronto().setVisible(true));
    }
}