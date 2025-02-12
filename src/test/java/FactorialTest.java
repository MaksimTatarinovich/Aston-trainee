import lesson_13.Factorial;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FactorialTest {
    Factorial factorial = new Factorial();

    @Test
    public void testFactorialOfPositiveNumbers() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(factorial.calculateFactorial(1), 1, "Факториал 1 должен быть равен 1");
        softAssert.assertEquals(factorial.calculateFactorial(5), 120, "Факториал 5 должен быть равен 120");
        softAssert.assertEquals(factorial.calculateFactorial(12), 479001600, "Факториал 12 должен быть равен 479001600");

        softAssert.assertAll();
    }

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(1, factorial.calculateFactorial(0), "Факториал 0 должен быть равен 1");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        factorial.calculateFactorial(-1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInputChar() {
        factorial.calculateFactorial('a');
    }
}
