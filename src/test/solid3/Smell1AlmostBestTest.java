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
}
