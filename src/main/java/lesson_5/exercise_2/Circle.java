package lesson_5.exercise_2;

public class Circle extends AbstractShape{

    private double radius;

    public Circle(String fillColor, String borderColor, double radius) {
        super(fillColor, borderColor, "Круг");
        this.radius = radius;
    }

    @Override
    public double getPerimeter(){
        return  2 * Math.PI * radius;
    }

    @Override
    public double getArea(){
        return Math.PI * radius * radius;
    }
}
