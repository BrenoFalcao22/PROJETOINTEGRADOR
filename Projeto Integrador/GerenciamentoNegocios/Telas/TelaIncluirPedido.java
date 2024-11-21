package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaIncluirPedido extends JFrame {

    // Lista estática para armazenar os pedidos
    public static ArrayList<Pedido> listaPedidos = new ArrayList<>();

    public TelaIncluirPedido() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Incluir Pedido de Açaí");
        setSize(500, 600);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Título
        JLabel labelTitulo = new JLabel("Incluir Pedido de Açaí", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));

        // Criar o painel de abas
        JTabbedPane tabbedPane = new JTabbedPane();

        // Aba de Dados do Cliente
        JPanel panelDadosCliente = new JPanel();
        panelDadosCliente.setLayout(new BoxLayout(panelDadosCliente, BoxLayout.Y_AXIS));

        JTextField txtNome = createStyledTextField();
        JTextField txtEndereco = createStyledTextField();
        JTextField txtTelefone = createStyledTextField();
        JTextField txtCpf = createStyledTextField();

        addLabelAndComponent(panelDadosCliente, "Nome:", txtNome);
        addLabelAndComponent(panelDadosCliente, "Endereço:", txtEndereco);
        addLabelAndComponent(panelDadosCliente, "Telefone:", txtTelefone);
        addLabelAndComponent(panelDadosCliente, "CPF:", txtCpf);

        // Aba de Dados do Pedido
        JPanel panelDadosPedido = new JPanel();
        panelDadosPedido.setLayout(new BoxLayout(panelDadosPedido, BoxLayout.Y_AXIS));

        // Campo de seleção para tamanho
        String[] tamanhos = {"Pequeno (300ml)", "Médio (500ml)", "Grande (700ml)"};
        JComboBox<String> comboTamanho = new JComboBox<>(tamanhos);
        comboTamanho.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Checkboxes para coberturas
        JCheckBox cbChocolate = createStyledCheckbox("Chocolate");
        JCheckBox cbMorango = createStyledCheckbox("Morango");
        JCheckBox cbLeiteCondensado = createStyledCheckbox("Leite Condensado");
        JCheckBox cbNutella = createStyledCheckbox("Nutella");

        // Checkboxes para complementos
        JCheckBox cbGranola = createStyledCheckbox("Granola");
        JCheckBox cbLeiteEmPo = createStyledCheckbox("Leite em pó");
        JCheckBox cbPacoca = createStyledCheckbox("Paçoca");
        JCheckBox cbMel = createStyledCheckbox("Mel");

        // Checkboxes para frutas
        JCheckBox cbBanana = createStyledCheckbox("Banana");
        JCheckBox cbMorangoFruta = createStyledCheckbox("Morango");
        JCheckBox cbKiwi = createStyledCheckbox("Kiwi");
        JCheckBox cbManga = createStyledCheckbox("Manga");

        // Adiciona os componentes à aba de pedido
        addLabelAndComponent(panelDadosPedido, "Tamanho:", comboTamanho);
        addLabelAndComponent(panelDadosPedido, "Coberturas:", createCheckboxPanel(cbChocolate, cbMorango, cbLeiteCondensado, cbNutella));
        addLabelAndComponent(panelDadosPedido, "Complementos:", createCheckboxPanel(cbGranola, cbLeiteEmPo, cbPacoca, cbMel));
        addLabelAndComponent(panelDadosPedido, "Frutas:", createCheckboxPanel(cbBanana, cbMorangoFruta, cbKiwi, cbManga));

        // Adicionar as abas ao painel de abas
        tabbedPane.addTab("Dados do Cliente", panelDadosCliente);
        tabbedPane.addTab("Dados do Pedido", panelDadosPedido);

        // Painel para os botões
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnProsseguir = new JButton("Salvar Pedido");
        JButton btnVoltar = new JButton("Voltar ao Menu");

        // Ação para o botão "Salvar Pedido"
        btnProsseguir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coletar os dados do pedido
                String nome = txtNome.getText();
                String endereco = txtEndereco.getText();
                String telefone = txtTelefone.getText();
                String cpf = txtCpf.getText();
                String tamanho = (String) comboTamanho.getSelectedItem();

                // Coletar coberturas marcadas
                ArrayList<String> coberturas = new ArrayList<>();
                if (cbChocolate.isSelected()) coberturas.add("Chocolate");
                if (cbMorango.isSelected()) coberturas.add("Morango");
                if (cbLeiteCondensado.isSelected()) coberturas.add("Leite Condensado");
                if (cbNutella.isSelected()) coberturas.add("Nutella");

                // Coletar complementos marcados
                ArrayList<String> complementos = new ArrayList<>();
                if (cbGranola.isSelected()) complementos.add("Granola");
                if (cbLeiteEmPo.isSelected()) complementos.add("Leite em pó");
                if (cbPacoca.isSelected()) complementos.add("Paçoca");
                if (cbMel.isSelected()) complementos.add("Mel");

                // Coletar frutas marcadas
                ArrayList<String> frutas = new ArrayList<>();
                if (cbBanana.isSelected()) frutas.add("Banana");
                if (cbMorangoFruta.isSelected()) frutas.add("Morango");
                if (cbKiwi.isSelected()) frutas.add("Kiwi");
                if (cbManga.isSelected()) frutas.add("Manga");

                // Validar os campos
                if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty() || cpf.isEmpty() || coberturas.isEmpty() || complementos.isEmpty() || frutas.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Criar o pedido e adicionar à lista estática
                Pedido pedido = new Pedido(nome, endereco, telefone, cpf, tamanho,
                        String.join(", ", coberturas),
                        String.join(", ", complementos),
                        String.join(", ", frutas));
                listaPedidos.add(pedido); // Adiciona o pedido à lista

                JOptionPane.showMessageDialog(null, "Pedido salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                // Voltar à tela de pedidos
                new TelaVerPedidos().setVisible(true);
                dispose();
            }
        });

        // Ação para o botão "Voltar"
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaInicial().setVisible(true);
                dispose();
            }
        });

        panelBotoes.add(btnProsseguir);
        panelBotoes.add(btnVoltar);

        // Layout principal
        setLayout(new BorderLayout(10, 10));
        add(labelTitulo, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);

        pack(); // Ajusta o tamanho da janela
    }

    // Método auxiliar para criar um JTextField estilizado
    private JTextField createStyledTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField.setPreferredSize(new Dimension(300, 25)); // Ajusta a largura e a altura do campo
        return textField;
    }

    // Método auxiliar para adicionar labels e componentes ao painel
    private void addLabelAndComponent(JPanel panel, String labelText, Component component) {
        JPanel subPanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Ajusta o tamanho da fonte
        subPanel.add(label, BorderLayout.NORTH);
        subPanel.add(component, BorderLayout.CENTER);
        subPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Adiciona um espaçamento
        panel.add(subPanel);
    }

    // Método para criar checkboxes estilizados
    private JCheckBox createStyledCheckbox(String text) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Ajusta o tamanho da fonte
        return checkBox;
    }

    // Método para criar painel com checkboxes
    private JPanel createCheckboxPanel(JCheckBox... checkBoxes) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(checkBoxes.length, 1, 5, 5)); // Uma coluna com espaçamento
        for (JCheckBox checkBox : checkBoxes) {
            panel.add(checkBox);
        }
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaIncluirPedido().setVisible(true));
    }
}
