package Telas;

public class Pedido {
    private String nome;
    private String endereco;
    private String telefone;
    private String cpf;
    private String tamanho;
    private String cobertura;
    private String complementos;
    private String frutas;

    // Construtor
    public Pedido(String nome, String endereco, String telefone, String cpf, String tamanho, String cobertura, String complementos, String frutas) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.tamanho = tamanho;
        this.cobertura = cobertura;
        this.complementos = complementos;
        this.frutas = frutas;
    }

    // Getters
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

    public String getTamanho() {
        return tamanho;
    }

    public String getCobertura() {
        return cobertura;
    }

    public String getComplementos() {
        return complementos;
    }

    public String getFrutas() {
        return frutas;
    }
}
