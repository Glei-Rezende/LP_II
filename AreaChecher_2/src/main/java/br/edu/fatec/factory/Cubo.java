package br.edu.fatec.factory;

class Cubo implements Calculable {
    private final double aresta;

    public Cubo(double aresta) {
        this.aresta = aresta;
    }

    @Override
    public double calcularArea() {
        return 6 * aresta * aresta;
    }
}
