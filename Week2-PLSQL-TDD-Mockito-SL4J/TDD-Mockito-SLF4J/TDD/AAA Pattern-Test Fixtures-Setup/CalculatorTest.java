import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("🔧 Setup: Calculator instance created.");
    }

    @After
    public void tearDown() {
        System.out.println("🧹 Teardown: Test completed.");
    }

    @Test
    public void testAdd() {
        int result = calculator.add(10, 5);
        assertEquals(15, result);
        System.out.println("✅ testAdd passed");
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(10, 5);
        assertEquals(5, result);
        System.out.println("✅ testSubtract passed");
    }

    @Test
    public void testMultiply() {
        int result = calculator.multiply(4, 3);
        assertEquals(12, result);
        System.out.println("✅ testMultiply passed");
    }

    @Test
    public void testDivide() {
        int result = calculator.divide(20, 4);
        assertEquals(5, result);
        System.out.println("✅ testDivide passed");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }
}
