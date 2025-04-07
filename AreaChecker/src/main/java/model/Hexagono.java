package model;

import interfaces.Calculable;

public class Hexagono implements Calculable {
    private final double lado;

    public Hexagono(double lado) {
        this.lado = lado;
    }

    @Override
    public double calculateArea() {
        return (3 * Math.sqrt(3) * lado * lado) / 2;
    }
}
