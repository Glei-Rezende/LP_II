package br.com.loja.complex;

public class Complex {
    private double real;
    private double imaginario;

    // Construtores
    public Complex() {
        this(0.0, 0.0); // Chama o construtor com dois parâmetros
    }

    public Complex(double real) {
        this(real, 0.0); // Parte imaginária é zero
    }

    public Complex(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    // Getters
    public double getReal() {
        return real;
    }

    public double getImaginario() {
        return imaginario;
    }

    // Operações básicas
    public double modulo() {
        return Math.sqrt(real * real + imaginario * imaginario);
    }

    public double angulo() {
        return Math.atan2(imaginario, real); // Ângulo em radianos
    }

    // Inverso aditivo
    public Complex inversoAditivo() {
        return new Complex(-real, -imaginario);
    }

    // Operações aritméticas
    public Complex adicionar(Complex outro) {
        return new Complex(
                this.real + outro.real,
                this.imaginario + outro.imaginario
        );
    }

    public Complex subtrair(Complex outro) {
        return new Complex(
                this.real - outro.real,
                this.imaginario - outro.imaginario
        );
    }

    public Complex multiplicar(Complex outro) {
        double novoReal = this.real * outro.real - this.imaginario * outro.imaginario;
        double novoImaginario = this.real * outro.imaginario + this.imaginario * outro.real;
        return new Complex(novoReal, novoImaginario);
    }

    public Complex dividir(Complex outro) {
        double divisor = outro.real * outro.real + outro.imaginario * outro.imaginario;
        double novoReal = (this.real * outro.real + this.imaginario * outro.imaginario) / divisor;
        double novoImaginario = (this.imaginario * outro.real - this.real * outro.imaginario) / divisor;
        return new Complex(novoReal, novoImaginario);
    }

    // Representação em String
    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", real, imaginario);
    }
}
