package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaOpcoesAcai extends JFrame {
    
    private Cliente cliente;

    // Construtor para receber o objeto Cliente
    public TelaOpcoesAcai(Cliente cliente) {
        this.cliente = cliente; // Recebe o objeto Cliente
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Opções do Açaí");
        setSize(400, 500);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Título
        JLabel labelTitulo = new JLabel("Escolha o seu Açaí", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));

        // Tamanhos do açaí (Radio Buttons)
        JLabel labelTamanho = new JLabel("Tamanho:");
        JRadioButton rb300ml = new JRadioButton("300ml");
        JRadioButton rb500ml = new JRadioButton("500ml");
        JRadioButton rb700ml = new JRadioButton("700ml");

        ButtonGroup groupTamanhos = new ButtonGroup();
        groupTamanhos.add(rb300ml);
        groupTamanhos.add(rb500ml);
        groupTamanhos.add(rb700ml);

        // Coberturas tradicionais (Checkboxes)
        JLabel labelCoberturas = new JLabel("Coberturas Tradicionais:");
        JCheckBox cbMorangoc = new JCheckBox("Morango");
        JCheckBox cbChocolate = new JCheckBox("Chocolate");
        JCheckBox cbLeiteCondensado = new JCheckBox("Leite Condensado");
        JCheckBox cbMel = new JCheckBox("Mel");
        JCheckBox cbAmora = new JCheckBox("Amora");
        JCheckBox cbCaramelo = new JCheckBox("Caramelo");

        // Complementos (Checkboxes)
        JLabel labelComplementos = new JLabel("Complementos:");
        JCheckBox cbGranola = new JCheckBox("Granola");
        JCheckBox cbPaçoca = new JCheckBox("Paçoca");
        JCheckBox cbLeiteNinho = new JCheckBox("Leite Ninho");
        JCheckBox cbAmendoim = new JCheckBox("Amendoim");

        // Frutas (Checkboxes)
        JLabel labelFrutas = new JLabel("Frutas:");
        JCheckBox cbBanana = new JCheckBox("Banana");
        JCheckBox cbMorangof = new JCheckBox("Morango");
        JCheckBox cbManga = new JCheckBox("Manga");
        JCheckBox cbKiwi = new JCheckBox("Kiwi");

        // Botão de Confirmar Pedido
        JButton btnConfirmar = new JButton("Confirmar Pedido");
        JButton btnVoltar = new JButton("Voltar ao Menu");

        // Ação do botão Confirmar
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder pedido = new StringBuilder("Pedido de Açaí: \n");

                // Tamanho escolhido
                if (rb300ml.isSelected()) {
                    pedido.append("Tamanho: 300ml\n");
                } else if (rb500ml.isSelected()) {
                    pedido.append("Tamanho: 500ml\n");
                } else if (rb700ml.isSelected()) {
                    pedido.append("Tamanho: 700ml\n");
                }

                // Coberturas escolhidas
                pedido.append("Coberturas: ");
                if (cbMorangoc.isSelected()) pedido.append("Morango ");
                if (cbChocolate.isSelected()) pedido.append("Chocolate ");
                if (cbLeiteCondensado.isSelected()) pedido.append("Leite Condensado ");
                if (cbMel.isSelected()) pedido.append("Mel ");
                if (cbAmora.isSelected()) pedido.append("Amora ");
                if (cbCaramelo.isSelected()) pedido.append("Caramelo ");
                pedido.append("\n");

                // Complementos escolhidos
                pedido.append("Complementos: ");
                if (cbGranola.isSelected()) pedido.append("Granola ");
                if (cbPaçoca.isSelected()) pedido.append("Paçoca ");
                if (cbLeiteNinho.isSelected()) pedido.append("Leite Ninho ");
                if (cbAmendoim.isSelected()) pedido.append("Amendoim ");
                pedido.append("\n");

                // Frutas escolhidas
                pedido.append("Frutas: ");
                if (cbBanana.isSelected()) pedido.append("Banana ");
                if (cbMorangof.isSelected()) pedido.append("Morango ");
                if (cbManga.isSelected()) pedido.append("Manga ");
                if (cbKiwi.isSelected()) pedido.append("Kiwi ");
                pedido.append("\n");

                // Exibir o pedido
                JOptionPane.showMessageDialog(null, pedido.toString(), "Pedido Confirmado", JOptionPane.INFORMATION_MESSAGE);

                // Passar o cliente para a tela de confirmação
                ConfirmacaoPedido confirmacao = new ConfirmacaoPedido(cliente, pedido.toString());
                confirmacao.setVisible(true);
                dispose(); // Fecha a tela atual
            }
        });

        // Ação do botão Voltar
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Voltar para a tela inicial
                TelaInicial telaInicial = new TelaInicial();
                telaInicial.setVisible(true);
                dispose(); // Fecha a tela atual
            }
        });

        // Painel para tamanhos
        JPanel panelTamanho = new JPanel(new GridLayout(1, 3));
        panelTamanho.add(rb300ml);
        panelTamanho.add(rb500ml);
        panelTamanho.add(rb700ml);

        // Painel para coberturas
        JPanel panelCoberturas = new JPanel(new GridLayout(3, 2));
        panelCoberturas.add(cbMorangoc);
        panelCoberturas.add(cbChocolate);
        panelCoberturas.add(cbLeiteCondensado);
        panelCoberturas.add(cbMel);
        panelCoberturas.add(cbAmora);
        panelCoberturas.add(cbCaramelo);

        // Painel para complementos
        JPanel panelComplementos = new JPanel(new GridLayout(2, 2));
        panelComplementos.add(cbGranola);
        panelComplementos.add(cbPaçoca);
        panelComplementos.add(cbLeiteNinho);
        panelComplementos.add(cbAmendoim);
        
        // Painel para frutas
        JPanel panelFrutas = new JPanel(new GridLayout(2, 2));
        panelFrutas.add(cbBanana);
        panelFrutas.add(cbMorangof);
        panelFrutas.add(cbManga);
        panelFrutas.add(cbKiwi);

        // Layout principal
        setLayout(new BorderLayout(10, 10));
        add(labelTitulo, BorderLayout.NORTH);

        // Painel central com todas as opções
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.add(labelTamanho);
        panelCentral.add(panelTamanho);
        panelCentral.add(labelCoberturas);
        panelCentral.add(panelCoberturas);
        panelCentral.add(labelComplementos);
        panelCentral.add(panelComplementos);
        panelCentral.add(labelFrutas);
        panelCentral.add(panelFrutas);

        add(panelCentral, BorderLayout.CENTER);

        // Painel para botões
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotoes.add(btnConfirmar);
        panelBotoes.add(btnVoltar);

        add(panelBotoes, BorderLayout.SOUTH);

        pack(); // Ajusta o tamanho da janela
    }
}
