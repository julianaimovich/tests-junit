import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    Calculator sut;

    @BeforeEach
    void setUp() {
        sut = Calculator.instance.get();
    }

    @Test
    public void numberIsPositiveTest() {
        // Arrange
        int positiveNumber = 2;
        int negativeNumber = -2;

        // Act
        boolean resultForPositive = sut.isPositive.test(positiveNumber);
        boolean resultForNegative = sut.isPositive.test(negativeNumber);

        // Assert
        Assertions.assertTrue(resultForPositive);
        Assertions.assertFalse(resultForNegative);
    }

    @Test
    public void additionTest() {
        // Arrange
        int a = 3;
        int b = 5;
        int c = 2;
        int sum = 8;

        // Act
        int actualWithB = sut.plus.apply(a, b);
        int actualWithC = sut.plus.apply(b, c);

        // Assert
        Assertions.assertEquals(sum, actualWithB);
        Assertions.assertNotEquals(sum, actualWithC);
    }

    @Test
    public void powTest() {
        // Arrange
        int a = 3;

        // Act
        int expected = (int) Math.pow(a, 2);
        int actual = sut.pow.apply(a);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void absTest() {
        // Arrange
        int a = -3;

        // Act
        int expected = Math.abs(a);
        int actual = sut.abs.apply(a);

        // Assert
        Assertions.assertEquals(expected, actual);
    }
}