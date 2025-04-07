package model;

import interfaces.Calculable;

public class Cubo implements Calculable {
    private final double aresta;

    public Cubo(double aresta) {
        this.aresta = aresta;
    }

    @Override
    public double calculateArea() {
        return 6 * aresta * aresta;
    }
}
