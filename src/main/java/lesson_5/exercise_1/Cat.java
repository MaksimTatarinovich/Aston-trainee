package lesson_5.exercise_1;

public class Cat extends Animal{

    private static int countOfCats = 0;
    private boolean satiety;

    public Cat(String name){
        super(name, 200);
        countOfCats++;
        this.satiety = false;
    }

    //Метод поедания еды из тарелки
    public void eat(Plate plate, int amount){
        if(plate.decreaseFood(amount)){
            satiety = true;
            System.out.println("\n" + getName() + " поел и сыт");
        }
        else
            System.out.println("В миске недостаточно еды");
    }

    //Метод проверки сытости
    public boolean isSatiety(){
        return satiety;
    }

    public static int getCountOfCats(){return countOfCats;}

    public void run(int distance) {
        if(distance <= getRunLimit() && distance > 0)
            System.out.println(getName() + " пробежал " + distance + " метров");
        else if(distance == 0)
            System.out.println(getName() + " стоит на месте");
        else if(distance > getRunLimit())
            System.out.println(getName() + " может пробежать не более 200 метров");
        else
            System.out.println("Длина препятствия введена неправильно");
    }

    public void swim() {System.out.println(getName() + " не умеет плавать, он утонул:(");}
}
