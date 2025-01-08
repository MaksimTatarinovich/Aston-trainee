package lesson_5.exercise_2;

public class Main {
    public static void main(String[] args) {

        GeometricShape[] geometricShapes = {
                new Circle("Зелёный ", "Красный", 5),
                new Rectangle("Фиолетовый ", "Коричневый", 6, 4),
                new Triangle("Синий ", "Серо-буро-малиновый", 4, 6, 8)
        };

        for(GeometricShape geometricShape : geometricShapes){
            System.out.println("--- " + geometricShape.getName() + " ---");
            System.out.println("Периметр: " + geometricShape.getPerimeter());
            System.out.println("Площадь: " + geometricShape.getArea());
            System.out.println("Цвет фона: " + geometricShape.getFillColor());
            System.out.println("Цвет границы: " + geometricShape.getBorderColor() + "\n");
        }
    }
}
