import enums.ShapeType;
import factory.ShapeFactoryImpl;
import interfaces.Calculable;

public class Main {
    public static void main(String[] args) {
        ShapeFactoryImpl factory = new ShapeFactoryImpl();

        // Teste Quadrado
        Calculable quadrado = factory.createShape(ShapeType.QUADRADO, 5);
        System.out.println("Área do quadrado: " + quadrado.calculateArea());

        // Teste Retângulo
        Calculable retangulo = factory.createShape(ShapeType.RETANGULO, 4, 6);
        System.out.println("Área do retângulo: " + retangulo.calculateArea());

        // Teste Círculo
        Calculable circulo = factory.createShape(ShapeType.CIRCULO, 3);
        System.out.println("Área do círculo: " + circulo.calculateArea());

        // Teste Triângulo
        Calculable triangulo = factory.createShape(ShapeType.TRIANGULO, 4, 5);
        System.out.println("Área do triângulo: " + triangulo.calculateArea());

        // Teste Paralelogramo
        Calculable paralelogramo = factory.createShape(ShapeType.PARALELOGRAMO, 5, 7);
        System.out.println("Área do paralelogramo: " + paralelogramo.calculateArea());

        // Teste Trapézio
        Calculable trapezio = factory.createShape(ShapeType.TRAPEZIO, 8, 5, 4);
        System.out.println("Área do trapézio: " + trapezio.calculateArea());

        // Teste Hexágono
        Calculable hexagono = factory.createShape(ShapeType.HEXAGONO, 4);
        System.out.println("Área do hexágono: " + hexagono.calculateArea());

        // Teste Losango
        Calculable losango = factory.createShape(ShapeType.LOSANGO, 8, 6);
        System.out.println("Área do losango: " + losango.calculateArea());

        // Teste Cubo
        Calculable cubo = factory.createShape(ShapeType.CUBO, 3);
        System.out.println("Área do cubo: " + cubo.calculateArea());
    }
}
