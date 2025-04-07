package br.edu.fatec.factory;

public class ShapeFactoryImpl implements ShapeFactory {
    @Override
    public Calculable getShape(ShapeType type, Double[] values) {
        return switch (type) {
            case QUADRADO -> new Quadrado(values[0]);
            case RETANGULO -> new Retangulo(values[0], values[1]);
            case CIRCULO -> new Circulo(values[0]);
            case TRIANGULO -> new Triangulo(values[0], values[1]);
            case PARALELOGRAMA -> new Paralelograma(values[0], values[1]);
            case TRAPEZIO -> new Trapezio(values[0], values[1], values[2]);
            case HEXAGONO -> new Hexagono(values[0]);
            case LOSANGO -> new Losango(values[0], values[1]);
            case CUBO -> new Cubo(values[0]);
        };
    }
}
