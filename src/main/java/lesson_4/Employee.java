package lesson_4;

public class Employee {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfoAboutEmployee() {
        System.out.println("ФИО: " + fio + "\nДолжность: " + position + "\nПочта: " + email +
                "\nТелефон: " + phone + "\nЗарплата: " + salary + "\nВозраст: " + age + "\n");
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Tatarinovich Maksim Aleksandrovich", "QA-engineer",
                "tatarinovicmaksim2@gmail.com", "+7864592486", 700, 22);

        employee1.printInfoAboutEmployee();

        //Задание №2
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Hryschev Nikita Mihalich", "Head Of KPSS", "NikPalich@mail.ru",
                "no info", 9999, 57);
        employees[1] = new Employee("Thomas Muller Genadievich", "CAM",
                "TomMuller@gmail.de", "+5498726154", 6999, 35);
        employees[2] = new Employee("Ronaldo Cristiano Suuuiiievich", "Director of goals",
                "criro7@gmail.com", "+77777777777", 77777777, 37);
        employees[3] = new Employee("Lapot Darya Sergeevna", "Marketolog",
                "dashkamarket@mail.ru", "+2148930", 590, 21);
        employees[4] = new Employee("Antonovich Dmitriy Aleksandrovich", "Project Manager",
                "dimaAnt@gmail.com", "+37598645862", 300, 22);

        for (Employee empls : employees) {
            empls.printInfoAboutEmployee();
        }
    }
}
