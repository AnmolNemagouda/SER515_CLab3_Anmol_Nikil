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
    void testCaching() {
        System.out.println("Running testCaching: Testing if results are cached...");
        long start = System.nanoTime();
        int result1 = Smell1AlmostBest.toPower(3, 10);
        long end1 = System.nanoTime();
        
        long start2 = System.nanoTime();
        int result2 = Smell1AlmostBest.toPower(3, 10);
        long end2 = System.nanoTime();
        
        assertEquals(result1, result2, "Both calls should return the same result");
        assertTrue((end1 - start) > (end2 - start2), "Second call should be faster due to caching");
    }

    @Test
    void testMultipleCalls() {
        System.out.println("Running testMultipleCalls: Testing multiple calls with different exponents...");
        int base = 2;
        assertEquals(2, Smell1AlmostBest.toPower(base, 1), "2^1 should be 2");
        assertEquals(4, Smell1AlmostBest.toPower(base, 2), "2^2 should be 4");
        assertEquals(8, Smell1AlmostBest.toPower(base, 3), "2^3 should be 8");
        assertEquals(16, Smell1AlmostBest.toPower(base, 4), "2^4 should be 16");
    }

    @Test
    void testLargeBase() {
        System.out.println("Running testLargeBase: Testing with a large base...");
        assertThrows(ArithmeticException.class,
                () -> Smell1AlmostBest.toPower(Integer.MAX_VALUE, 2),
                "Large base may cause overflow");
    }
}