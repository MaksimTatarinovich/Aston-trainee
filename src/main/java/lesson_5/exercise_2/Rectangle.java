package lesson_5.exercise_2;

public class Rectangle extends AbstractShape{

    private double width, height;

    public Rectangle(String fillColor, String borderColor, double width, double height) {
        super(fillColor, borderColor, "Прямоугольник");
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea(){
        return width * height;
    }

    @Override
    public double getPerimeter(){
        return 2 * (width + height);
    }
}
