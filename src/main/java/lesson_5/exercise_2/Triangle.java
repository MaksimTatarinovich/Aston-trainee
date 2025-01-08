package lesson_5.exercise_2;

public class Triangle extends AbstractShape{

    private double a, b, c;

    public Triangle(String fillColor, String borderColor, double a, double b, double c) {
        super(fillColor, borderColor, "Треугольник");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter(){
        return a + b + c;
    }

    @Override
    public double getArea(){
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
