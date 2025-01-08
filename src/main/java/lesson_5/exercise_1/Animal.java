package lesson_5.exercise_1;

public class Animal {

    private static int countOfAnimals = 0;
    private String name;
    private int runLimit;
    private int swimLimit;

    public Animal(String name, int runLimit, int swimLimit){
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        countOfAnimals++;
    }

    public Animal(String name, int runLimit){
        this.name = name;
        this.runLimit = runLimit;
        countOfAnimals++;
    }

    public Animal(String name){
        this.name = name;
        countOfAnimals++;
    }

    public String getName(){return name;}

    public int getRunLimit(){return runLimit;}

    public int getSwimLimit(){return swimLimit;}

    public static int getCountOfAnimals(){return countOfAnimals;}

    public void run(int distance){System.out.println(getName() + " пробежал " + distance + " метров");}

    public void swim(int distance){System.out.println(getName() + " проплыл " + distance + " метров");}

    public void swim(){System.out.println(getName() + " плывёт");}
}
