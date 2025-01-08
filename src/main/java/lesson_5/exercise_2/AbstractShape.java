package lesson_5.exercise_2;

public class AbstractShape implements GeometricShape {

    private String fillColor;
    private String borderColor;
    private final String name;

     public AbstractShape(String fillColor, String borderColor, String name){
         this.fillColor = fillColor;
         this.borderColor = borderColor;
         this.name = name;
     }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getName() { return name; }
}

