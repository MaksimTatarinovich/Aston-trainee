package lesson_5.exercise_1;

public class Dog extends Animal{

    private static int countOfDogs = 0;

    public Dog(String name){
        super(name, 500, 10);
        countOfDogs++;
    }

    public static int getCountOfDogs(){return countOfDogs;}

    public void run(int distance) {
        if(distance <= getRunLimit() && distance > 0)
            System.out.println(getName() + " пробежал " + distance + " метров");
        else if(distance > getRunLimit())
            System.out.println(getName() + " может пробежать только 500 метров");
        else if(distance == 0)
            System.out.println(getName() + " стоит на месте");
        else
            System.out.println("Длина препятсвия введена неправильно");
    }

    public void swim(int distance){
        if(distance <= getSwimLimit() && distance > 0)
            System.out.println(getName() + " проплыл " + distance + " метров");
        else if(distance > getSwimLimit())
            System.out.println(getName() + " не смог проплыть " + distance + " метров и утонул:(");
        else if(distance == 0)
            System.out.println(getName() + " стоит на месте");
        else
            System.out.println("Длина препятсвия введена неправильно");
    }
}
