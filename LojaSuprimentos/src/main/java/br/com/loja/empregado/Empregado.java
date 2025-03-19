package br.com.loja.empregado;

public class Empregado {
    private String primeiroNome;
    private String sobrenome;
    private double salarioMensal;

    // Construtor com validação
    public Empregado(String primeiroNome, String sobrenome, double salarioMensal) {
        this.setPrimeiroNome(primeiroNome);
        this.setSobrenome(sobrenome);
        this.setSalarioMensal(salarioMensal); // Valida salário
    }

    // Getters e Setters
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) {
        // Se salário negativo, define como 0.0
        this.salarioMensal = Math.max(salarioMensal, 0.0);
    }

    // Método para calcular salário anual
    public double getSalarioAnual() {
        return salarioMensal * 12;
    }

    // Método para aplicar aumento de 10%
    public void aplicarAumento() {
        salarioMensal *= 1.10;
    }
}
