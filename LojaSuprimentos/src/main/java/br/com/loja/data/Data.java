package br.com.loja.data;

import java.util.Calendar;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    // Construtor com validação
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        validarData();
    }

    // Construtor sem parâmetros (data atual)
    public Data() {
        Calendar hoje = Calendar.getInstance();
        this.dia = hoje.get(Calendar.DAY_OF_MONTH);
        this.mes = hoje.get(Calendar.MONTH) + 1; // Ajusta para 1-12
        this.ano = hoje.get(Calendar.YEAR);
    }

    // Getters e Setters com validação
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
        validarData();
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
        validarData();
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
        validarData();
    }

    // Validação automática para garantir consistência
    private void validarData() {
        // Corrige mês fora do intervalo 1-12
        if (mes < 1) mes = 1;
        else if (mes > 12) mes = 12;

        // Corrige dia para o máximo permitido no mês/ano
        int maxDias = getMaxDias(mes, ano);
        if (dia < 1) dia = 1;
        else if (dia > maxDias) dia = maxDias;
    }

    // Retorna o número máximo de dias para um mês/ano
    private int getMaxDias(int mes, int ano) {
        switch (mes) {
            case 2: return ehBissexto(ano) ? 29 : 28;
            case 4: case 6: case 9: case 11: return 30;
            default: return 31;
        }
    }

    // Verifica se um ano é bissexto
    private boolean ehBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    // Avança para o próximo dia
    public void avancarParaDiaSeguinte() {
        dia++;
        int maxDias = getMaxDias(mes, ano);
        if (dia > maxDias) {
            dia = 1;
            mes++;
            if (mes > 12) {
                mes = 1;
                ano++;
            }
        }
    }

    // Formata a data como dd/mm/aaaa
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}
