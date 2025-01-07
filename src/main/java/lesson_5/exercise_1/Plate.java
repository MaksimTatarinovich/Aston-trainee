package lesson_5.exercise_1;

public class Plate {

    private int food;

    public Plate(int food){
        this.food = food;
    }

    //Метод уменьшения еды
    public boolean decreaseFood(int amount){
        if(food >= amount){
            food -= amount;
            return true;
        }
        return false;
    }

    //Метод добавления еды
    public void addFood(int amount){
        food += amount;
        System.out.println("В миску добавлено " + amount + " еды");
    }
}
