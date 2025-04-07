package model;

import interfaces.Calculable;

public class Paralelogramo implements Calculable {
    private final double base;
    private final double altura;

    public Paralelogramo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calculateArea() {
        return base * altura;
    }
}