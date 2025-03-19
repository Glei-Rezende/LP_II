package br.com.loja.test;

import br.com.loja.empregado.Empregado;

public class TestaEmpregado {
    public static void main(String[] args) {
        // Criar dois empregados
        Empregado empregado1 = new Empregado("João", "Silva", 3000.0);
        Empregado empregado2 = new Empregado("Maria", "Souza", -1500.0); // Salário inválido

        // Exibir salários anuais iniciais
        exibirSalarioAnual("Antes do aumento", empregado1, empregado2);

        // Aplicar aumento de 10%
        empregado1.aplicarAumento();
        empregado2.aplicarAumento();

        // Exibir salários após aumento
        exibirSalarioAnual("Após o aumento", empregado1, empregado2);
    }

    private static void exibirSalarioAnual(String mensagem, Empregado emp1, Empregado emp2) {
        System.out.println("=== " + mensagem + " ===");
        System.out.printf("%s %s: Salário Anual = R$%.2f\n", emp1.getPrimeiroNome(), emp1.getSobrenome(), emp1.getSalarioAnual());
        System.out.printf("%s %s: Salário Anual = R$%.2f\n\n", emp2.getPrimeiroNome(), emp2.getSobrenome(), emp2.getSalarioAnual());
    }
}
