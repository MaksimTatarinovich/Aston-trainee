package lesson_5.exercise_2;

public interface GeometricShape {

    default double getArea(){
        throw new UnsupportedOperationException();
    }

    default double getPerimeter(){
        throw new UnsupportedOperationException();
    }

    String getBorderColor();
    String getFillColor();
    String getName();
}
