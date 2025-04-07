package br.ed.fatec.main;

import br.edu.fatec.factory.Calculable;
import br.edu.fatec.factory.ShapeFactory;
import br.edu.fatec.factory.ShapeFactoryImpl;
import br.edu.fatec.factory.ShapeType;

public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactoryImpl();

        // Teste para Quadrado
        Calculable quadrado = factory.getShape(ShapeType.QUADRADO, new Double[]{5.0});
        System.out.println("Área do quadrado: " + quadrado.calcularArea());

        // Teste para Retângulo
        Calculable retangulo = factory.getShape(ShapeType.RETANGULO, new Double[]{4.0, 6.0});
        System.out.println("Área do retângulo: " + retangulo.calcularArea());

        // Teste para Círculo
        Calculable circulo = factory.getShape(ShapeType.CIRCULO, new Double[]{3.0});
        System.out.println("Área do círculo: " + circulo.calcularArea());

        // Teste para Triângulo
        Calculable triangulo = factory.getShape(ShapeType.TRIANGULO, new Double[]{4.0, 3.0});
        System.out.println("Área do triângulo: " + triangulo.calcularArea());

        // Teste para Paralelograma
        Calculable paralelograma = factory.getShape(ShapeType.PARALELOGRAMA, new Double[]{5.0, 7.0});
        System.out.println("Área do paralelograma: " + paralelograma.calcularArea());

        // Teste para Trapézio
        Calculable trapezio = factory.getShape(ShapeType.TRAPEZIO, new Double[]{8.0, 5.0, 4.0});
        System.out.println("Área do trapézio: " + trapezio.calcularArea());

        // Teste para Hexágono
        Calculable hexagono = factory.getShape(ShapeType.HEXAGONO, new Double[]{2.0});
        System.out.println("Área do hexágono: " + hexagono.calcularArea());

        // Teste para Losango
        Calculable losango = factory.getShape(ShapeType.LOSANGO, new Double[]{6.0, 4.0});
        System.out.println("Área do losango: " + losango.calcularArea());

        // Teste para Cubo
        Calculable cubo = factory.getShape(ShapeType.CUBO, new Double[]{3.0});
        System.out.println("Área do cubo: " + cubo.calcularArea());
    }
}