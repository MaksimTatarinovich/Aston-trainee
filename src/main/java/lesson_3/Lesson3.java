import java.util.Arrays;

public class Lesson3 {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(isSumInRange(1,9) + "\n");
        checkNumberSign(1);
        System.out.println(isNegative(-1) + "\n");
        printStringNTimes("G-Shock", 3);
        System.out.println(isLeapYear(100) + "\n");
        invertArray();
        fillArray(100);
        multiplyLessThanSix();
        fillDiagonalElements(7);
        createArrayWithInitialValue(5, 3);
    }

    public static void printThreeWords() {
        System.out.println("Orange \nBanana \nApple\n");
    }

    public static void checkSumSign() {
        int a = 1, b = 2;
        if (a + b >= 0)
            System.out.println("Сумма положительная\n");
        else
            System.out.println("Сумма отрицательная\n");
    }

    public static void printColor() {
        int value = 100;
        if (value <= 0)
            System.out.println("Красный\n");
            else if (value <= 100)
            System.out.println("Жёлтый\n");
            else
            System.out.println("Зелёный\n");
    }

    public static void compareNumbers() {
        int a = 5, b = 2;
        if (a >= b)
            System.out.println("a >= b\n");
        else
            System.out.println("a < b\n");
    }

    public static boolean isSumInRange(int num1, int num2) {
        return num1 + num2 >= 10 && num1 + num2 <= 20;
    }

    public static void checkNumberSign(int number) {
        if (number >= 0)
            System.out.println("Было передано положительное число\n");
        else
            System.out.println("Было передано отрицательное число\n");
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void printStringNTimes(String string, int number) {
        int i = 0;
        do {
            System.out.println(string);
            i++;
        } while (i < number);
        System.out.println();
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void invertArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Исходный массив:");
        for (int a : array) {
            System.out.print(a + " ");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }

        System.out.println("\nИнвертированный массив:");
        for (int b : array) {
            System.out.print(b + " ");
        }
        System.out.println("\n");
    }

    public static void fillArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public static void multiplyLessThanSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Исходный массив:");
        for (int a : array) {
            System.out.print(a + " ");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] *= 2;
        }

        System.out.println("\nИзмененный массив:");
        for (int b : array) {
            System.out.print(b + " ");
        }
        System.out.println("\n");
    }

    public static void fillDiagonalElements(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            array[i][i] = 1;
            array[i][n - 1 - i] = 1;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        System.out.println();
    }

    public static int[] createArrayWithInitialValue(int len, int initialValue){
        int[] array = new int[len];

        for (int i = 0; i < len; i++){
            array[i] = initialValue;
            System.out.print(array[i] + " ");
        }
        return array;
    }
}