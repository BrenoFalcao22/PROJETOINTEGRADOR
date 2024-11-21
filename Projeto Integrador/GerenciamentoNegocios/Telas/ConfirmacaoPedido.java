package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmacaoPedido extends JFrame {

    private Cliente cliente;
    private String pedido;

    // Construtor que recebe o cliente e o pedido
    public ConfirmacaoPedido(Cliente cliente, String pedido) {
        this.cliente = cliente;
        this.pedido = pedido;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Confirmação do Pedido");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Layout padrão
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel lblConfirmacao = new JLabel("Seu pedido foi confirmado!", SwingConstants.CENTER);
        lblConfirmacao.setFont(new Font("Segoe UI", Font.BOLD, 18));

        // Exibe as informações do cliente e do pedido
        JTextArea txtPedido = new JTextArea();
        txtPedido.setText("Cliente: " + cliente.getNome() + "\n" +
                          "Endereço: " + cliente.getEndereco() + "\n" +
                          "Telefone: " + cliente.getTelefone() + "\n\n" +
                          "Pedido: \n" + pedido);
        txtPedido.setEditable(false);
        txtPedido.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JButton btnFinalizar = new JButton("Finalizar");
        JButton btnVoltarMenu = new JButton("Voltar ao Menu");

        // Ações dos botões
        btnFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Finalizar aplicação
                JOptionPane.showMessageDialog(null, "Obrigado por usar o Açaí dos Manos!", "Finalizar", JOptionPane.INFORMATION_MESSAGE);
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

        // Configurando o layout horizontal
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(lblConfirmacao)
                .addComponent(txtPedido, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnFinalizar)
                .addComponent(btnVoltarMenu)
        );

        // Configurando o layout vertical
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(lblConfirmacao)
                .addComponent(txtPedido, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnFinalizar)
                .addComponent(btnVoltarMenu)
        );

        pack(); // Ajusta o tamanho da janela
    }
}
