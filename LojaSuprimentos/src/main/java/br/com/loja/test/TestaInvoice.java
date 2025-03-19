package br.com.loja.test;

import br.com.loja.fatura.Invoice;

public class TestaInvoice {
    public static void main(String[] args) {
        // Criando faturas com diferentes cenários
        Invoice faturaValida = new Invoice(1, "Teclado Gamer", 2, 250.0);
        Invoice quantidadeInvalida = new Invoice(2, "Mouse", -5, 50.0);
        Invoice precoInvalido = new Invoice(3, "Monitor", 3, -1000.0);

        // Exibindo detalhes e total de cada fatura
        exibirDetalhes(faturaValida);
        exibirDetalhes(quantidadeInvalida);
        exibirDetalhes(precoInvalido);
    }

    private static void exibirDetalhes(Invoice fatura) {
        System.out.println("Item " + fatura.getNumeroItem() + ": " + fatura.getDescricaoItem());
        System.out.println("Quantidade: " + fatura.getQuantidadeComprada());
        System.out.println("Preço Unitário: R$" + fatura.getPrecoUnitario());
        System.out.println("Total da Fatura: R$" + fatura.getInvoiceAmount() + "\n");
    }
}
