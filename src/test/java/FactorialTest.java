import jdk.jfr.Description;
import lesson_13.Factorial;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.testng.Assert.assertEquals;

public class FactorialTest {
    Factorial factorial = new Factorial();

    @Test
    public void testFactorialOfPositiveNumbers() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(factorial.calculateFactorial(1), 1, "��������� 1 ������ ���� ����� 1");
        softAssert.assertEquals(factorial.calculateFactorial(5), 120, "��������� 5 ������ ���� ����� 120");
        softAssert.assertEquals(factorial.calculateFactorial(12), 479001600, "��������� 12 ������ ���� ����� 479001600");

        softAssert.assertAll();
    }

    @Description("��������� ����")
    @Test
    public void testFactorialOfZero() {
        assertEquals(1, factorial.calculateFactorial(0), "��������� 0 ������ ���� ����� 1");
    }

    @Description("��������� ���������������� �����")
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        factorial.calculateFactorial(-1);
    }

    @Description("�������� �������")
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInputChar() {
        factorial.calculateFactorial('a');
    }
}
