package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaCliente extends JFrame {

    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtTelefone;
    private JList<Cliente> listClientes; // Componente para listar clientes

    // Lista para armazenar os clientes (Simulação)
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private Cliente clienteSelecionado; // Cliente que está sendo editado

    public TelaCliente() {
        initComponents();
        atualizarListaClientes(); // Atualiza a lista ao abrir a tela
    }

    private void initComponents() {
        setTitle("Gerenciar Cliente");
        setSize(500, 400);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Título
        JLabel labelTitulo = new JLabel("Dados do Cliente", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));

        // Labels para os campos
        JLabel lblNome = new JLabel("Nome:");
        JLabel lblEndereco = new JLabel("Endereço:");
        JLabel lblTelefone = new JLabel("Telefone:");

        // Campos de texto
        txtNome = new JTextField();
        txtEndereco = new JTextField();
        txtTelefone = new JTextField();

        // Lista de clientes
        listClientes = new JList<>();
        listClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listClientes.addListSelectionListener(e -> selecionarCliente());

        // Botões
        JButton btnSalvar = new JButton("Salvar");
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnVoltar = new JButton("Voltar");

        // Ação do botão "Salvar"
        btnSalvar.addActionListener(e -> salvarCliente());

        // Ação do botão "Editar"
        btnEditar.addActionListener(e -> editarCliente());

        // Ação do botão "Excluir"
        btnExcluir.addActionListener(e -> excluirCliente());

        // Ação do botão "Voltar"
        btnVoltar.addActionListener(e -> voltarTelaInicial());

        // Painel para os campos
        JPanel panelCampos = new JPanel(new GridLayout(4, 2, 10, 10));
        panelCampos.add(lblNome);
        panelCampos.add(txtNome);
        panelCampos.add(lblEndereco);
        panelCampos.add(txtEndereco);
        panelCampos.add(lblTelefone);
        panelCampos.add(txtTelefone);
        panelCampos.add(btnSalvar);
        panelCampos.add(btnEditar);

        // Painel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.add(labelTitulo, BorderLayout.NORTH);
        panelPrincipal.add(new JScrollPane(listClientes), BorderLayout.WEST); // Lista de clientes
        panelPrincipal.add(panelCampos, BorderLayout.CENTER);

        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotoes.add(btnExcluir);
        panelBotoes.add(btnVoltar);

        panelPrincipal.add(panelBotoes, BorderLayout.SOUTH);

        // Adiciona o painel principal à janela
        add(panelPrincipal);

        pack(); // Ajusta o tamanho da janela
    }

    private void salvarCliente() {
        String nome = txtNome.getText();
        String endereco = txtEndereco.getText();
        String telefone = txtTelefone.getText();

        // Verifica se todos os campos foram preenchidos
        if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            if (clienteSelecionado == null) {
                // Se o cliente não está sendo editado, cria um novo cliente
                Cliente cliente = new Cliente(nome, endereco, telefone);
                listaClientes.add(cliente); // Adiciona o cliente à lista
                JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");
            } else {
                // Se o cliente está sendo editado, atualiza os dados
                clienteSelecionado.setNome(nome);
                clienteSelecionado.setEndereco(endereco);
                clienteSelecionado.setTelefone(telefone);
                JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!");
            }

            // Limpa os campos e atualiza a lista
            limparCampos();
            atualizarListaClientes();
        }
    }

    private void editarCliente() {
        if (clienteSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluirCliente() {
        if (clienteSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este cliente?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                listaClientes.remove(clienteSelecionado);
                JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
                limparCampos();
                atualizarListaClientes();
            }
        }
    }

    private void selecionarCliente() {
        clienteSelecionado = listClientes.getSelectedValue();
        if (clienteSelecionado != null) {
            txtNome.setText(clienteSelecionado.getNome());
            txtEndereco.setText(clienteSelecionado.getEndereco());
            txtTelefone.setText(clienteSelecionado.getTelefone());
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        clienteSelecionado = null; // Reseta o cliente selecionado
        listClientes.clearSelection();
    }

    private void atualizarListaClientes() {
        DefaultListModel<Cliente> model = new DefaultListModel<>();
        for (Cliente cliente : listaClientes) {
            model.addElement(cliente);
        }
        listClientes.setModel(model);
    }

    private void voltarTelaInicial() {
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setVisible(true);
        dispose(); // Fecha a tela atual
    }

    public static void main(String[] args) {
        // Adiciona alguns clientes para teste
        listaClientes.add(new Cliente("João", "Rua A, 123", "123456789"));
        listaClientes.add(new Cliente("Maria", "Rua B, 456", "987654321"));

        SwingUtilities.invokeLater(() -> new TelaCliente().setVisible(true));
    }

    // Classe Cliente incluída dentro do mesmo arquivo
    public static class Cliente {
        private String nome;
        private String endereco;
        private String telefone;

        // Construtor
        public Cliente(String nome, String endereco, String telefone) {
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
        }

        // Getters e Setters
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        @Override
        public String toString() {
            return nome + " - " + telefone;
        }
    }
}