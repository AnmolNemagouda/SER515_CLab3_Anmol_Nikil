package solid3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Smell1AlmostBestTest {

    @Test
    void testPositiveBoundary() {
        System.out.println("Running testPositiveBoundary: Testing 2^3...");
        int result = Smell1AlmostBest.toPower(2, 3);
        System.out.println("Result: " + result);
        assertEquals(8, result, "3rd power of 2 should equal 8");
    }

    @Test
    void testZeroExponent() {
        System.out.println("Running testZeroExponent: Testing 5^0 and -3^0...");
        int result1 = Smell1AlmostBest.toPower(5, 0);
        System.out.println("Result for 5^0: " + result1);
        assertEquals(1, result1, "5^0 should equal 1");

        int result2 = Smell1AlmostBest.toPower(-3, 0);
        System.out.println("Result for -3^0: " + result2);
        assertEquals(1, result2, "-3^0 should equal 1");
    }

    @Test
    void testCacheUsage() {
        System.out.println("Running testCacheUsage: Testing cache with 2^3...");
        int result1 = Smell1AlmostBest.toPower(2, 3);
        System.out.println("First call result: " + result1);

        int result2 = Smell1AlmostBest.toPower(2, 3);
        System.out.println("Second call result (from cache): " + result2);

        assertEquals(result1, result2, "Cache should return the same result");
    }

    @Test
    void testLargeExponent() {
        System.out.println("Running testLargeExponent: Testing 2^31.....");
        assertThrows(ArithmeticException.class,
                () -> Smell1AlmostBest.toPower(2,31),
                        "Large exponents may cause overflow");
    }

    @Test
    void testBaseOne() {
        System.out.println("Running testBaseOne: Testing 1^1000....");
        assertEquals(1, Smell1AlmostBest.toPower(1,1000), "1 raised to any power should be 1");
    }

    @Test
    void testNegativeBase() {
        System.out.println("Running testNegativeBase: Testing -2^3 and -2 ^4....");
        assertEquals(-8, Smell1AlmostBest.toPower(-2,3), "Result of Negative base with odd exponent should be negative");
        assertEquals(16, Smell1AlmostBest.toPower(-2,4), "Result of Negative base with even exponent should be positive");
    }

    @Test
    void testNegativeExponent() {
        System.out.println("Running testNegativeExponent: Testing 2^-1....");
        assertThrows(IllegalArgumentException.class,
                () -> Smell1AlmostBest.toPower(2, -1),
                "Negative exponents should throw an exception");
    }

    @Test
    void testBaseZeroPositiveExponent() {
        System.out.println("Running testBaseZeroPositiveExponent: Testing 0^5...");
        assertEquals(0, Smell1AlmostBest.toPower(0,5), "0 raused to any positive power is 0");
    }

    @Test
    void testZeroBaseExponent() {
        System.out.println("Running testZeroBaseExponent: Testing 0^0...");
        assertEquals(1, Smell1AlmostBest.toPower(0,0), " 0th power of 0 should return 1");
    }
}
