package br.com.loja.test;

import br.com.loja.data.Data;

public class TestaData {
    public static void main(String[] args) {
        // Teste 1: Data inválida corrigida automaticamente
        Data data1 = new Data(31, 2, 2023); // 31 de fevereiro
        System.out.println("Data1 corrigida: " + data1);

        // Teste 2: Avançar para o próximo dia
        Data data2 = new Data(28, 2, 2023); // Não bissexto
        data2.avancarParaDiaSeguinte();
        System.out.println("\nData2 após avanço: " + data2);

        // Teste 3: Data atual e avanço
        Data dataAtual = new Data();
        System.out.println("\nData atual: " + dataAtual);
        dataAtual.avancarParaDiaSeguinte();
        System.out.println("Data atual após avanço: " + dataAtual);

        // Teste 4: Alteração via setters
        Data data3 = new Data(32, 13, 2022); // Data inválida
        System.out.println("\nData3 original: " + data3);
        data3.setMes(2);
        data3.setDia(30); // Tentativa de 30 de fevereiro
        System.out.println("Data3 após ajustes: " + data3);
    }
}
