package model;

import interfaces.Calculable;

public class Circulo implements Calculable {
    private final double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calculateArea() {
        return Math.PI * raio * raio;
    }
}