package model;

import interfaces.Calculable;

public class Quadrado implements Calculable {
    private final double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calculateArea() {
        return lado * lado;
    }
}
