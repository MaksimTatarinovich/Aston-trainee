package lesson_13_tests;

import static org.junit.jupiter.api.Assertions.*;
import lesson_13.Factorial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FactorialTest {
    Factorial factorial = new Factorial();

    @DisplayName("Факториал положительных чисел")
    @Test
    public void testFactorialOfPositiveNumbers() {
        assertAll(
                () -> assertEquals(1, factorial.calculateFactorial(1), "Факториал 1 должен быть равен 1"),
                () -> assertEquals(120, factorial.calculateFactorial(5), "Факториал 5 должен быть равен 120"),
                () -> assertEquals(479001600, factorial.calculateFactorial(12), "Факториал 12 должен быть равен 479001600")
        );
    }

    @DisplayName("Факториал нуля")
    @Test
    public void testFactorialOfZero() {
        assertEquals(1, factorial.calculateFactorial(0), "Факториал 0 должен быть равен 1");
    }

    @DisplayName("Факториал отрицальтельного числа")
    @Test
    public void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> factorial.calculateFactorial(-1));
        assertEquals("Невозможно высчитать факториал отрицательного числа", exception.getMessage());
    }

    @DisplayName("Передача символа")
    @Test
    public void testInputChar() {
        assertThrows(IllegalArgumentException.class, () -> factorial.calculateFactorial('a'),"Должно выбрасывать ошибку IllegalArgumentException");
    }
}
