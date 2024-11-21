package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaInicial extends JFrame {

    private ArrayList<Cliente> listaClientes;  // Alterado para usar a classe Cliente

    public TelaInicial() {
        listaClientes = new ArrayList<>(); // Lista de clientes (simulação)
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Inicial");
        setSize(350, 300);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Título
        JLabel labelTitulo = new JLabel("Bem-vindo ao Açaí dos Manos!", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));



        // Botões
        
        JButton btnNovoPedido = new JButton("Iniciar Novo Pedido");
        JButton btnClientes = new JButton("Gerenciar Clientes");
        JButton btnVerPedidos = new JButton("Ver Pedidos");



        btnNovoPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaIncluirPedido();
            }
        });

        btnClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCliente();
            }
        });

        btnVerPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaVerPedidos();
            }
        });

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Usando BoxLayout para empilhar os componentes

        panel.add(Box.createVerticalStrut(10)); // Espaço superior
        panel.add(labelTitulo);
        panel.add(Box.createVerticalStrut(10)); // Espaço entre o título e o campo de CPF
        panel.add(Box.createVerticalStrut(10)); // Espaço entre o campo de CPF e o botão de busca
        panel.add(Box.createVerticalStrut(10)); // Espaço entre o botão de buscar e os outros botões
        panel.add(btnNovoPedido);
        panel.add(Box.createVerticalStrut(10)); // Espaço entre os botões
        panel.add(btnClientes);
        panel.add(Box.createVerticalStrut(10)); // Espaço entre os botões
        panel.add(btnVerPedidos);

        add(panel); // Adiciona o painel à tela

        pack(); // Ajusta o tamanho da janela
    }



    private void cadastrarNovoCliente(String cpf) {
        // Campo de entrada para os dados do cliente
        JTextField txtNome = new JTextField();
        JTextField txtEndereco = new JTextField();
        JTextField txtTelefone = new JTextField();

        // Layout da caixa de diálogo
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(new JLabel("Nome:"));
        panel.add(txtNome);
        panel.add(new JLabel("Endereço:"));
        panel.add(txtEndereco);
        panel.add(new JLabel("Telefone:"));
        panel.add(txtTelefone);
        panel.add(new JLabel("CPF:"));
        panel.add(new JLabel(cpf)); // Exibe o CPF já fornecido

        int result = JOptionPane.showConfirmDialog(this, panel, "Cadastrar Novo Cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String nome = txtNome.getText();
            String endereco = txtEndereco.getText();
            String telefone = txtTelefone.getText();

            // Verifica se todos os campos estão preenchidos
            if (!nome.isEmpty() && !endereco.isEmpty() && !telefone.isEmpty()) {
                // Adiciona o cliente à lista
                Cliente novoCliente = new Cliente(nome, endereco, telefone, cpf);
                listaClientes.add(novoCliente);
                JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
                // Após o cadastro, abre a tela de incluir pedido
                abrirTelaIncluirPedido();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            }
        }
    }

    private void abrirTelaIncluirPedido() {
        TelaIncluirPedido telaIncluirPedido = new TelaIncluirPedido();
        telaIncluirPedido.setVisible(true);
        dispose(); // Fecha a tela atual
    }

    private void abrirTelaCliente() {
        TelaCliente telaCliente = new TelaCliente();
        telaCliente.setVisible(true);
        dispose(); // Fecha a tela atual
    }

    private void abrirTelaVerPedidos() {
        TelaVerPedidos telaVerPedidos = new TelaVerPedidos();
        telaVerPedidos.setVisible(true);
        dispose(); // Fecha a tela atual
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaInicial().setVisible(true));
    }
}

class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String cpf;

    public Cliente(String nome, String endereco, String telefone, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }
}
