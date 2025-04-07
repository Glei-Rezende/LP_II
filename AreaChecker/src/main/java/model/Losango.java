package model;

import interfaces.Calculable;

public class Losango implements Calculable {
    private final double diagonalMaior;
    private final double diagonalMenor;

    public Losango(double diagonalMaior, double diagonalMenor) {
        this.diagonalMaior = diagonalMaior;
        this.diagonalMenor = diagonalMenor;
    }

    @Override
    public double calculateArea() {
        return (diagonalMaior * diagonalMenor) / 2;
    }
}