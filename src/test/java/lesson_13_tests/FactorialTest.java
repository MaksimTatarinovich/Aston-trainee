package lesson_13_tests;

import static org.junit.jupiter.api.Assertions.*;
import lesson_13.Factorial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FactorialTest {
    Factorial factorial = new Factorial();

    @DisplayName("��������� ������������� �����")
    @Test
    public void testFactorialOfPositiveNumbers() {
        assertAll(
                () -> assertEquals(1, factorial.calculateFactorial(1), "��������� 1 ������ ���� ����� 1"),
                () -> assertEquals(120, factorial.calculateFactorial(5), "��������� 5 ������ ���� ����� 120"),
                () -> assertEquals(479001600, factorial.calculateFactorial(12), "��������� 12 ������ ���� ����� 479001600")
        );
    }

    @DisplayName("��������� ����")
    @Test
    public void testFactorialOfZero() {
        assertEquals(1, factorial.calculateFactorial(0), "��������� 0 ������ ���� ����� 1");
    }

    @DisplayName("��������� ���������������� �����")
    @Test
    public void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> factorial.calculateFactorial(-1));
        assertEquals("���������� ��������� ��������� �������������� �����", exception.getMessage());
    }

    @DisplayName("�������� �������")
    @Test
    public void testInputChar() {
        assertThrows(IllegalArgumentException.class, () -> factorial.calculateFactorial('a'),"������ ����������� ������ IllegalArgumentException");
    }
}
