package br.com.loja.test;

import br.com.loja.complex.Complex;

public class TestaComplex {
    public static void main(String[] args) {
        // Criar números complexos usando todos os construtores
        Complex zero = new Complex();
        Complex numReal = new Complex(3.0);
        Complex numCompleto = new Complex(2.0, 5.0);
        Complex outro = new Complex(1.0, -1.0);

        // Testar operações
        System.out.println("=== Operações Básicas ===");
        System.out.println("zero: " + zero);
        System.out.println("numReal: " + numReal);
        System.out.println("numCompleto: " + numCompleto);
        System.out.println("outro: " + outro);

        System.out.println("\n=== Módulo e Ângulo ===");
        System.out.printf("Módulo de numCompleto: %.2f\n", numCompleto.modulo());
        System.out.printf("Ângulo de numCompleto: %.2f rad\n", numCompleto.angulo());

        System.out.println("\n=== Inverso Aditivo ===");
        System.out.println("Inverso de numCompleto: " + numCompleto.inversoAditivo());

        System.out.println("\n=== Aritmética ===");
        Complex soma = numCompleto.adicionar(outro);
        System.out.println("Adição: " + numCompleto + " + " + outro + " = " + soma);

        Complex subtracao = numCompleto.subtrair(outro);
        System.out.println("Subtração: " + numCompleto + " - " + outro + " = " + subtracao);

        Complex produto = numCompleto.multiplicar(outro);
        System.out.println("Multiplicação: " + numCompleto + " * " + outro + " = " + produto);

        Complex divisao = numCompleto.dividir(outro);
        System.out.println("Divisão: " + numCompleto + " / " + outro + " = " + divisao);
    }
}
