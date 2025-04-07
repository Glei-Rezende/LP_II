package br.edu.fatec.factory;

class Trapezio implements Calculable {
    private final double baseMaior;
    private final double baseMenor;
    private final double altura;

    public Trapezio(double baseMaior, double baseMenor, double altura) {
        this.baseMaior = baseMaior;
        this.baseMenor = baseMenor;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return ((baseMaior + baseMenor) * altura) / 2;
    }
}
