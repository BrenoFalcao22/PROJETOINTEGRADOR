package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVerPedidos extends JFrame {

    private JPanel panelCampos;

    public TelaVerPedidos() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pedidos de Açaí");
        setSize(600, 500); // Ajuste do tamanho da janela
        setLocationRelativeTo(null);

        // Título
        JLabel labelTitulo = new JLabel("Pedidos de Açaí", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28)); // Tamanho maior para o título

        // Painel para exibir os campos dos pedidos
        panelCampos = new JPanel();
        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.Y_AXIS));
        panelCampos.setBorder(BorderFactory.createTitledBorder("Detalhes dos Pedidos"));

        // Inicializa os pedidos na interface
        carregarPedidos();

        JScrollPane scrollPane = new JScrollPane(panelCampos);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Painel para botões
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new BoxLayout(panelBotoes, BoxLayout.Y_AXIS));

        // Botões de ação
        JButton btnAdicionarPedido = new JButton("Adicionar Pedido");
        JButton btnVoltar = new JButton("Voltar ao Menu");
        JButton btnExcluirPedido = new JButton("Excluir Pedido");

        // Ajuste de estilo dos botões
        Dimension buttonSize = new Dimension(200, 40);
        Font buttonFont = new Font("Segoe UI", Font.PLAIN, 16);
        btnAdicionarPedido.setFont(buttonFont);
        btnVoltar.setFont(buttonFont);
        btnExcluirPedido.setFont(buttonFont);

        // Adicionar botões ao painel
        panelBotoes.add(Box.createVerticalStrut(10)); // Espaçamento
        panelBotoes.add(btnAdicionarPedido);
        panelBotoes.add(Box.createVerticalStrut(10)); // Espaçamento
        panelBotoes.add(btnVoltar);
        panelBotoes.add(Box.createVerticalStrut(10)); // Espaçamento
        panelBotoes.add(btnExcluirPedido);

        // Layout principal
        setLayout(new BorderLayout());
        add(labelTitulo, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.EAST);

        // Ação dos botões
        btnAdicionarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaIncluirPedido().setVisible(true);
                dispose();
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaInicial().setVisible(true);
                dispose();
            }
        });

        btnExcluirPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirPedido();
            }
        });
    }

    private void carregarPedidos() {
        panelCampos.removeAll(); // Remove todos os componentes antigos
        for (Pedido pedido : TelaIncluirPedido.listaPedidos) {
            panelCampos.add(criarPainelPedido(pedido));
        }
        panelCampos.revalidate();
        panelCampos.repaint();
    }

    private void excluirPedido() {
        String nomePedido = JOptionPane.showInputDialog(this, "Informe o nome do pedido a ser excluído:");
        if (nomePedido != null && !nomePedido.trim().isEmpty()) {
            Pedido pedidoARemover = null;

            for (Pedido pedido : TelaIncluirPedido.listaPedidos) {
                if (pedido.getNome().equalsIgnoreCase(nomePedido.trim())) {
                    pedidoARemover = pedido;
                    break;
                }
            }

            if (pedidoARemover != null) {
                TelaIncluirPedido.listaPedidos.remove(pedidoARemover);
                JOptionPane.showMessageDialog(this, "Pedido removido com sucesso!");
                carregarPedidos();
            } else {
                JOptionPane.showMessageDialog(this, "Pedido não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nome inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JPanel criarPainelPedido(Pedido pedido) {
        JPanel panelPedido = new JPanel();
        panelPedido.setLayout(new BoxLayout(panelPedido, BoxLayout.Y_AXIS));
        panelPedido.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createLineBorder(Color.GRAY)
        ));

        Font fontCampo = new Font("Segoe UI", Font.PLAIN, 16);
        Font fontTituloCampo = new Font("Segoe UI", Font.BOLD, 16);

        JLabel labelNome = new JLabel("Nome: " + pedido.getNome());
        labelNome.setFont(fontCampo);
        JLabel labelTamanho = new JLabel("Tamanho: " + pedido.getTamanho());
        labelTamanho.setFont(fontCampo);

        JLabel labelCoberturaTitulo = new JLabel("Coberturas:");
        labelCoberturaTitulo.setFont(fontTituloCampo);
        JLabel labelCobertura = new JLabel(pedido.getCobertura());
        labelCobertura.setFont(fontCampo);

        JLabel labelComplementosTitulo = new JLabel("Complementos:");
        labelComplementosTitulo.setFont(fontTituloCampo);
        JLabel labelComplementos = new JLabel(pedido.getComplementos());
        labelComplementos.setFont(fontCampo);

        JLabel labelFrutasTitulo = new JLabel("Frutas:");
        labelFrutasTitulo.setFont(fontTituloCampo);
        JLabel labelFrutas = new JLabel(pedido.getFrutas());
        labelFrutas.setFont(fontCampo);

        panelPedido.add(labelNome);
        panelPedido.add(labelTamanho);
        panelPedido.add(labelCoberturaTitulo);
        panelPedido.add(labelCobertura);
        panelPedido.add(labelComplementosTitulo);
        panelPedido.add(labelComplementos);
        panelPedido.add(labelFrutasTitulo);
        panelPedido.add(labelFrutas);

        return panelPedido;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaVerPedidos().setVisible(true));
    }
}
