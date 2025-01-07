package lesson_5.exercise_1;

public class Lesson_5 {
    public static void main(String[] args){

        Dog dogBarsik = new Dog("Барсик");
        Cat catBarbos = new Cat("Барбос");
        Cat catMurzik = new Cat("Мурзик");
        Dog dogTyzik = new Dog("Тузик");
        Animal begemot = new Animal("Гипопотам");

        Plate plate = new Plate(20);

        catBarbos.run(10);
        catBarbos.swim();

        catMurzik.run(100);

        dogBarsik.run(50);
        dogBarsik.swim(500);

        begemot.swim(1000);

        Cat[] cats = {catBarbos, catMurzik};
        for (Cat cat : cats) {
            cat.eat(plate, 10);
        }

        System.out.println("\nСытость котов:");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isSatiety());
        }

        System.out.println("\nКоличество животных: " + Animal.getCountOfAnimals());
        System.out.println("Количество собак: " + Dog.getCountOfDogs());
        System.out.println("Количество котов: " + Cat.getCountOfCats());
    }
}
