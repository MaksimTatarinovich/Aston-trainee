package lesson_13;

public class Factorial {
    public long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Невозможно высчитать факториал отрицательного числа");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
