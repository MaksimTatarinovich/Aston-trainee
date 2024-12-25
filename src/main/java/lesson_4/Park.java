package lesson_4;

public class Park {
    private String address;
    private String name;

    public Park(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public void printInfoAboutPark(){
        System.out.println("Парк " + name + "\nАдресс парка: " + address +  "\n");
    }

    public class Attraction {
        String name;
        String workingHours;
        double ticketCost;

        public Attraction(String name, String workingHours, double ticketCost) {
            this.name = name;
            this.workingHours = workingHours;
            this.ticketCost = ticketCost;
        }

        public void printInformationAboutAttraction() {
            System.out.println("Аттракцион: " + name + "\nРабочее время: " + workingHours +
                    "\nЦена билета: " + ticketCost + "\n");
        }
    }

    public static void main(String[] args) {
        Park park1 = new Park("ул. Фрунзе 2", "М.Горького");
        Park park2 = new Park("ул. Советская 5", "Челюскинцев");
        Attraction ferrisWheel = park1.new Attraction("Колесо обозрения", "12:00 - 20:00", 250);
        Attraction autodrome = park1.new Attraction("Автодром", "10:00 - 18:00", 100);
        Attraction dragon = park2.new Attraction("Дракоша", "14:00 - 18:00", 30);

        park1.printInfoAboutPark();
        ferrisWheel.printInformationAboutAttraction();
        autodrome.printInformationAboutAttraction();
        park2.printInfoAboutPark();
        dragon.printInformationAboutAttraction();
    }
}
