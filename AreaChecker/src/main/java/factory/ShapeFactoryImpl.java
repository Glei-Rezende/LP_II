package factory;

import enums.ShapeType;
import interfaces.Calculable;
import model.*;

public class ShapeFactoryImpl {
    public Calculable createShape(ShapeType type, double... params) {
        return switch (type) {
            case QUADRADO -> new Quadrado(params[0]);
            case RETANGULO -> new Retangulo(params[0], params[1]);
            case CIRCULO -> new Circulo(params[0]);
            case TRIANGULO -> new Triangulo(params[0], params[1]);
            case PARALELOGRAMO -> new Paralelogramo(params[0], params[1]);
            case TRAPEZIO -> new Trapezio(params[0], params[1], params[2]);
            case HEXAGONO -> new Hexagono(params[0]);
            case LOSANGO -> new Losango(params[0], params[1]);
            case CUBO -> new Cubo(params[0]);
        };
    }
}