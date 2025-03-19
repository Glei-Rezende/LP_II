package br.com.loja.fatura;

public class Invoice {
    // Atributos
    private int numeroItem;
    private String descricaoItem;
    private int quantidadeComprada;
    private double precoUnitario;

    // Construtor com validação
    public Invoice(int numeroItem, String descricaoItem, int quantidadeComprada, double precoUnitario) {
        this.setNumeroItem(numeroItem);
        this.setDescricaoItem(descricaoItem);
        this.setQuantidadeComprada(quantidadeComprada); // Valida quantidade
        this.setPrecoUnitario(precoUnitario); // Valida preço
    }

    // Getters e Setters com validação
    public int getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(int numeroItem) {
        this.numeroItem = numeroItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(int quantidadeComprada) {
        // Se negativo, define como 0
        this.quantidadeComprada = Math.max(quantidadeComprada, 0);
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        // Se negativo, define como 0.0
        this.precoUnitario = Math.max(precoUnitario, 0.0);
    }

    // Método para calcular o total da fatura
    public double getInvoiceAmount() {
        return quantidadeComprada * precoUnitario;
    }
}
